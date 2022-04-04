package dar.kz.academy.clientcoreapi.controller;

import dar.kz.academy.clientcoreapi.model.ClientModel;
import dar.kz.academy.clientcoreapi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<String> createClient(@Valid @RequestBody ClientModel clientModel){
        clientService.createClient(clientModel);
        return new ResponseEntity<>("Successfully created", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ClientModel getClient(@PathVariable String id){
        return clientService.getClientById(id);
    }

    @GetMapping("/all")
    public List<ClientModel> getAllClient(){
        return clientService.getAllClient();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateClient(@PathVariable String id, @Valid @RequestBody ClientModel clientModel){
        clientService.updateClient(id, clientModel);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable String id){
        clientService.deleteClient(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
