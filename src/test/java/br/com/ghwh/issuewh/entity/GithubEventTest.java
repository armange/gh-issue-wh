package br.com.ghwh.issuewh.entity;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GithubEventTest {

    @Test
    public void issueField() {
        final GithubEvent githubEvent = new GithubEvent(SPACE);
        
        assertEquals(SPACE, githubEvent.getIssue());
    }
}
