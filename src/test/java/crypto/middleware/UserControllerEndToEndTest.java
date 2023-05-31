package crypto.middleware;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import crypto.middleware.webservice.CryptoController;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UserControllerEndToEndTest {

	private static final String HTTP_LOCALHOST = "http://localhost:";

	
	//@Value("${server.port:8090}")
	@LocalServerPort
	private int port;
	
	@Autowired
	private CryptoController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
    private WebTestClient webClient;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void getCrypoValueTest() throws Exception {
		webClient.get().uri("/api/crypto/getCrypoValue/all");
	//	assertThat(this.restTemplate.getForObject(HTTP_LOCALHOST + port + "/api/crypto/getCrypoValue/all",
		//		String.class)).contains("cryptos");
	
	}

}
