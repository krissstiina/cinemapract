package com.cinemaPractic.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.service.SessionService;


@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    private ModelMapper modelMapper = new ModelMapper();
    
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
