package com.cinemaPractic.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.repositories.SessionRepository;
import com.cinemaPractic.demo.service.SessionService;


@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Transactional
    @Override
    public void createSession(Session session) {
        sessionRepository.createSession(session);
    }

    @Override
    public Session findSessionWithAvailableSeats(int id) {
        return sessionRepository.findSessionWithAvailableSeats(id);
    }

    @Override
    public Session bookSeat(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bookSeat'");
    }

    @Override
    public Session findAlternativeSession(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAlternativeSession'");
    }


}
