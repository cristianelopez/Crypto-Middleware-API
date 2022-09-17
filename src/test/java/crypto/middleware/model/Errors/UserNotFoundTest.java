package crypto.middleware.model.Errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import crypto.middleware.model.errors.UserNotFound;

import static org.junit.jupiter.api.Assertions.*;

class UserNotFoundTest {
    @Test
    void testUserNotFoundModel () {
        UserNotFound error = new UserNotFound();
        Assertions.assertEquals("There is not a registered user with that ID", error.getMessage());
    }
}