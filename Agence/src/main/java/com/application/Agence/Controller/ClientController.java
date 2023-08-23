package com.application.Agence.Controller;

import com.application.Agence.Model.Client;
import com.application.Agence.Service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class ClientController {
    private  ClientService clients;

    public ClientController(ClientService clients) {
        this.clients = clients;
    }

    @GetMapping("/client/{id}")
    public Client ShowClientById(@PathVariable int id){
        return clients.FindById(id);
    }

    @GetMapping("/client")
    public List<Client> showAllClient(){
        return clients.FindAll();
    }

    @PostMapping("/post-client")
    public  Client RegisterClient( @RequestBody Client entity){
        return clients.Register(entity);
    }

    @PutMapping("/update-client/{id}")
    public Client udpdateClient(@PathVariable int id , @RequestBody  Client client){
        return clients.Update(id,client);
    }

    @PatchMapping("/update-partial-client/{id}")
    public Client updateClientPartial(@PathVariable int id , @RequestBody Client client){
        return  clients.UpdatePartial(id,client);
    }

    @DeleteMapping("/delete-client/{id}")
    public List<Client> DeleteClient(@PathVariable int id){
        return clients.Delete(id);
    }

}
