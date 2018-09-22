package com.miglazer.stocklending.httptest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HTTPRequestTest {

    @LocalServerPort
    private int port;

    private HttpHeaders httpHeaders = new HttpHeaders();

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void equitiesShouldReturnEquities(){
        HttpEntity<List> httpEntity = new HttpEntity<>(null, httpHeaders);
        ResponseEntity<List> response = testRestTemplate.exchange(
                createURLWithPort("/securities/equities"),
                HttpMethod.GET, httpEntity, List.class);

        String expected = "{symbol:IBM,price:107.45},{symbol:MSFT,price:35.36}";

        assertThat(response.getHeaders().containsValue(expected));
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
