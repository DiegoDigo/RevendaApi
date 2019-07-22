package br.com.control.revenda.service;

import br.com.control.revenda.entity.Web;
import br.com.control.revenda.repository.WebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WebService implements CrudBaisc<Web, String> {

    @Autowired
    WebRepository webRepository;

    @Override
    public Web save(Web obj) {
        return webRepository.save(obj);
    }

    @Override
    public Page<Web> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Web> getAll() {
        return null;
    }

    @Override
    public Web get(String id) {
        return null;
    }

    @Override
    public Web update(Web obj) {
        return null;
    }

    @Override
    public void delete(Web obj) {

    }

    @Override
    public Boolean exist(String id) {
        return null;
    }
}
