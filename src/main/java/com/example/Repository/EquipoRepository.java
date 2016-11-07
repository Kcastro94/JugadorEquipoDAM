package com.example.Repository;

import com.example.Model.Equipo;
import com.example.Model.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by usu32 on 19/10/2016.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    public List<Equipo> findByLocalidad(String localidad);
    public List<Equipo> findByNombre(String nombre);

    /*mirar*/
    public List<Equipo> findByNombreAndPosicion(String nombre, String posicion);

    /*mirar*/
    @Query("Select jugador.nombre from Jugador jugador, Equipo equipo where jugador.equipo = equipo and MAX(jugador.canastas)")
    public List<Equipo> findJugadorByEquipoAndCanastas(String equipo);

    /**
     a.	Consulta los equipos existentes en una localidad determinada.
     b.	Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
     c.	Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
     d.	Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.

     */
}
