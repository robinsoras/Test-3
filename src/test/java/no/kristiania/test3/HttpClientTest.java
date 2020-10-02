package no.kristiania.test3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpClientTest {

    @Test
    void shouldReadSuccesStatusCode() {
        HttpClient httpClient = new HttpClient("urlecho.appspot.com", 80, "/echo?status=200");
        assertEquals(200, httpClient.getResponseCode());
    }

    @Test
    void shouldReadFailureStatusCode() {
        HttpClient httpClient = new HttpClient("urlecho.appspot.com", 80, "/echo?status=401");
        assertEquals(401, httpClient.getResponseCode());
    }
}