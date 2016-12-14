package com.example.Service;

import com.example.Model.Equipo;
import com.example.Model.Jugador;
import com.example.Repository.EquipoRepository;
import com.example.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Created by usu32 on 19/10/2016.
 */
@Service
@Transactional
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    public void testJugador(){

        Equipo equipo1 = equipoRepository.findOne(1L);
        Equipo equipo2 = equipoRepository.findOne(2L);
        Equipo equipo3 = equipoRepository.findOne(3L);
        Equipo equipo4 = equipoRepository.findOne(4L);
        Equipo equipo5 = equipoRepository.findOne(5L);

        LocalDate date = LocalDate.of(1994,3,8);
        Jugador jugador1 = new Jugador("Pau", date, 30, 5, 10, "Alero", equipo1);
        jugadorRepository.save(jugador1);

        date = LocalDate.of(1990,5,10);
        Jugador jugador2 = new Jugador("Juan", date, 25, 7, 12, "Pivot", equipo2);
        jugadorRepository.save(jugador2);

        date = LocalDate.of(1992,8,12);
        Jugador jugador3 = new Jugador("Alfredo", date, 35, 3, 11, "Ala-Pivot", equipo3);
        jugadorRepository.save(jugador3);

        date = LocalDate.of(1986,3,2);
        Jugador jugador4 = new Jugador("Francesc", date, 43, 10, 5, "Base", equipo4);
        jugadorRepository.save(jugador4);

        date = LocalDate.of(1991,9,9);
        Jugador jugador5 = new Jugador("Albert", date, 25, 7, 12, "Escolta", equipo5);
        jugadorRepository.save(jugador5);

        System.out.println(jugadorRepository.findByNombreStartingWith("Al"));
        System.out.println(jugadorRepository.findByCanastasGreaterThanEqual(30));
        System.out.println(jugadorRepository.findByAsistenciasBetween(6,9));
        System.out.println(jugadorRepository.findByPosicion("Escolta"));
        date = LocalDate.of(1990,1,1);
        System.out.println(jugadorRepository.findByFechaNacimientoBefore(date));
        System.out.println(jugadorRepository.showAverageStatisticsByPosition());
        System.out.println(jugadorRepository.showAverageMaxMinStatisticsByPosition());
    }
}
