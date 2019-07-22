package br.com.control.revenda.service;

import br.com.control.revenda.entity.Database;
import br.com.control.revenda.repository.DatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseService implements CrudBaisc<Database, String>{

    @Autowired
    DatabaseRepository databaseRepository;

    @Override
    public Database save(Database obj) {
        return databaseRepository.save(obj);
    }

    @Override
    public Page<Database> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Database> getAll() {
        return null;
    }

    @Override
    public Database get(String id) {
        return null;
    }

    @Override
    public Database update(Database obj) {
        return null;
    }

    @Override
    public void delete(Database obj) {

    }

    @Override
    public Boolean exist(String id) {
        return null;
    }
}
