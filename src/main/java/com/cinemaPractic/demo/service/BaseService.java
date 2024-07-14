package com.cinemaPractic.demo.service;

import java.util.List;

public interface BaseService <T, ID>{
    T create (T entity);
    void delete (ID id);
    T get (ID id);
    T update (T entity);
    List<T> getAll();
}
