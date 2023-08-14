package com.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.daos.IAddressDao;
import com.backend.daos.IUserDAO;
import com.backend.pojos.UserPOJO;
import com.backend.services.interfaces.IUserService;

@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    private IUserDAO userDAO;

    @Autowired
    private IAddressDao addressDao;

    @Override
    public String addUser(UserPOJO user) {
        // StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        // if(stackTrace.length >= 3){
        //     StackTraceElement caller = stackTrace[2];
        //     StackTraceElement currMethod = stackTrace[1];
        //     System.out.println("in "+getClass() + ", "+currMethod.getMethodName());System.out.println("Called from "+ caller.getClassName() + ", "+caller.getMethodName());
        // }
        
        String message = "User cannot be added";
        UserPOJO persistedUser = userDAO.save(user);
        if(null != persistedUser){
            message = "User added successfully with user_id = "+persistedUser.getUserId() + " user_name = "+persistedUser.getFirstName()+" email = "+persistedUser.getUserEmail();
        }
        return message;
    }
    
}
