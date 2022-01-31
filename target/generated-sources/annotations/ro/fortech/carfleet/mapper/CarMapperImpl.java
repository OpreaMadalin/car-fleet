package ro.fortech.carfleet.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ro.fortech.carfleet.dto.AddressDto;
import ro.fortech.carfleet.dto.CarDto;
import ro.fortech.carfleet.dto.ClientDto;
import ro.fortech.carfleet.dto.UpdateCarDto;
import ro.fortech.carfleet.model.Address;
import ro.fortech.carfleet.model.Car;
import ro.fortech.carfleet.model.Client;
import ro.fortech.carfleet.service.business.UpdateCar;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-31T12:19:56+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car carDtoToCar(CarDto carDto) {
        if ( carDto == null ) {
            return null;
        }

        Car car = new Car();

        car.setId( carDto.getId() );
        car.setBrand( carDto.getBrand() );
        car.setModel( carDto.getModel() );
        car.setClient( clientDtoToClient( carDto.getClient() ) );

        return car;
    }

    @Override
    public CarDto carToCarDto(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDto carDto = new CarDto();

        carDto.setId( car.getId() );
        carDto.setBrand( car.getBrand() );
        carDto.setModel( car.getModel() );
        carDto.setClient( clientToClientDto( car.getClient() ) );

        return carDto;
    }

    @Override
    public List<CarDto> listCarToListCarDto(List<Car> car) {
        if ( car == null ) {
            return null;
        }

        List<CarDto> list = new ArrayList<CarDto>( car.size() );
        for ( Car car1 : car ) {
            list.add( carToCarDto( car1 ) );
        }

        return list;
    }

    @Override
    public UpdateCar updateCarDtoToUpdateCar(UpdateCarDto updateCarDto) {
        if ( updateCarDto == null ) {
            return null;
        }

        UpdateCar updateCar = new UpdateCar();

        updateCar.setId( updateCarDto.getId() );
        updateCar.setBrand( updateCarDto.getBrand() );
        updateCar.setModel( updateCarDto.getModel() );
        updateCar.setClientId( updateCarDto.getClientId() );

        return updateCar;
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

    protected Client clientDtoToClient(ClientDto clientDto) {
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

    protected ClientDto clientToClientDto(Client client) {
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
}
