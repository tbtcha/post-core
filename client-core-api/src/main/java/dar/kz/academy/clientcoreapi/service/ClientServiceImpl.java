package dar.kz.academy.clientcoreapi.service;

import dar.kz.academy.clientcoreapi.model.ClientModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService{
    private static final HashMap<String, ClientModel> clientMap = new HashMap<>();

    static {
        ClientModel clientModel1 = new ClientModel(UUID.randomUUID().toString(), "Ruslan", "Baydildinov", "rbaydildinov@gmail.com");
        ClientModel clientModel2 = new ClientModel(UUID.randomUUID().toString(), "Beksultan", "Melis uluu", "beks@gmail.com");
        ClientModel clientModel3 = new ClientModel(UUID.randomUUID().toString(), "Nikita", "Kagan", "nkagan@gmail.com");
        clientMap.put(clientModel1.getId(),clientModel1);
        clientMap.put(clientModel2.getId(),clientModel2);
        clientMap.put(clientModel3.getId(),clientModel3);
    }

    @Override
    public void createClient(ClientModel clientModel) {
        clientModel.setId(UUID.randomUUID().toString());
        clientMap.put(clientModel.getId(),clientModel);
    }

    @Override
    public List<ClientModel> getAllClient() {
        return new ArrayList<>(clientMap.values());
    }

    @Override
    public ClientModel getClientById(String id) {
        return clientMap.get(id);
    }

    @Override
    public void updateClient(String id, ClientModel clientModel) {
        clientModel.setId(id);
        clientMap.put(clientModel.getId(), clientModel);
    }

    @Override
    public void deleteClient(String id) {
        clientMap.remove(id);
    }
}
