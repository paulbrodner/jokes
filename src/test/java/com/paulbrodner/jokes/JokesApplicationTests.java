package com.paulbrodner.jokes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JokesApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldReturn200WhenSendingRequestToController() throws Exception {
		ResponseEntity<Joke> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/joke", Joke.class);

		then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
