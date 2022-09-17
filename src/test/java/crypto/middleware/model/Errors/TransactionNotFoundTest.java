package crypto.middleware.model.Errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import crypto.middleware.model.errors.TransactionNotFound;

class TransactionNotFoundTest {
    @Test
    void testTransactionNotFoundModel () {
        TransactionNotFound error = new TransactionNotFound("error");
        Assertions.assertEquals("error", error.getMessage());
    }
}