package dar.kz.academy.clientcoreapi.controller;

import dar.kz.academy.clientcoreapi.model.ClientModel;
import dar.kz.academy.clientcoreapi.model.ClientRequest;
import dar.kz.academy.clientcoreapi.model.ClientResponse;
import dar.kz.academy.clientcoreapi.service.old.ClientService;
import dar.kz.academy.clientcoreapi.service.working.NewClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    NewClientService clientService;

    @PostMapping
    public ResponseEntity<ClientResponse> createClient(@Valid @RequestBody ClientRequest clientRequest){
        return new ResponseEntity<ClientResponse>(clientService.createClient(clientRequest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ClientResponse getClient(@PathVariable String id){
        return clientService.findClientById(id);
    }

    @GetMapping("/all")
    public List<ClientResponse> getAllClient(){
        return clientService.findAllClients();
    }

    @PutMapping
    public ResponseEntity<ClientResponse> updateClient(@Valid @RequestBody ClientRequest clientModel){
        return new ResponseEntity<>(clientService.updateClient(clientModel), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String id){
        clientService.deleteClientById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
