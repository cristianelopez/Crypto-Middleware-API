package crypto.middleware.webservice;


import crypto.middleware.dto.AccounCreateUserDTO;
import crypto.middleware.model.Role;
import crypto.middleware.model.User;
import crypto.middleware.model.exceptions.UserNotFoundException;
import crypto.middleware.repositories.RoleRepository;
import crypto.middleware.service.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Transactional
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @Operation(summary = "Register account")
    @PostMapping(path="/role" , consumes = "application/json", produces = "application/json")
   public Role createRole(
                              @RequestBody Role role){
        return this.roleRepository.save(role);
    }

    @Operation(summary = "Register account")
    @GetMapping (path="/role" , produces = "application/json")
    public List<Role> listRoles() throws UserNotFoundException {
        return this.roleRepository.findAll();
    }
}
