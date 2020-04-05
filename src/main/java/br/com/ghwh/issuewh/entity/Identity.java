package br.com.ghwh.issuewh.entity;

public interface Identity<T> {

    T getId();
    
    void setId(T id);
}
