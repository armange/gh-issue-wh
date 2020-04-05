package br.com.ghwh.issuewh.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghwh.issuewh.entity.GithubEvent;
import br.com.ghwh.issuewh.service.GithubEventService;

@RestController
public class GithubEventController {

    private final GithubEventService service;
    
    @Autowired
    public GithubEventController(final GithubEventService service) {
        this.service = service;
    }
    
    @RequestMapping(value = "/events", method = POST)
    public ResponseEntity<Void> createIssue(@RequestBody final String jsonIssue) {
        service.save(jsonIssue);
        
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/events", method = GET)
    public ResponseEntity<List<GithubEvent>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @RequestMapping(value = "/{issueNumber}/events", method = GET)
    public ResponseEntity<List<GithubEvent>> findByIssueNumber(
            @PathVariable("issueNumber") final String issueNumber) {
        return ResponseEntity.ok(service.findByIssueNumber(issueNumber));
    }
}
