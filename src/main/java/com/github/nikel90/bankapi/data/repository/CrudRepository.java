package com.github.nikel90.bankapi.data.repository;

public interface CrudRepository<E, ID> {
    E save (E e);
    E getById (ID id);
    Iterable<E> getAll ();
    boolean removeById (ID id);
    void update(E e);
}

