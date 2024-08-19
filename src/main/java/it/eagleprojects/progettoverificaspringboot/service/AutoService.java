package it.eagleprojects.progettoverificaspringboot.service;

import it.eagleprojects.progettoverificaspringboot.dao.AutoDao;
import it.eagleprojects.progettoverificaspringboot.dao.TassistaDao;
import it.eagleprojects.progettoverificaspringboot.model.Auto;
import it.eagleprojects.progettoverificaspringboot.model.Tassista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoService {

    @Autowired
    AutoDao autoDao;


    public List<Auto> getAll(){
        return autoDao.findAll(); //l'oggetto TassistaDao ha già molti metodi perché appunto estende JpaRepository
    }

    public Auto getAutoById(Long id) throws Exception{
        Integer idInt = id.intValue();
        if(autoDao.findById(idInt).isPresent()){
            return autoDao.findById(idInt).get();
        }
        throw new Exception("Non esiste una Auto con id = "+idInt);
    }

    public Auto addNew(Auto a) {
        return autoDao.save(a);
    }

    public Auto updateAutoById(Long id, Auto autoRequest) throws Exception {
        Integer idInt = id.intValue();
        if(autoDao.findById(idInt).isPresent()){
            Auto autoDaAggiornare = autoDao.findById(idInt).get();
            if(autoRequest.getTarga() == null){
                autoRequest.setTarga(autoDaAggiornare.getTarga());
            }

            if(autoRequest.getMarca() == null){
                autoRequest.setMarca(autoDaAggiornare.getMarca());
            }

            if(autoRequest.getModello() == null){
                autoRequest.setModello(autoDaAggiornare.getModello());
            }

            if(autoRequest.getTassista() == null){
                autoRequest.setTassista(autoDaAggiornare.getTassista());
            }

            autoDao.save(autoRequest);
            return autoRequest;
        }

        throw new Exception("Non esiste una Auto con id = "+idInt);
    }

    public void deleteAutoById(Long id) throws Exception{
        Integer idInt = id.intValue();
        if(autoDao.findById(idInt).isPresent()){
            autoDao.deleteById(idInt);
        }
        throw new Exception("Non esiste una Auto con id = "+idInt);
    }

    public void deleteAll(){
        autoDao.deleteAll();
    }

}
