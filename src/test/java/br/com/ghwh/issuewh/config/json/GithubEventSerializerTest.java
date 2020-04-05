package br.com.ghwh.issuewh.config.json;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ghwh.issuewh.entity.GithubEvent;

public class GithubEventSerializerTest {

    @Test
    public void serialize() {
        try {
            final String initialJson = "{\"issue\":{\"number\":123}}";
            final GithubEventSerializer serializer = new GithubEventSerializer();
            final GithubEvent githubEvent = new GithubEvent(initialJson);
            final JsonFactory factory = new JsonFactory();
            final StringWriter stringWriter = new StringWriter();
            final JsonGenerator jsonGenerator = factory.createGenerator(stringWriter);
            
            jsonGenerator.setCodec(new ObjectMapper());
            serializer.serialize(githubEvent, jsonGenerator, null);
            
            final String generatedJson = stringWriter.toString();
            
            assertThat(generatedJson).isEqualTo(initialJson);
        } catch (final IOException e) {
            e.printStackTrace();
            
            fail(e);
        }
    }
}
