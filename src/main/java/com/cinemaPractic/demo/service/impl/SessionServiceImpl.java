package com.cinemaPractic.demo.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinemaPractic.demo.entites.Cinema;
import com.cinemaPractic.demo.entites.Film;
import com.cinemaPractic.demo.entites.Hall;
import com.cinemaPractic.demo.entites.Session;
import com.cinemaPractic.demo.exception.CinemaNotFoundException;
import com.cinemaPractic.demo.exception.FilmNotFoundException;
import com.cinemaPractic.demo.exception.HallNotFoundException;
import com.cinemaPractic.demo.exception.SessionNotFoundException;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.SessionDTO;
import com.cinemaPractic.demo.repositories.CinemaRepository;
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

    @Autowired
    private CinemaRepository cinemaRepository;


    @Autowired
    private ModelMapper mapper;

    @Override
    public SessionDTO create(CreateSessionDTO sessionDTO) {
        Hall hall = hallRepository.findById(sessionDTO.getHall()).orElseThrow(() -> new HallNotFoundException());
        Film film = filmRepository.findById(sessionDTO.getFilm()).orElseThrow(() -> new FilmNotFoundException());
        Cinema cinema = cinemaRepository.findById(sessionDTO.getCinema()).orElseThrow(() -> new CinemaNotFoundException());
        
        Session session = new Session(sessionDTO.getDate(),hall, film, cinema, sessionDTO.getAvailableSeats());
        sessionRepository.create(session);
        return mapper.map(session, SessionDTO.class);
    }


    @Override
    public Optional<SessionDTO> findById(int id){
        Optional<Session> session = sessionRepository.findById(id);
        if (!session.isPresent()){
            throw new SessionNotFoundException();
        }
        return Optional.of(mapper.map(session,SessionDTO.class));
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