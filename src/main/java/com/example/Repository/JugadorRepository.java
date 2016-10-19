package com.example.Repository;

import com.example.Model.Jugador;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by usu32 on 19/10/2016.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    public List<Jugador> findByNombreStartingWith(String nombre);
    public List<Jugador> findByNumCanastasGreaterThanEqual(Integer numCanastas);
    public List<Jugador> findByNumAsistenciasBetween(Integer min, Integer max);
    public List<Jugador> findByPosicion(String posicion);
    public List<Jugador> findByFechaNacimientoBefore(LocalDate fechaNacimiento);

    @Query("Select jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes) " +
            "from Jugador jugador " +
            "GROUP BY jugador.posicion")
    public List<Jugador> showStatisticsByPosition();

    /**
     * Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente información:
     * la media de canastas, asistencias y rebotes.
     *
     * Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de canastas, asistencias y rebotes.

     */
}
