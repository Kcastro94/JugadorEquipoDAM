package com.example.Service;

import com.example.Model.Equipo;
import com.example.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Created by usu32 on 07/11/2016.
 */
@Service
@Transactional
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public void testEquipo(){
        LocalDate date = LocalDate.of(1960,3,8);
        Equipo equipo1 = new Equipo("Equipo1", "Localidad1", date);
        equipoRepository.save(equipo1);

        date = LocalDate.of(1970, 5, 10);
        Equipo equipo2 = new Equipo("Equipo2", "Localidad2", date);
        equipoRepository.save(equipo2);

        date = LocalDate.of(1920, 1, 2);
        Equipo equipo3 = new Equipo("Equipo3", "Localidad3", date);
        equipoRepository.save(equipo3);

        date = LocalDate.of(1935, 12, 5);
        Equipo equipo4 = new Equipo("Equipo4", "Localidad4", date);
        equipoRepository.save(equipo4);

        date = LocalDate.of(1970, 5, 10);
        Equipo equipo5 = new Equipo("Equipo5", "Localidad5", date);
        equipoRepository.save(equipo5);

        System.out.println(equipoRepository.findByLocalidad("Localidad1"));
        System.out.println(equipoRepository.findJugadoresByEquipo("Equipo1"));
        System.out.println(equipoRepository.findJugadoresByEquipoAndPosicion("Equipo2", "Pivot"));
        System.out.println(equipoRepository.findByCanastasAndEquipo("Equipo3"));
    }
}
