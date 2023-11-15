package com.sertec.crudEF.practicasspringRB.repositorio;

import com.sertec.crudEF.practicasspringRB.modelo.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo,Integer> {

}
