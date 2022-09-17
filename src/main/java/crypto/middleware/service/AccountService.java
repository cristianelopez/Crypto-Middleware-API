package crypto.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crypto.middleware.model.Account;
import crypto.middleware.model.dtos.UserCreateDTO;
import crypto.middleware.model.errors.UserAlreadyExists;
import crypto.middleware.model.errors.UserError;
import crypto.middleware.model.errors.UserNotFound;
import crypto.middleware.repositories.UserRepository;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AccountService {
    @Autowired
    UserRepository userRepository;

    public AccountService() {
        //Empty constructor
    }

    @Transactional
    public ArrayList<Account> getAccounts(){
        return (ArrayList<Account>) this.userRepository.findAll();
    }

    @Transactional
    public Account findUser(Long id){
        return  userRepository.findById(id).orElseThrow(UserNotFound::new);
    }


    @Transactional
    public Account createUser(UserCreateDTO usuario) {
        if(userAlreadyExists(usuario)){
            throw new UserAlreadyExists();
        }
        if(this.isValidUser(usuario)){
            Account user = new Account(usuario.getName(), usuario.getSurname(), usuario.getEmail(), usuario.getAddress(),
                                 usuario.getPassword(), usuario.getCvu(), usuario.getWallet());
            return this.userRepository.save(user);
        }
        throw new UserError("One or more fields are incorrect");
    }

    public boolean isValidUser(UserCreateDTO user) {
//        return  validate(user.getName(), "^[a-zA-Z]{3,30}$") &&
//                validate(user.getSurname(), "^[a-zA-Z ]{3,30}$") &&
//                validate(user.getEmail(), "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9.]+(?:\\.[a-zA-Z0-9-]+)*$") &&
//                validate(user.getAddress(), "^[a-zA-Z0-9 ]{10,30}$") &&
//                validate(user.getPassword(), "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=.])(?=\\S+$).{6,}$") &&
//                validate(user.getCvu(), "^[a-zA-Z0-9]{22}$") &&
//                validate(user.getWallet(), "^[a-zA-Z0-9]{8}$");
    	return true;
    }

    public boolean userAlreadyExists(UserCreateDTO user){
       return userRepository.existWallet(user.getWallet());
    }



    public boolean validate(String string, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return matcher.matches();
    }

    @Transactional
    public void deleteUser(Long id){
        Account user = this.findUser(id);
        this.userRepository.deleteById(user.getId());
    }
}
