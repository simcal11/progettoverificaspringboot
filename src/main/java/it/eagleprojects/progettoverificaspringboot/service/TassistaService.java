package it.eagleprojects.progettoverificaspringboot.service;

import it.eagleprojects.progettoverificaspringboot.dao.TassistaDao;
import it.eagleprojects.progettoverificaspringboot.model.Tassista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TassistaService {

    @Autowired
    TassistaDao tassistaDao;


    public List<Tassista> getAll(){
        return tassistaDao.findAll(); //l'oggetto TassistaDao ha già molti metodi perché appunto estende JpaRepository
    }

    public Tassista getTassistaById(Long id) throws Exception{
        Integer idInt = id.intValue();
        if(tassistaDao.findById(idInt).isPresent()){
            return tassistaDao.findById(idInt).get();
        }
        throw new Exception("Non esiste un Tassista con id = "+idInt);
    }

    public Tassista addNew(Tassista t) {
        return tassistaDao.save(t);
    }

    public Tassista updateTassistaById(Long id, Tassista tassistaRequest) throws Exception {
        Integer idInt = id.intValue();
        if(tassistaDao.findById(idInt).isPresent()){
            Tassista tassistaDaAggiornare = tassistaDao.findById(idInt).get();
            if(tassistaRequest.getNome() == null){
                tassistaRequest.setNome(tassistaDaAggiornare.getNome());
            }

            if(tassistaRequest.getCognome() == null){
                tassistaRequest.setCognome(tassistaDaAggiornare.getCognome());
            }

            if(tassistaRequest.getAuto() == null){
                tassistaRequest.setAuto(tassistaDaAggiornare.getAuto());
            }

            tassistaDao.save(tassistaRequest);
            return tassistaRequest;
        }

        throw new Exception("Non esiste un Tassista con id = "+idInt);
    }

    public void deleteTassistaById(Long id) throws Exception{
        Integer idInt = id.intValue();
        if(tassistaDao.findById(idInt).isPresent()){
            tassistaDao.deleteById(idInt);
        }
        throw new Exception("Non esiste un Tassista con id = "+idInt);
    }

    public void deleteAll(){
        tassistaDao.deleteAll();
    }

}
