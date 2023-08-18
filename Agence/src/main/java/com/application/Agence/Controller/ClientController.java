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
       return clients.FindByIdClient(id);
    }

    @GetMapping("/client")
    public List<Client> showAllClient(){
      return    clients.FindAllClient();
    }

    @PostMapping("/PostClient")
    public  Client RegisterClient( @RequestBody Client entity){
        return clients.AddClient(entity);
    }

    @PutMapping("/UpdateClient/{id}")
    public Client udpdateClient(@PathVariable int id , @RequestBody  Client client){
        return clients.UpdateClient(id,client);
    }

    @PatchMapping("/updateClientPartial/{id}")
    public Client updateClientPartial(@PathVariable int id , @RequestBody Client client){
        return  clients.UpdateColumnClient(id,client);
    }

    @DeleteMapping("/DeleteClient/{id}")
    public List<Client> DeleteClient(@PathVariable int id){
        return clients.DeleteClient(id);
    }

}
