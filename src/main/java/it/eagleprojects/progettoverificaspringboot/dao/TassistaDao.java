package it.eagleprojects.progettoverificaspringboot.dao;

import it.eagleprojects.progettoverificaspringboot.model.Tassista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//SpringBoot fa lo scan automatico di tutte le entità dalla root del package
@Repository
public interface TassistaDao extends JpaRepository<Tassista, Integer> {


    //In questo modo con JpaRepository questa interfaccia sa fare molte cose (insert, delete, la find all
    // In più utilizzando la name convention dei metodi, sa fare alcune query automaticamente


    //Con questo modo questo metodo (scritto così rispettando la name convention)
    //fa automaticamente la query di trovare i record che hanno nome e cognome passati per parametro
    //List<Tassista> findByFirstNomeAndCognome(String nome, String cognome);

    //	@Query(value = "jpqlQuery...") //Per qeury magari non supportate di defualt dai metodi con name convention
    //	List<Tassista> faiQualcosa(String nome);

}
