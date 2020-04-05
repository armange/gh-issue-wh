package br.com.ghwh.issuewh.service;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.RETURNS_SMART_NULLS;
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.ghwh.issuewh.dao.GithubIssueEventDao;
import br.com.ghwh.issuewh.entity.GithubEvent;

public class GithubEventServiceTest {
    private final GithubIssueEventDao dao = mock(GithubIssueEventDao.class, RETURNS_SMART_NULLS);
    private final GithubEventService service = spy(new GithubEventService(dao));
    
    @BeforeEach
    public void BeforeEach() {
        clearInvocations(service);
    }
    
    @Test
    public void save() {
        service.save(SPACE);
        
        verify(dao).save(any(GithubEvent.class));
    }
    
    @Test
    public void findAll() {
        service.findAll();
        
        verify(dao).findAll();
    }
    
    @Test
    public void findByIssueNumber() {
        service.findByIssueNumber(SPACE);
        
        verify(dao).findByIssueNumber(SPACE);
    }
}
