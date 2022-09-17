package crypto.middleware.webservice;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import crypto.middleware.model.*;
import crypto.middleware.model.dtos.UserCreateDTO;
import crypto.middleware.model.errors.UserError;
import crypto.middleware.service.AccountService;
import crypto.middleware.service.TransactionService;

import java.util.*;

@Api(tags = "Account services")
@Tag(name = "Account services", description = "Manage Accounts")
@RestController
@Transactional
@RequestMapping("/api")
public class AccountController {
	
	
    @Autowired
    private AccountService accountService;
    
    @Autowired
    private TransactionService transactionService;

    @Operation(summary = "Get all accounts enabled in the Bulk upated backend tool")
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>>  getAccounts(){
        return ResponseEntity.ok().body(accountService.getAccounts());
    }

    @Operation(summary = "Get Account")
    @GetMapping("/accounts/{id}")
    public ResponseEntity<Account> getUserByID(@Parameter(description = "The account ID that needs to be fetched", required = true)
                                                @PathVariable Long id){
        Account userFound = accountService.findUser(id);
        return ResponseEntity.ok().body(userFound);
    }

    @Operation(summary = "Register account")
    @PostMapping(path="/addAccount" , consumes = "application/json", produces = "application/json")
    public Account createUser(@Parameter(description = "The account to be registered", required = true)
                               @RequestBody UserCreateDTO user) throws UserError{
        return this.accountService.createUser(user);
    }

    @Operation(summary = "Delete Account")
    @DeleteMapping("/deleteAccount /{id}")
    public void deleteUser(@Parameter(description = "The account ID to be deleted", required = true)
                               @PathVariable Long id){
        List<Transaction> transactionsByID = this.transactionService.getTransactionsByUserId(id);
        if(!transactionsByID.isEmpty()) {
            transactionsByID.forEach(transaction -> this.transactionService.deleteTransaction(transaction.getId()));
        }else{
            this.accountService.deleteUser(id);
        }
    }
}




