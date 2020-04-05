package br.com.ghwh.issuewh.controller;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import br.com.ghwh.issuewh.dao.GithubIssueEventDao;
import br.com.ghwh.issuewh.entity.GithubEvent;
import br.com.ghwh.issuewh.service.GithubEventService;

public class GithubEventControllerTest {
    private static final GithubEvent GITHUB_EVENT = new GithubEvent();
    private static final List<GithubEvent> LIST_TO_BE_RETURNED = new ArrayList<>();
    
    static {
        LIST_TO_BE_RETURNED.add(GITHUB_EVENT);
    }
    
    private final GithubIssueEventDao dao = mock(GithubIssueEventDao.class, RETURNS_SMART_NULLS);
    private final GithubEventService service = spy(new GithubEventService(dao));
    private final GithubEventController controller = new GithubEventController(service);

    @BeforeEach
    public void beforeEach() {
        reset(service, dao);
    }
    
    @Test
    public void createIssue() {
        final ResponseEntity<Void> response = controller.createIssue(SPACE);
        
        assertThat(response.getStatusCodeValue()).isEqualTo(CREATED.value());
        
        verify(service).save(SPACE);
    }
    
    @Test
    public void findAll() {
        doReturn(LIST_TO_BE_RETURNED).when(service).findAll();
        
        final ResponseEntity<List<GithubEvent>> response = controller.findAll();
        
        assertThat(response.getStatusCodeValue()).isEqualTo(OK.value());
        
        verify(service).findAll();
        
        assertThat(response.getBody()).isEqualTo(LIST_TO_BE_RETURNED);
    }
    
    @Test
    public void findByIssueNumber() {
        doReturn(LIST_TO_BE_RETURNED).when(service).findByIssueNumber(SPACE);
        
        final ResponseEntity<List<GithubEvent>> response = controller.findByIssueNumber(SPACE);
        
        assertThat(response.getStatusCodeValue()).isEqualTo(OK.value());
        
        verify(service).findByIssueNumber(SPACE);
        
        assertThat(response.getBody()).isEqualTo(LIST_TO_BE_RETURNED);
    }
}
