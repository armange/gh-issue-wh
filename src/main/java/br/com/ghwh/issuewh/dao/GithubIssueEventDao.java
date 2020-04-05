package br.com.ghwh.issuewh.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ghwh.issuewh.entity.GithubEvent;

public interface GithubIssueEventDao extends JpaRepository<GithubEvent, UUID>{

    @Query(value = "select * from github_event where issue -> 'issue' ->> 'number' = :number", nativeQuery = true)
    List<GithubEvent> findByIssueNumber(@Param("number") String number);
}
