package br.com.control.revenda.service;

import br.com.control.revenda.entity.Revenda;
import br.com.control.revenda.repository.RevendaRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevendaService implements CrudBaisc<Revenda, String> {

    @Autowired
    RevendaRepository revendaRepository;

    @Override
    public Revenda save(Revenda obj) {
        return revendaRepository.save(obj);
    }

    @Override
    public Page<Revenda> getAll(Pageable pageable) {
        return revendaRepository.findAll(pageable);
    }

    @Override
    public List<Revenda> getAll() {
        return revendaRepository.findAll();
    }

    @Override
    public Revenda get(String id) {
        return revendaRepository.findById(id).get();
    }

    @Override
    public Revenda update(Revenda obj) {
        if (exist(obj.getId())) {
            return revendaRepository.save(obj);
        }
        return null;
    }

    @Override
    public void delete(Revenda obj) {
        if (exist(obj.getId())) {
            revendaRepository.delete(obj);
        }
    }

    @Override
    public Boolean exist(String id) {
        return revendaRepository.existsById(id);
    }

    public Revenda getRevenda(int license){
        return revendaRepository.findByLicense(license);
    }
}
