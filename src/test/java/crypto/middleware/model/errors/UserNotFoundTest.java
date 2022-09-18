package crypto.middleware.model.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserNotFoundTest {
    @Test
    void testUserNotFoundModel () {
        UserNotFound error = new UserNotFound();
        Assertions.assertEquals("There is not a registered user with that ID", error.getMessage());
    }
}