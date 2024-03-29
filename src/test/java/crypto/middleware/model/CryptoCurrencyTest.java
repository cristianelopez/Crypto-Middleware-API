package crypto.middleware.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CryptoCurrencyTest {

    @Test
    void testCryptoCurrencyModel() {
        CryptoCurrency crypto = new CryptoCurrency("symbol", 10f, "date");

        Assertions.assertEquals("symbol", crypto.getSymbol());
        Assertions.assertEquals(10f, crypto.getPrice());
        Assertions.assertEquals("date", crypto.getLastUpdateDateAndTime());
    }

    @Test
    void testEmptyConstructor() {
    	 CryptoCurrency crypto = new CryptoCurrency("symbol", 10f, "date");


        Assertions.assertEquals("symbol", crypto.getSymbol());
        Assertions.assertEquals(10f, crypto.getPrice());
        Assertions.assertEquals("date", crypto.getLastUpdateDateAndTime());
    }
}

class CryptoCurrencyListTest {
    @Test
    void testCryptoCurrencyListModel() {
        CryptoCurrencyList cryptoList = new CryptoCurrencyList();
   	 CryptoCurrency crypto = new CryptoCurrency("symbol", 10f, "date");
        cryptoList.addCrypto(crypto);

        Assertions.assertTrue(cryptoList.cryptos.contains(crypto));
    }
}