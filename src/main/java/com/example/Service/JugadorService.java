package com.example.Service;

import com.example.Model.Jugador;
import com.example.Repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
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

    public void testJugador(){
        LocalDate date = LocalDate.of(1994,3,8);
        Jugador jugador1 = new Jugador("Pau", date, 30, 5, 10, "Alero");
        //equipo = equipoRepository.findByNombre("Lakers").get(0);
        //jugador1.setEquipo(equipo);
        jugadorRepository.save(jugador1);

        date = LocalDate.of(1990,5,10);
        Jugador jugador2 = new Jugador("Juan", date, 25, 7, 12, "Pivot");
        jugadorRepository.save(jugador2);

        date = LocalDate.of(1992,8,12);
        Jugador jugador3 = new Jugador("Alfredo", date, 35, 3, 11, "Ala-Pivot");
        jugadorRepository.save(jugador3);

        date = LocalDate.of(1986,3,2);
        Jugador jugador4 = new Jugador("Francesc", date, 43, 10, 5, "Base");
        jugadorRepository.save(jugador4);

        date = LocalDate.of(1991,9,9);
        Jugador jugador5 = new Jugador("Albert", date, 25, 7, 12, "Pivot");
        jugadorRepository.save(jugador5);

        System.out.println(jugadorRepository.findByNombreStartingWith("Ju"));
        System.out.println(jugadorRepository.findByCanastasGreaterThanEqual(30));
        System.out.println(jugadorRepository.findByAsistenciasBetween(6, 10));
        System.out.println(jugadorRepository.findByPosicion("Base"));
        date = LocalDate.of(1990,1,1);
        System.out.println(jugadorRepository.findByFechaNacimientoBefore(date));
        System.out.println(jugadorRepository.showAverageStatisticsByPosition());
        System.out.println(jugadorRepository.showAverageAndMaxAndMinStatiscsByPosition());
    }
}
