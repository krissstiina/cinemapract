package com.cinemaPractic.demo;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cinemaPractic.demo.entites.User;
import com.cinemaPractic.demo.model.CreateCinemaDTO;
import com.cinemaPractic.demo.model.CreateFilmDTO;
import com.cinemaPractic.demo.model.CreateHallDTO;
import com.cinemaPractic.demo.model.CreateSessionDTO;
import com.cinemaPractic.demo.model.CreateTicketDTO;
import com.cinemaPractic.demo.model.CreateUserDTO;
import com.cinemaPractic.demo.service.CinemaService;
import com.cinemaPractic.demo.service.FilmService;
import com.cinemaPractic.demo.service.HallService;
import com.cinemaPractic.demo.service.SessionService;
import com.cinemaPractic.demo.service.TicketService;
import com.cinemaPractic.demo.service.UserService;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private FilmService filmService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private UserService userService;

    @Autowired
    private HallService hallService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void run(String... args) throws Exception {
        CreateFilmDTO filmDTO = new CreateFilmDTO("Леон", "боевик", "Люк Бессон", 1994, 8);
        filmService.create(filmDTO);
        CreateFilmDTO film2 = new CreateFilmDTO("Король лев", "мультфильм", "Роб Минкофф", 1994, 8.5);
        filmService.create(film2);
        CreateFilmDTO film3 = new CreateFilmDTO("Титаник", "мелодрамма", "Джеймс Кэмерон", 1997, 8.2);
        filmService.create(film3);
        CreateFilmDTO film4 = new CreateFilmDTO("Головолмка", "мультфильм", "Пит Доктер", 2015, 8.1);
        filmService.create(film4);
        CreateFilmDTO film5 = new CreateFilmDTO("Рик и морти", "мультфильм", "Пит Мишелс", 2013, 9);
        filmService.create(film5);
        CreateFilmDTO film6 = new CreateFilmDTO("Джентельмены", "боевик", "Гай Ричи", 2019, 9);
        filmService.create(film6);

        CreateUserDTO user1 = new CreateUserDTO("Кристина", "Зубрицкая", "Константиновна", "89042763542", 0);
        userService.create(user1);

        User user = new User(user1.getName(), user1.getSurname(), user1.getMiddleName(), user1.getPhoneNumber(), user1.getPoints());

        CreateCinemaDTO cinema1 = new CreateCinemaDTO("Моховая, 9", "Миля", "Жулебино");
        cinemaService.create(cinema1);

        CreateHallDTO hall1 = new CreateHallDTO(110, 1);
        hallService.create(hall1);

        CreateSessionDTO session = new CreateSessionDTO(new Date(124, 04, 01, 1, 32, 0), 1, 2, 2);
        sessionService.create(session);
        CreateSessionDTO session1 = new CreateSessionDTO(new Date(124, 10, 01, 1, 32, 0), 1, 2, 100);
        sessionService.create(session1);

        CreateTicketDTO ticket = new CreateTicketDTO(700, 1, 1);
        ticketService.create(ticket);

        //Рекомендации фильмов
        System.out.println(filmService.getRecommendations(user));

        //Бронирование места
        System.out.println(sessionService.bookSeat(1));

    }

}