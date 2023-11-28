package crypto.middleware.webservice;


import crypto.middleware.model.Role;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Transactional
@RequestMapping("/login")
public class LoginController {

    @Operation(summary = "Register account")
    @PostMapping(path="/authentication" , consumes = "application/json", produces = "application/json")
    public void authentication(
            @RequestBody Role role){

    }
}
