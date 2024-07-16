package com.cinemaPractic.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.exception.SessionNotFoundException;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.UpdateSessionDTO;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.service.SessionService;


@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Override
    public SessionDTO create(CreateSessionDTO sessionDTO) {
        Session session = modelMapper.map(sessionDTO,Session.class);
        sessionRepository.create(session);
        return modelMapper.map(session, SessionDTO.class);
    }

    @Override
    public void delete(int id) {
        sessionRepository.delete(id);
    }

    @Override
    public void save(Session session){
        sessionRepository.save(session);
    }

    @Override
    public Optional<SessionDTO> findById(int id){
        Optional<Session> session = sessionRepository.findById(id);
        if (!session.isPresent()){
            throw new SessionNotFoundException();
        }
        return Optional.of(modelMapper.map(session,SessionDTO.class));
    }

    @Override
    public SessionDTO update(UpdateSessionDTO sessionDTO) {
        Optional <Session> session = sessionRepository.findById(sessionDTO.id);
        if (!session.isPresent()){
            throw new SessionNotFoundException();
        }
        sessionRepository.update(session.get());
        return modelMapper.map(session,SessionDTO.class);
    }

    @Override
    public List<SessionDTO> findAll() {
        return sessionRepository.findAll().stream().map((session) -> modelMapper.map(session,SessionDTO.class)).toList();
    }
    
    @Override
    public Session bookSeat(int sessionId) {
        Optional<Session> sessionOptional = sessionRepository.findById(sessionId);
        if (sessionOptional.isPresent()) {
            Session session = sessionOptional.get();
            // Проверка доступности мест
            if (session.getAvailableSeats() > 0) {
                // Бронирование места
                session.setAvailableSeats(session.getAvailableSeats() - 1);
                sessionRepository.save(session);
                return session;
            } else {
                // Предложение альтернативных сеансов
                List<Session> alternativeSessions = sessionRepository.findSessionsWithAvailableSeatsForFilm(session.getFilm().getId());
                if (!alternativeSessions.isEmpty()) {
                    Collections.sort(alternativeSessions, Comparator.comparingInt(Session::getAvailableSeats).reversed());
                    Session alternativeSession = alternativeSessions.get(0);
                    return alternativeSession;
                } else {
                    // Если нет альтернативных сеансов, вернуть null
                    return null;
                }
            }
        } else {
            // Сеанс не найден, вернуть null
            return null;
        }
    }

}
