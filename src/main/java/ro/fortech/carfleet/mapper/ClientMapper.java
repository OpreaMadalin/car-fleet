package ro.fortech.carfleet.mapper;

import org.mapstruct.Mapper;
import ro.fortech.carfleet.dto.ClientDto;
import ro.fortech.carfleet.dto.UpdateClientDto;
import ro.fortech.carfleet.model.Client;
import ro.fortech.carfleet.service.business.UpdateClient;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {
  ClientDto clientToClientDto(Client client);

  Client clientDtoToClient(ClientDto clientDto);

  List<ClientDto> listClientToListClientDto(List<Client> client);

  UpdateClient updateClientDtoToUpdateClient(UpdateClientDto updateClientDtoDto);
}
