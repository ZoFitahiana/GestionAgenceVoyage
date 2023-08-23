package com.application.Agence.Service;

import com.application.Agence.Model.Client;
import com.application.Agence.Repository.ClientsDAO;
import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.List;
@Data
@Service
public class ClientService  implements InterfaceService{

    private ClientsDAO clients;

    public ClientService(ClientsDAO clients) {
        this.clients = clients;
    }

    @Override
    public Client FindById(int id) {
        return clients.FindById(id);
    }

    @Override
    public List<Client> FindAll() {
        return clients.FindAll();
    }

    @Override
    public Client Register(Object entity) {
        Client client = (Client) entity ;
        return clients.Register(client);
    }

    @Override
    public Client Update(int id, Object entity) {
        Client client = (Client) entity ;
        return clients.Update(id,client);
    }

    @Override
    public Client UpdatePartial(int id, Object entity) {
        Client client = (Client) entity ;
        return clients.UpdatePartial(id, client);
    }

    @Override
    public List<Client> Delete(int id) {
        return clients.Delete(id);
    }
}
