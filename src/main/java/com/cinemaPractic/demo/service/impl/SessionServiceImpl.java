package com.cinemaPractic.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.exception.FilmNotFoundException;
import com.cinemaPractic.demo.exception.HallNotFoundException;
import com.cinemaPractic.demo.exception.SessionNotFoundException;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.model.UpdateSessionDTO;
import com.cinemaPractic.demo.repositories.FilmRepository;
import com.cinemaPractic.demo.repositories.HallRepository;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.service.SessionService;


@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private HallRepository hallRepository;

    @Autowired
    private FilmRepository filmRepository;

    private ModelMapper modelMapper;
    public SessionServiceImpl(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    @Override
    public SessionDTO create(CreateSessionDTO sessionDTO) {
        Hall hall = hallRepository.findById(sessionDTO.getHall()).orElseThrow(() -> new HallNotFoundException());
        Film film = filmRepository.findById(sessionDTO.getFilm()).orElseThrow(() -> new FilmNotFoundException());
        
        Session session = new Session(sessionDTO.getDate(),hall, film, sessionDTO.getAvailableSeats());
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
    public SessionDTO update(UpdateSessionDTO updateSessionDTO) {
        Optional<Session> session = sessionRepository.findById(updateSessionDTO.getId());
        if (!session.isPresent()) {
            throw new SessionNotFoundException();
        }

        if(updateSessionDTO.getHall() != 0) {
            Hall hall = hallRepository.findById(updateSessionDTO.getHall()).orElseThrow(() -> new HallNotFoundException());
            session.get().setHall(hall);
        }

        if (updateSessionDTO.getFilm() != 0) {
            Film film = filmRepository.findById(updateSessionDTO.getFilm()).orElseThrow(() -> new FilmNotFoundException());
            session.get().setFilm(film);
        }

        session.get().setDate(updateSessionDTO.getDate());
        session.get().setAvailableSeats(updateSessionDTO.getAvailableSeats());
        sessionRepository.update(session.get());

        return modelMapper.map(session, SessionDTO.class);
    }


    

    @Override
    public List<SessionDTO> findAll() {
        return sessionRepository.findAll().stream().map((session) -> modelMapper.map(session,SessionDTO.class)).toList();
    }
    
    @Override
    public SessionDTO bookSeat(int sessionId) {
        Optional<Session> sessionOptional = sessionRepository.findById(sessionId);
        if (sessionOptional.isPresent()) {
            Session session = sessionOptional.get();
            if (session.getAvailableSeats() > 0) {

                session.setAvailableSeats(session.getAvailableSeats() - 1);
                sessionRepository.update(session);
                return modelMapper.map(session, SessionDTO.class);
            } else {
                
                List<Session> alternativeSessions = sessionRepository.findSessionsWithAvailableSeatsForFilm(session.getFilm().getId());
                if (!alternativeSessions.isEmpty()) {
                    Collections.sort(alternativeSessions, Comparator.comparingInt(Session::getAvailableSeats).reversed());
                    Session alternativeSession = alternativeSessions.get(0);
                    return modelMapper.map(alternativeSession,SessionDTO.class);
                } else {
                    
                    return null;
                }
            }
        } else {

            return null;
        }
    }

}
