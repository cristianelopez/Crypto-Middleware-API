package crypto.middleware.webservice;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import crypto.middleware.model.Account;
import crypto.middleware.model.Transaction;
import crypto.middleware.model.dtos.TransactionCreateDTO;
import crypto.middleware.model.dtos.TransactionDTO;
import crypto.middleware.service.AccountService;
import crypto.middleware.service.TransactionService;

import java.util.List;

@Api(tags = "Transaction services")
@Tag(name = "Transaction services", description = "Manage transactions")
@RestController
@Transactional
@RequestMapping("/api") //method = RequestMethod.GET)
public class TransactionController {
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private AccountService userService;

    @Operation(summary = "Get all transactions")
    @GetMapping("/transactions")
    public List<TransactionDTO> getTransactions(){
        return this.transactionService.processTransactionsToDTO(transactionService.getTransactions());
    }

    @Operation(summary = "Get user transactions")
    @GetMapping("/transactionsByUserId/{id}")
        public List<TransactionDTO> getTransactionsByUserId(@Parameter(description = "The user ID that needs to be fetched")
                                                                @PathVariable Long id) {
         transactionService.getTransactionsByUserId(id);
         return this.transactionService.processTransactionsToDTO(transactionService.getTransactionsByUserId(id));
    }

    @Operation(summary = "Create user transaction")
    @PostMapping(path="/addTransaction/user={userID}",  consumes = "application/json", produces = "application/json")
    public TransactionDTO createTransaction(@Parameter(description = "The user ID")
                                                @PathVariable Long userID,
                                            @Parameter(description = "The transaction to be registered")
                                            @RequestBody TransactionCreateDTO transaction) {
        Account user = this.userService.findUser(userID);
        String username = user.getName() + " " + user.getSurname();
        Transaction savedTransaction = transactionService.createTransaction(transaction,user);

        return new TransactionDTO(savedTransaction.getId(), savedTransaction.getDateAndTime(), savedTransaction.getCrypto(), savedTransaction.getAmountOfCrypto(),
                savedTransaction.getPriceOfCrypto(), savedTransaction.getPriceInARS(), savedTransaction.getTransactionType(),
                username, user.getOperationsNumber(), user.getScore());
    }

}