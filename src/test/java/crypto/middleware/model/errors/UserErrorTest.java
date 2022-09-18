package crypto.middleware.model.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserErrorTest {
    @Test
    void testUserErrorModel () {
        UserError error = new UserError("error");
        Assertions.assertEquals("error", error.getMessage());
    }
}