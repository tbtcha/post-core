package dar.kz.academy.clientcoreapi.service.working;

import dar.kz.academy.clientcoreapi.model.ClientRequest;
import dar.kz.academy.clientcoreapi.model.ClientResponse;
import dar.kz.academy.clientcoreapi.repository.ClientEntity;
import dar.kz.academy.clientcoreapi.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class NewClientServiceImpl implements NewClientService{
    @Autowired
    ClientRepo clientRepo;
    ModelMapper modelMapper;

    public NewClientServiceImpl(){
        modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }


    @Override
    public ClientResponse createClient(ClientRequest clientRequest) {
        clientRequest.setClientId(UUID.randomUUID().toString());
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        clientEntity = clientRepo.save(clientEntity);
        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public ClientResponse updateClient(ClientRequest clientRequest) {
        ClientEntity clientEntity = modelMapper.map(clientRequest, ClientEntity.class);
        ClientEntity dbEntity = clientRepo.getClientEntityByClientId(clientEntity.getClientId());
        clientEntity.setClientId(dbEntity.getClientId());
        clientEntity = clientRepo.save(clientEntity);
        return modelMapper.map(clientEntity,ClientResponse.class);
    }

    @Override
    public ClientResponse findClientById(String clientId) {
        ClientEntity clientEntity = clientRepo.getClientEntityByClientId(clientId);
        return modelMapper.map(clientEntity, ClientResponse.class);
    }

    @Override
    public List<ClientResponse> findAllClients() {
        return clientRepo.getClientEntitiesBy().stream().map(client -> modelMapper.map(client, ClientResponse.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteClientById(String clientId) {
        clientRepo.deleteByClientId(clientId);
    }
}
