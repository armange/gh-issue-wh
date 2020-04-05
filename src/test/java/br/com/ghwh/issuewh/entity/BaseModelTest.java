package br.com.ghwh.issuewh.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

public class BaseModelTest {

    @Test
    public void baseModelIdentification() {
        final GithubEvent githubEvent = new GithubEvent();
        final UUID randomUUID = UUID.randomUUID();
        
        githubEvent.setId(randomUUID);
        
        assertEquals(randomUUID, githubEvent.getId());
    }
}
