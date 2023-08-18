package com.application.Agence.Service;

import com.application.Agence.Model.Client;
import com.application.Agence.Repository.ClientsDAO;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;
@Data
@Service
public class ClientService {

    private ClientsDAO clients;

    public ClientService(ClientsDAO clients) {
        this.clients = clients;
    }

    public Client FindByIdClient(int id){return clients.FindById(id);}

    public List<Client> FindAllClient(){
       return clients.FindAll();
    }
    public Client AddClient(Client entity){
        return clients.Register(entity);
    }
    public Client UpdateClient(int id,Client client){
        return clients.Update(id ,client);
    }
    public Client UpdateColumnClient(int id , Client client){
        return clients.UpdatePartial(id , client);
    }
    public  List<Client> DeleteClient(int id ){
        return clients.Delete(id);
    }
}
