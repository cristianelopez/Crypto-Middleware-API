package crypto.middleware.model.Errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import crypto.middleware.model.errors.UserError;

class UserErrorTest {
    @Test
    void testUserErrorModel () {
        UserError error = new UserError("error");
        Assertions.assertEquals("error", error.getMessage());
    }
}