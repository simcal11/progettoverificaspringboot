package it.eagleprojects.progettoverificaspringboot.dao;

import it.eagleprojects.progettoverificaspringboot.model.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//SpringBoot fa lo scan automatico di tutte le entità dalla root del package
@Repository
public interface AutoDao extends JpaRepository<Auto, Integer> {

}
