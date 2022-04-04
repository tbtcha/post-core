package dar.kz.academy.clientcoreapi.service;

import dar.kz.academy.clientcoreapi.model.ClientModel;

import java.util.List;

public interface ClientService {
    void createClient(ClientModel clientModel);
    List<ClientModel> getAllClient();
    ClientModel getClientById(String id);
    void updateClient(String id, ClientModel clientModel);
    void deleteClient(String id);
}
