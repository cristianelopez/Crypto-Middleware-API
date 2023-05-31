package crypto.middleware.webservice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import crypto.middleware.helpers.CurrentDateTime;
import crypto.middleware.model.CryptoCurrency;
import crypto.middleware.model.CryptoCurrencyEnum;
import crypto.middleware.model.CryptoCurrencyList;
import crypto.middleware.model.exceptions.UserNotFoundException;
import crypto.middleware.service.CryptoService;
import crypto.middleware.service.integration.BinanceProxyService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Api(tags = "CryptoCurrency services")
@Tag(name = "CryptoCurrency services", description = "Manage cryptocurrencies")
@RestController
@Transactional
@RequestMapping("/api/crypto")
public class CryptoController {
	
	
	@Autowired
	CryptoService cryptoService;

	@Autowired
	BinanceProxyService binanceProxyService;

	@Operation(summary = "Get a cryptocurrency price")
	@GetMapping("/getCrypoValue/{symbol}")
	public ResponseEntity<CryptoCurrency> getCryptoCurrencyValue(
			@Parameter(description = "The cryptocurrency symbol that needs to be fetched", required = true) @PathVariable String symbol) {
		CryptoCurrency entity = binanceProxyService.getCryptoCurrencyValue(symbol);

		SimpleDateFormat formatter = CurrentDateTime.getNewDateFormatter();
		if (entity != null) {
			entity.setLastUpdateDateAndTime(formatter.format(new Date()));
		}
		return ResponseEntity.ok().body(entity);
	}

	@Operation(summary = "Get all cryptocurrency prices")
	@GetMapping("/getCrypoValue/all")
	public ResponseEntity<CryptoCurrencyList> getAllCryptoCurrencyPrices() {
		CryptoCurrencyList list = new CryptoCurrencyList();
		for (CryptoCurrencyEnum crypto : CryptoCurrencyEnum.values()) {
			CryptoCurrency entity = binanceProxyService.getCryptoCurrencyValue(crypto.name());
			
			if (entity != null) {
				entity.setLastUpdateDateAndTime(CurrentDateTime.getNewDateString());
			}
			list.addCrypto(entity);

		}
		return ResponseEntity.ok().body(list);
	}

	

//    @Operation(summary = "Register account")
//    @PostMapping(path="/addAccount" , consumes = "application/json", produces = "application/json")
//    public AccounCreateUserDTO createUser(@Parameter(description = "The account to be registered", required = true)
//                               @RequestBody User user) throws UserNotFoundException{
//        return this.accountService.createUser(user);
//    }
//
//    @Operation(summary = "Delete Account")
//    @DeleteMapping("/deleteAccount /{id}")
//    public void deleteUser(@Parameter(description = "The account ID to be deleted", required = true)
//                               @PathVariable Long id){
//        List<Transaction> transactionsByID = this.transactionService.getTransactionsByUserId(id);
//        if(!transactionsByID.isEmpty()) {
//            transactionsByID.forEach(transaction -> this.transactionService.deleteTransaction(transaction.getId()));
//        }else{
//            this.accountService.deleteUser(id);
//        }
 //   }
}
