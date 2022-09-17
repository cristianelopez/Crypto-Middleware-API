package crypto.middleware.service.initializer;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crypto.middleware.model.Account;
import crypto.middleware.model.dtos.UserCreateDTO;
import crypto.middleware.service.AccountService;


@Service
@Transactional
public class InitServiceInMemory {

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;

    @Autowired
    private AccountService userService;

    @PostConstruct
    public void initialize()  {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
            fireInitialData();
        }
    }

    private void fireInitialData() {
      //  User user = new User("Pepe", "Pepa", "email@gmail.com", "San Martin 185", "unaPassw123??", "1234567891234567891234", "12345678");
       
        userService.createUser( new UserCreateDTO("Cristian", "Lopez", "cristianelopez@gmail.com", "4", "1111", "aaa", "bb"));
        userService.createUser( new UserCreateDTO("Cristian2", "Lopez2", "cristianelopez2@gmail.com", "44", "11114", "bbbbb", "ccccc"));
    
    }
}
