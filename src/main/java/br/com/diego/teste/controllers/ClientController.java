package br.com.diego.teste.controllers;

import br.com.diego.teste.models.ClientModel;
import br.com.diego.teste.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ClientController {

    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientModel>> findAll(){
        List<ClientModel> list = clientService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientModel> findbyId(@PathVariable Long id){
        ClientModel obj = this.clientService.findById(id);
        return ResponseEntity.ok().body( obj);
    }

}
