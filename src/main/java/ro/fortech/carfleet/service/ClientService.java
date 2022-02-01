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

  public void save(Client client) {
    clientRepository.save(client);
  }

  public List<Client> findAll() {
    return clientRepository.findAll();
  }

  public Optional<Client> findById(int id) {
    return clientRepository.findById(id);
  }

  public void deleteById(int id) {
    clientRepository.deleteById(id);
  }

  public void updateById(UpdateClient updateClient) {
    Optional<Client> client = findById(updateClient.getId());
    Optional<Address> address = addressService.findById(updateClient.getAddressId());
    if (client.isPresent()) {
      client.get().setAge(updateClient.getAge());
      client.get().setName(updateClient.getName());
      address.ifPresent(value -> client.get().setAddress(value));
      clientRepository.save(client.get());
    }
  }
}
