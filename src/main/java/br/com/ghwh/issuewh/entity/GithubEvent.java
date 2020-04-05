package br.com.ghwh.issuewh.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Entity
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class GithubEvent extends BaseModel<UUID> {
    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private String issue;

    public GithubEvent() {}
    
    public GithubEvent(final String issue) {
        setIssue(issue);
    }
    
    public String getIssue() {
        return issue;
    }

    public void setIssue(final String issue) {
        this.issue = issue;
    }
}
