package crypto.middleware.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import crypto.middleware.model.Account;
import crypto.middleware.model.Transaction;

class TransactionTest {

    Account user = new Account("Pepe", "Garcia", "pepe@gmail.com",
            "Cordoba 5300", "pepegarcia123", "0848843953963586953104", "20532062");

    @Test
    void testTransactionModel() {
        Transaction transaction = new Transaction("dateAndTime", "crypto",
                10f, 10f, user, "transactionType");

        Assertions.assertEquals("dateAndTime", transaction.getDateAndTime());
        Assertions.assertEquals("crypto", transaction.getCrypto());
        Assertions.assertEquals(10f, transaction.getAmountOfCrypto());
        Assertions.assertEquals(10f, transaction.getPriceOfCrypto());
        Assertions.assertEquals(transaction.getUser(), user);
        Assertions.assertEquals("transactionType", transaction.getTransactionType());
    }

    @Test
    void testEmptyConstructor() {
        Transaction transaction = new Transaction();
        transaction.setDateAndTime("dateAndTime");
        transaction.setCrypto("crypto");
        transaction.setAmountOfCrypto(10f);
        transaction.setPriceOfCrypto(10f);
        transaction.setUser(user);
        transaction.setTransactionType("transactionType");
        transaction.setPriceInARS(10f);

        Assertions.assertEquals("dateAndTime", transaction.getDateAndTime());
        Assertions.assertEquals("crypto", transaction.getCrypto());
        Assertions.assertEquals(10f, transaction.getAmountOfCrypto());
        Assertions.assertEquals(10f, transaction.getPriceOfCrypto());
        Assertions.assertEquals(transaction.getUser(), user);
        Assertions.assertEquals("transactionType", transaction.getTransactionType());
        Assertions.assertEquals(10f, transaction.getPriceInARS());
    }
}