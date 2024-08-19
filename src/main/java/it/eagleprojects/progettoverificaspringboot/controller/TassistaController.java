package it.eagleprojects.progettoverificaspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import it.eagleprojects.progettoverificaspringboot.model.Tassista;
import it.eagleprojects.progettoverificaspringboot.service.TassistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Marca l'oggetto come controller e evita di scrivere ResponseBody, sa già che sarà quindi una controller rest
@RequestMapping({"/api"}) //L'array è perché si possono un array di url
public class TassistaController {

    @Autowired
    TassistaService tassistaService;

    @Operation(summary = "Metodo che permette di ottenere tutti i Tassisti nel repository")
    @GetMapping (value = "/tassista", produces = "application/json")//Specifica per la request GET
    public @ResponseBody List<Tassista> getAll(){
        return tassistaService.getAll();
    }

    @Operation(summary = "Metodo che permette di ottenere un Tassista con un id specificato")
    @GetMapping (value = "/tassista/${id}", produces = "application/json")
    public @ResponseBody Tassista getTassistaById(@PathVariable(value = "id") Long id) throws Exception {
        return tassistaService.getTassistaById(id);
    }

    @Operation(summary = "Metodo che permette di salvare un nuovo Tassista")
    @PostMapping(value = "/tassista", consumes = "application/json", produces = "application/json")
    public @ResponseBody Tassista create(@Parameter(description = "L'istanza del Tassista da salvare") @RequestBody Tassista t) {
        return tassistaService.addNew(t);
    }

    @Operation(summary = "Metodo che permette di modificare un Tassista con un id specificato")
    @PutMapping (value = "/tassista/${id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Tassista getTassistaById(@PathVariable(value = "id") Long id, @RequestBody Tassista tassistaRequest) throws Exception {
        return tassistaService.updateTassistaById(id, tassistaRequest);
    }

    @Operation(summary = "Metodo che permette di eliminare un Tassista con un id specificato")
    @DeleteMapping (value = "/tassista/${id}")
    public void deleteTassistaById(@PathVariable(value = "id") Long id) throws Exception {
        tassistaService.deleteTassistaById(id);
    }

    @Operation(summary = "Metodo che permette di eliminare tutti i Tassisti nel repository")
    @DeleteMapping (value = "/tassista")//Specifica per la request GET
    public void deleteAll(){
        tassistaService.deleteAll();
    }

}
