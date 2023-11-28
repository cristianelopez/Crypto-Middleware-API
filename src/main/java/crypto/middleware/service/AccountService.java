package crypto.middleware.service;


import crypto.middleware.dto.AccounCreateUserDTO;
import crypto.middleware.model.User;
import crypto.middleware.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;


    public AccounCreateUserDTO createUser(User user) {
        AccounCreateUserDTO accounCreate = new AccounCreateUserDTO();
        userRepository.save(user);
        accounCreate.setUserName(user.getEmail());

        return accounCreate;
    }

    public List<User> allUser() {
        return userRepository.findAll();
    }
}
