package com.cinemaPractic.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.HallDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.service.SessionService;


@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public SessionDTO create(CreateSessionDTO sessionCreateDto) {
        Session session = mapper.map(sessionCreateDto, Session.class);
        sessionRepository.create(session);
        return mapper.map(session, SessionDTO.class);
    }

    @Override
    public SessionDTO findById(int id) {
        Optional<Session> session = sessionRepository.findById(id);


        return mapper.map(session, SessionDTO.class);
    }
    
    @Override
    public SessionDTO bookSeat(int sessionId) {
        Optional<Session> sessionOptional = sessionRepository.findById(sessionId);
        if (sessionOptional.isPresent()) {
            Session session = sessionOptional.get();
            if (session.getAvailableSeats() > 0) {

                session.setAvailableSeats(session.getAvailableSeats() - 1);
                sessionRepository.update(session);
                return mapper.map(session, SessionDTO.class);
            } else {
                
                List<Session> alternativeSessions = sessionRepository.findSessionsWithAvailableSeatsForFilm(session.getFilm().getId());
                if (!alternativeSessions.isEmpty()) {
                    Collections.sort(alternativeSessions, Comparator.comparingInt(Session::getAvailableSeats).reversed());
                    Session alternativeSession = alternativeSessions.get(0);
                    return mapper.map(alternativeSession,SessionDTO.class);
                } else {
                    
                    return null;
                }
            }
        } else {

            return null;
        }
    }

}
