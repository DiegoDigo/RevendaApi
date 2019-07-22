package br.com.control.revenda.service;

import br.com.control.revenda.entity.Fila;
import br.com.control.revenda.repository.FilaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaService implements CrudBaisc<Fila, String>{

    @Autowired
    FilaRepository filaRepository;

    @Override
    public Fila save(Fila obj) {
        return filaRepository.save(obj);
    }

    @Override
    public Page<Fila> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Fila> getAll() {
        return null;
    }

    @Override
    public Fila get(String id) {
        return null;
    }

    @Override
    public Fila update(Fila obj) {
        return null;
    }

    @Override
    public void delete(Fila obj) {

    }

    @Override
    public Boolean exist(String id) {
        return null;
    }
}
