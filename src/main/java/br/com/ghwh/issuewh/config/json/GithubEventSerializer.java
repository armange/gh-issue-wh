package br.com.ghwh.issuewh.config.json;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.ghwh.issuewh.entity.GithubEvent;

@JsonComponent
public class GithubEventSerializer extends JsonSerializer<GithubEvent> {

    @Override
    public void serialize(final GithubEvent githubEvent, final JsonGenerator jsonGenerator, final SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeTree(new ObjectMapper().readTree(githubEvent.getIssue()));
    }
}
