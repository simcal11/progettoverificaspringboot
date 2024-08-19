package it.eagleprojects.progettoverificaspringboot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import it.eagleprojects.progettoverificaspringboot.model.Auto;
import it.eagleprojects.progettoverificaspringboot.model.Tassista;
import it.eagleprojects.progettoverificaspringboot.service.AutoService;
import it.eagleprojects.progettoverificaspringboot.service.TassistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Marca l'oggetto come controller e evita di scrivere ResponseBody, sa già che sarà quindi una controller rest
@RequestMapping({"/api"})
public class AutoController {

    @Autowired
    AutoService autoService;

    @Operation(summary = "Metodo che permette di ottenere tutti le Auto nel repository")
    @GetMapping(value = "/auto", produces = "application/json")//Specifica per la request GET
    public @ResponseBody List<Auto> getAll(){
        return autoService.getAll();
    }

    @Operation(summary = "Metodo che permette di ottenere una Auto con un id specificato")
    @GetMapping (value = "/auto/${id}", produces = "application/json")
    public @ResponseBody Auto getAutoById(@PathVariable(value = "id") Long id) throws Exception {
        return autoService.getAutoById(id);
    }

    @Operation(summary = "Metodo che permette di salvare una nuova Auto")
    @PostMapping(value = "/auto", consumes = "application/json", produces = "application/json")
    public @ResponseBody Auto create(@Parameter(description = "L'istanza dell'Auto da salvare") @RequestBody Auto a) {
        return autoService.addNew(a);
    }

    @Operation(summary = "Metodo che permette di modificare una Auto con un id specificato")
    @PutMapping (value = "/auto/${id}", consumes = "application/json", produces = "application/json")
    public @ResponseBody Auto getTassistaById(@PathVariable(value = "id") Long id, @RequestBody Auto autoRequest) throws Exception {
        return autoService.updateAutoById(id, autoRequest);
    }

    @Operation(summary = "Metodo che permette di eliminare una Auto con un id specificato")
    @DeleteMapping (value = "/auto/${id}")
    public void deleteAutoById(@PathVariable(value = "id") Long id) throws Exception {
        autoService.deleteAutoById(id);
    }

    @Operation(summary = "Metodo che permette di eliminare tutte le Auto nel repository")
    @DeleteMapping (value = "/auto")
    public void deleteAll(){
        autoService.deleteAll();
    }


}
