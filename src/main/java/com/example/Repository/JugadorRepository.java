package com.example.Repository;

import com.example.Model.Jugador;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by usu32 on 19/10/2016.
 */
public interface JugadorRepository extends PagingAndSortingRepository<Jugador, Long> {

    public List<Jugador> findByNombreStartingWith(String nombre);
    public List<Jugador> findByCanastasGreaterThanEqual(Integer canastas);
    public List<Jugador> findByAsistenciasBetween(Integer min, Integer max);
    public List<Jugador> findByPosicion(String posicion);
    public List<Jugador> findByFechaNacimientoBefore(LocalDate fechaNacimiento);

    @Query("Select jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes) " +
            "from Jugador jugador " +
            "GROUP BY jugador.posicion")
    public List<Jugador> showAverageStatisticsByPosition();

    @Query("Select jugador.posicion, AVG(jugador.canastas), MAX(jugador.canastas), MIN(jugador.canastas), " +
            "AVG(jugador.asistencias), MAX(jugador.asistencias), MIN(jugador.asistencias), " +
            "AVG(jugador.rebotes), MAX(jugador.rebotes), MIN(jugador.rebotes)" +
            "from Jugador jugador " +
            "GROUP BY jugador.posicion")
    public List<Jugador> showAverageAndMaxAndMinStatiscsByPosition();

}
