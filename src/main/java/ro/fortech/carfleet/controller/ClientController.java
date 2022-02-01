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
  public ResponseEntity<String> save(@RequestBody ClientDto clientDto) {
    clientService.save(clientMapper.clientDtoToClient(clientDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping
  public List<ClientDto> findAll() {
    return clientMapper.clientToClientDto(clientService.findAll());
  }

  @GetMapping("/{id}")
  public Optional<ClientDto> findById(@PathVariable("id") int id) {
    Optional<Client> client = clientService.findById(id);

    return client.map(clientMapper::clientToClientDto);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable("id") int id) {
    clientService.deleteById(id);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateById(
      @PathVariable("id") int id, @RequestBody UpdateClientDto updateClientDto) {
    updateClientDto.setId(id);
    clientService.updateById(clientMapper.updateClientDtoToUpdateClient(updateClientDto));

    return new ResponseEntity<>(HttpStatus.OK);
  }
}
