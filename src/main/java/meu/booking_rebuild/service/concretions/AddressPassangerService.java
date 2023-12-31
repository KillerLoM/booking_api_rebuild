package meu.booking_rebuild.service.concretions;

import meu.booking_rebuild.model.AddressModel;
import meu.booking_rebuild.model.PassangerModel;
import meu.booking_rebuild.repository.AddressRepository;
import meu.booking_rebuild.repository.PassangersRepository;
import meu.booking_rebuild.request.AddressPassangerRequest;
import meu.booking_rebuild.request.GetAddressRequest;
import meu.booking_rebuild.request.PassangerTripRequest;
import meu.booking_rebuild.response.GetAddressResponse;
import meu.booking_rebuild.service.abstractions.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class AddressPassangerService implements IAddressService {
    @Autowired
    private PassangersRepository passangersRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public AddressModel createAddress(AddressPassangerRequest request) {
        PassangerModel model = passangersRepository.findPassangerModelById(request.getPassanger_id());
        AddressModel addressModel = new AddressModel(
                request.getName(),
                request.getLongitude(),
                request.getLatitude(),
                model
        );
        return addressRepository.save(addressModel);
    }

    @Override
    public GetAddressResponse getAddressByPhone(String phone) {
       PassangerModel model = passangersRepository.getPassangerModelByPhone(phone);
       AddressModel addressModel =  addressRepository.getAddressModelByUserId(model.getId());
       GetAddressResponse response = new GetAddressResponse(addressModel.getName(), model.getPhone(), model.getName());
       return response;
    }
}
