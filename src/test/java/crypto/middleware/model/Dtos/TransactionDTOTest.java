package crypto.middleware.model.Dtos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import crypto.middleware.model.dtos.TransactionDTO;

class TransactionDTOTest {
    @Test
    void testTransactionDTOModel() {
        TransactionDTO dto = new TransactionDTO(2L, "dateAndTime", "crypto",10f,10f,
                10f,"type","Pepe", 0, "SinOperaciones");

        Assertions.assertEquals(2L, dto.getId());
        Assertions.assertEquals("crypto", dto.getCrypto());
        Assertions.assertEquals(10f, dto.getAmountOfCrypto());
        Assertions.assertEquals(10f, dto.getPriceOfCrypto());
        Assertions.assertEquals(10f, dto.getPriceInARS());
        Assertions.assertEquals("type", dto.getTransactionType());
        Assertions.assertEquals("Pepe", dto.getUserFullName());
    }

    @Test
    void testEmptyConstructor() {
        TransactionDTO dto = new TransactionDTO();
        dto.setTransactionType("type");
        dto.setCrypto("crypto");
        dto.setId(2L);
        dto.setAmountOfCrypto(10f);
        dto.setPriceInARS(10f);
        dto.setPriceOfCrypto(10f);
        dto.setUserFullName("Pepe");

        Assertions.assertEquals(2L, dto.getId());
        Assertions.assertEquals("crypto", dto.getCrypto());
        Assertions.assertEquals(10f, dto.getAmountOfCrypto());
        Assertions.assertEquals(10f, dto.getPriceOfCrypto());
        Assertions.assertEquals(10f, dto.getPriceInARS());
        Assertions.assertEquals("type", dto.getTransactionType());
        Assertions.assertEquals("Pepe", dto.getUserFullName());
    }
}