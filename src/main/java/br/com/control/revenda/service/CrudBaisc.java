package br.com.control.revenda.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudBaisc<T, K> {

    T save(T obj);

    Page<T> getAll(Pageable pageable);

    List<T> getAll();

    T get(K id);

    T update(T obj);

    void delete(T obj);

    Boolean exist(K id);

}
