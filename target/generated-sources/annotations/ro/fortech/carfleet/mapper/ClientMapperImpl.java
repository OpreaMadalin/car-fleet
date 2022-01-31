package ro.fortech.carfleet.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.AddressDto;
import ro.fortech.carfleet.dto.ClientDto;
import ro.fortech.carfleet.dto.UpdateClientDto;
import ro.fortech.carfleet.model.Address;
import ro.fortech.carfleet.model.Client;
import ro.fortech.carfleet.service.business.UpdateClient;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-31T12:19:55+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDto clientToClientDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDto clientDto = new ClientDto();

        clientDto.setId( client.getId() );
        clientDto.setAge( client.getAge() );
        clientDto.setName( client.getName() );
        clientDto.setAddress( addressToAddressDto( client.getAddress() ) );

        return clientDto;
    }

    @Override
    public Client clientDtoToClient(ClientDto clientDto) {
        if ( clientDto == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDto.getId() );
        client.setAge( clientDto.getAge() );
        client.setName( clientDto.getName() );
        client.setAddress( addressDtoToAddress( clientDto.getAddress() ) );

        return client;
    }

    @Override
    public List<ClientDto> listClientToListClientDto(List<Client> client) {
        if ( client == null ) {
            return null;
        }

        List<ClientDto> list = new ArrayList<ClientDto>( client.size() );
        for ( Client client1 : client ) {
            list.add( clientToClientDto( client1 ) );
        }

        return list;
    }

    @Override
    public UpdateClient updateClientDtoToUpdateClient(UpdateClientDto updateClientDtoDto) {
        if ( updateClientDtoDto == null ) {
            return null;
        }

        UpdateClient updateClient = new UpdateClient();

        updateClient.setId( updateClientDtoDto.getId() );
        updateClient.setAge( updateClientDtoDto.getAge() );
        updateClient.setName( updateClientDtoDto.getName() );
        updateClient.setAddressId( updateClientDtoDto.getAddressId() );

        return updateClient;
    }

    protected AddressDto addressToAddressDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setId( address.getId() );
        addressDto.setStreetNumber( address.getStreetNumber() );
        addressDto.setStreetName( address.getStreetName() );
        addressDto.setCountry( address.getCountry() );

        return addressDto;
    }

    protected Address addressDtoToAddress(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDto.getId() );
        address.setStreetNumber( addressDto.getStreetNumber() );
        address.setStreetName( addressDto.getStreetName() );
        address.setCountry( addressDto.getCountry() );

        return address;
    }
}
