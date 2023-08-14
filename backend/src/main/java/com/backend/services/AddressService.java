package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.daos.IAddressDao;
import com.backend.daos.IUserDAO;
import com.backend.pojos.AddressPOJO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IAddressService;

@Service
@Transactional
public class AddressService implements IAddressService {

    @Autowired
    private IAddressDao addressDao;

    @Autowired
    private IUserDAO userDAO;

    @Override
    public String addAddress(AddressPOJO address) {
        String message = "Invalid Address, can't be added!!";

        UserPOJO user = userDAO.findById(1l).get();
        if (address.addUser(user)) {
            AddressPOJO persistedAddress = addressDao.save(address);
            message = "Address added successfully with address_id = " + persistedAddress.getAddressId();

        }
        // if(null != persistedAddress){
        // }
        return message;
    }

}
