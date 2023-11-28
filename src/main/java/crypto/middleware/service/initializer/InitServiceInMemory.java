package crypto.middleware.service.initializer;

import javax.annotation.PostConstruct;

import crypto.middleware.model.Role;
import crypto.middleware.model.User;
import crypto.middleware.repositories.RoleRepository;
import crypto.middleware.repositories.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class InitServiceInMemory {

    protected final Log logger = LogFactory.getLog(getClass());

    @Value("${spring.datasource.driverClassName:NONE}")
    private String className;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private AccountService userService;

    @PostConstruct
    public void initialize()  {
        if (className.equals("org.h2.Driver")) {
            logger.info("Init Data Using H2 DB");
            fireInitialData();
        }
    }

    private void fireInitialData() {
        Role roleAdmin = new Role("ADMIN");
        Role roleOperator = new Role("OPERATOR");
        roleAdmin = roleRepository.save(roleAdmin);
        roleOperator = roleRepository.save(roleOperator);
        User user = new User("Pepe", "Pepa", "pepe@gmail.com", "San Martin 185", "unaPassw123??", "1234567891234567891234", "12345678",roleAdmin);
        userRepository.save(user);
        user = new User("Pedro", "Pedro", "pedro@gmail.com", "San Martin 185", "unaPassw123??", "1234567891234567891234", "12345678",roleOperator);
        userRepository.save(user);
    }
}
