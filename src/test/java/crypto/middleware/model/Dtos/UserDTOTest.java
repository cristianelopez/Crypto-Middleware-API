package crypto.middleware.model.Dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import crypto.middleware.model.dtos.UserDTO;

class UserDTOTest {

    @Test
    void testUserDTOModel() {
        UserDTO dto = new UserDTO(1L,"name","surname");

        Assertions.assertEquals(1L, dto.getId());
        Assertions.assertEquals("name", dto.getName());
        Assertions.assertEquals("surname", dto.getSurname());
    }

    @Test
    void testEmptyConstructor() {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setName("name");
        dto.setSurname("surname");

        Assertions.assertEquals(1L, dto.getId());
        Assertions.assertEquals( "name", dto.getName());
        Assertions.assertEquals("surname", dto.getSurname());
    }

}