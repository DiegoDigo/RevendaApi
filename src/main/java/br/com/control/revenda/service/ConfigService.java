package br.com.control.revenda.service;

import br.com.control.revenda.entity.Config;
import br.com.control.revenda.repository.ConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService implements CrudBaisc<Config, String>{

    @Autowired
    ConfigRepository configRepository;

    @Override
    public Config save(Config obj) {
        return configRepository.save(obj);
    }

    @Override
    public Page<Config> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Config> getAll() {
        return configRepository.findAll();
    }

    @Override
    public Config get(String id) {
        return null;
    }

    @Override
    public Config update(Config obj) {
        return null;
    }

    @Override
    public void delete(Config obj) {

    }

    @Override
    public Boolean exist(String id) {
        return null;
    }
}
