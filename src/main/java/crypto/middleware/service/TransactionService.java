package crypto.middleware.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import crypto.middleware.helpers.CurrentDateTime;
import crypto.middleware.model.Account;
import crypto.middleware.model.Transaction;
import crypto.middleware.model.dtos.TransactionCreateDTO;
import crypto.middleware.model.dtos.TransactionDTO;
import crypto.middleware.repositories.TransactionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public TransactionService() {
        //Empty constructor
    }

    @Transactional
    public List<Transaction> getTransactions(){
        return this.transactionRepository.findAll();
    }

    @Transactional
    public Transaction findTransaction(Long id){return  transactionRepository.findById(id).get();
    }

    @Transactional
    public Transaction createTransaction(TransactionCreateDTO transaction, Account user) {

        Transaction newTransaction = new Transaction(CurrentDateTime.getNewDateString(), transaction.getCrypto(), transaction.getAmountOfCrypto(),transaction.getPriceOfCrypto(),
                                                    user,transaction.getTransactionType());
        return this.transactionRepository.save(newTransaction);
    }

    public List<Transaction> getTransactionsByUserId(Long id) {
        return this.transactionRepository.getTransactionsByUserId(id);
    }


    public List<TransactionDTO> processTransactionsToDTO(List<Transaction> retrievedTransactions) {
        List<TransactionDTO> transactionDTOS = new ArrayList<>();

        retrievedTransactions.stream().forEach((transaction) -> {
            transactionDTOS.add(new TransactionDTO(transaction.getId(), transaction.getDateAndTime(), transaction.getCrypto(), transaction.getAmountOfCrypto(),
                    transaction.getPriceOfCrypto(), transaction.getPriceInARS(), transaction.getTransactionType(),
                    transaction.getUser().getName() + " " + transaction.getUser().getSurname(), transaction.getUser().getOperationsNumber(),
                    transaction.getUser().getScore()));
        });
        return transactionDTOS;
    }

    public void deleteTransaction(Long id) {
        this.transactionRepository.deleteById(id);
    }
}
