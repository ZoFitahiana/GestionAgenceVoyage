package com.application.Agence;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.application.Agence.Model.Client;
import com.application.Agence.Repository.ClientsDAO;
import com.application.Agence.Service.ClientService;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class TestClient implements InterfaceTestFactory {
    @Test
    @Override
    public void TestFindById() {
        ClientsDAO ClientDAO = mock(ClientsDAO.class);
        ClientService clientService = new ClientService(ClientDAO);

        Client client = new Client(1,"Tsiaro","Niaina","67ha","3456789","tsiaro@gmail.com");
        when(ClientDAO.FindById(1)).thenReturn(client);

        Client resultat = clientService.FindById(1);
        assertNotNull(resultat);

    }

    @Test
    @Override
    public void TestFindAll() {
        ClientsDAO ClientDAO = mock(ClientsDAO.class);
        ClientService clientService = new ClientService(ClientDAO);

        List<Client> clients = new ArrayList<>();
        clients.add(new Client(2,"Tsiaro","Niaina","67ha","3456789","tsiaro@gmail.com"));
        clients.add(new Client(1,"Tsiaro","Niaina","67ha","3456789","tsiaro@gmail.com"));

        when(ClientDAO.FindAll()).thenReturn(clients);

        List<Client> resultat = clientService.FindAll();
        assertNotNull(resultat);
        assertEquals(2, resultat.size());
    }

    @Override
    @Test
    public void TestPost() {
        ClientsDAO ClientDAO = mock(ClientsDAO.class);
        ClientService clientService = new ClientService(ClientDAO);

        Client client = new Client(2,"Tsiaro","Niaina","67ha","3456789","tsiaro@gmail.com");
        when(ClientDAO.Register(client)).thenReturn(client);

        Client resultat = clientService.Register(client);
        assertNotNull(resultat);

    }

    @Override
    @Test
    public void TestUpdate() {
        ClientsDAO ClientDAO = mock(ClientsDAO.class);
        ClientService clientService = new ClientService(ClientDAO);

        int id = 1;
        Client client = new Client(id,"Tsiaro","Niaina","67ha","3456789","tsiaro@gmail.com");
        when(ClientDAO.Update(id,client)).thenReturn(client);

        Client resultat = clientService.Update(id,client);
        assertNotNull(resultat);
    }

    @Override
    @Test
        public void TestDelete() {
            ClientsDAO ClientDAO = mock(ClientsDAO.class);
            int id = 1;
            ClientDAO.Delete(id);
            verify(ClientDAO).Delete(eq(id));
    }

}
