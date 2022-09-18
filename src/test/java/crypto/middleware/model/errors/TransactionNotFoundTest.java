package crypto.middleware.model.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TransactionNotFoundTest {
    @Test
    void testTransactionNotFoundModel () {
        TransactionNotFound error = new TransactionNotFound("error");
        Assertions.assertEquals("error", error.getMessage());
    }
}