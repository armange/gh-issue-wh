package br.com.ghwh.issuewh.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

@MappedSuperclass
public class BaseModel<T> implements Identity<T> {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private T id;

    @Override
    public T getId() {
        return id;
    }

    @Override
    public void setId(final T id) {
        this.id = id;
    }
}
