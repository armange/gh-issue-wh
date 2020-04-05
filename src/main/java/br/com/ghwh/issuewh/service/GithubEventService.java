package br.com.ghwh.issuewh.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ghwh.issuewh.dao.GithubIssueEventDao;
import br.com.ghwh.issuewh.entity.GithubEvent;

@Component
public class GithubEventService {

    private final GithubIssueEventDao dao;
    
    @Autowired
    public GithubEventService(final GithubIssueEventDao dao) {
        this.dao = dao;
    }
    
    public GithubEvent save(final String jsonIssue) {
        final GithubEvent githubEvent = new GithubEvent(jsonIssue);
        
        return dao.save(githubEvent);
    }
    
    public List<GithubEvent> findAll() {
        return dao.findAll();
    }
    
    public List<GithubEvent> findByIssueNumber(final String number) {
        return dao.findByIssueNumber(number);
    }
}
