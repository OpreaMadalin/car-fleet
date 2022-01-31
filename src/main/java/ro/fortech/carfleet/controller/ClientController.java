package ro.fortech.carfleet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.fortech.carfleet.dto.ClientDto;
import ro.fortech.carfleet.dto.UpdateClientDto;
import ro.fortech.carfleet.mapper.ClientMapper;
import ro.fortech.carfleet.model.Client;
import ro.fortech.carfleet.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

  private final ClientMapper clientMapper;
  private final ClientService clientService;

  @Autowired
  public ClientController(ClientMapper clientMapper, ClientService clientService) {
    this.clientMapper = clientMapper;
    this.clientService = clientService;
  }

  @PostMapping
  public ResponseEntity<String> addClient(@RequestBody ClientDto clientDto) {
    clientService.saveClient(clientMapper.clientDtoToClient(clientDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public List<ClientDto> findAllClients() {
    return clientMapper.listClientToListClientDto(clientService.getAllClients());
  }

  @GetMapping("/{id}")
  public Optional<ClientDto> findClientById(@PathVariable("id") int id) {
    Optional<Client> client = clientService.findById(id);

    return client.map(clientMapper::clientToClientDto);
  }

  @DeleteMapping("/{id}")
  public void deleteClientById(@PathVariable("id") int id) {
    clientService.deleteClientById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateClientById(
      @PathVariable("id") int id, @RequestBody UpdateClientDto updateClientDto) {
    updateClientDto.setId(id);
    clientService.updateClientById(clientMapper.updateClientDtoToUpdateClient(updateClientDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
