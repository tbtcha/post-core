package dar.kz.academy.clientcoreapi.service.working;

import dar.kz.academy.clientcoreapi.model.ClientRequest;
import dar.kz.academy.clientcoreapi.model.ClientResponse;
import dar.kz.academy.clientcoreapi.repository.ClientEntity;

import java.util.List;

public interface NewClientService {
    ClientResponse createClient(ClientRequest clientRequest);
    ClientResponse updateClient(ClientRequest clientRequest);
    ClientResponse findClientById(String clientId);
    List<ClientResponse> findAllClients();
    void deleteClientById(String clientId);
}
