package ro.fortech.carfleet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.fortech.carfleet.model.Address;
import ro.fortech.carfleet.model.Client;
import ro.fortech.carfleet.repository.ClientRepository;
import ro.fortech.carfleet.service.business.UpdateClient;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

  private final ClientRepository clientRepository;
  private final AddressService addressService;

  @Autowired
  public ClientService(ClientRepository clientRepository, AddressService addressService) {
    this.clientRepository = clientRepository;
    this.addressService = addressService;
  }

  public void saveClient(Client client) {
    clientRepository.save(client);
  }

  public List<Client> getAllClients() {
    return clientRepository.findAll();
  }

  public Optional<Client> findById(int id) {
    return clientRepository.findById(id);
  }

  public void deleteClientById(int id) {
    clientRepository.deleteById(id);
  }

  public void updateClientById(UpdateClient updateClient) {
    Optional<Client> client = findById(updateClient.getId());
    if (client.isPresent()) {
      client.get().setAge(updateClient.getAge());
      client.get().setName(updateClient.getName());
    }
    if (updateClient.hasAddressId()) {
      Optional<Address> optionalAddress = addressService.findById(updateClient.getAddressId());
      optionalAddress.ifPresent(address -> client.ifPresent(value -> value.setAddress(address)));
    }
    client.ifPresent(clientRepository::save);
  }
}
