package com.example.Repository;

import com.example.Model.Equipo;
import com.example.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by usu32 on 19/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    public List<Equipo> findByLocalidad(String localidad);

    @Query("select jugador from Jugador jugador, Equipo equipo where equipo.id = jugador.equipo and equipo.nombre = :nombreEquipo")
    public List<Jugador> findJugadoresByEquipo(@Param("nombreEquipo") String nombreEquipo);

    @Query("select jugador from Jugador jugador, Equipo equipo where equipo.id = jugador.equipo and equipo.nombre = :nombreEquipo and jugador.posicion = :posicionJugador")
    public List<Jugador> findJugadoresByEquipoAndPosicion(@Param("nombreEquipo") String nombreEquipo, @Param("posicionJugador") String jugadorPosicion);

    @Query("select jugador from Jugador jugador, Equipo equipo where equipo.id = jugador.equipo and equipo.nombre = :nombreEquipo order by canastas desc")
    public List<Jugador> findByCanastasAndEquipo(@Param("nombreEquipo") String nombreEquipo);
}
