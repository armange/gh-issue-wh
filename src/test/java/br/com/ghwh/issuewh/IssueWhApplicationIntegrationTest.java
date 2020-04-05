package br.com.ghwh.issuewh;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IssueWhApplicationIntegrationTest {
    private static final String HTTP_LOCALHOST = "http://localhost:";
    private static final String INITIAL_JSON = "{\"issue\":{\"number\":123}}";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void issueJsonPost() throws Exception {
        final String uri = new StringBuilder(HTTP_LOCALHOST).append(port).append("/events").toString();

        final ResponseEntity<Void> postForEntity = restTemplate.postForEntity(uri, INITIAL_JSON, Void.class);

        assertThat(postForEntity).isNotNull();

        assertThat(postForEntity.getStatusCode()).isEqualTo(CREATED);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void issueJsonGetAll() throws Exception {
        final String uri = new StringBuilder(HTTP_LOCALHOST).append(port).append("/events").toString();

        restTemplate.postForEntity(uri, INITIAL_JSON, Void.class);

        final List allIssues = restTemplate.getForObject(uri, List.class);

        assertThat(allIssues).isNotNull();

        assertThat(allIssues).isNotEmpty();

        assertThat((Map)allIssues.get(0)).containsKey("issue");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Test
    public void issueJsonGetByNumber() throws Exception {
        final String uriPost = new StringBuilder(HTTP_LOCALHOST).append(port).append("/events").toString();

        restTemplate.postForEntity(uriPost, INITIAL_JSON, Void.class);

        final String uriGet = new StringBuilder(HTTP_LOCALHOST).append(port).append("/123/events").toString();

        final List allIssues = restTemplate.getForObject(uriGet, List.class);

        assertThat(allIssues).isNotNull();

        assertThat(allIssues).isNotEmpty();
        
        assertThat((Map)allIssues.get(0)).containsKey("issue");
    }
}
