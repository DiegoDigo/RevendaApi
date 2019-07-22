package br.com.control.revenda.service;

import br.com.control.revenda.entity.Api;
import br.com.control.revenda.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService implements CrudBaisc<Api, String> {

    @Autowired
    ApiRepository apiRepository;

    @Override
    public Api save(Api obj) {
        return apiRepository.save(obj);
    }

    @Override
    public Page<Api> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Api> getAll() {
        return null;
    }

    @Override
    public Api get(String id) {
        return null;
    }

    @Override
    public Api update(Api obj) {
        return null;
    }

    @Override
    public void delete(Api obj) {

    }

    @Override
    public Boolean exist(String id) {
        return null;
    }
}
