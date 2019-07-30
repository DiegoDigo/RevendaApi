package br.com.control.revenda.service;

import br.com.control.revenda.entity.Role;
import br.com.control.revenda.repository.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService  implements CrudBaisc<Role, String >{

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    public Role findByName(String name){
        return roleRepository.findByName(name);
    }

    @Override
    public Role save(Role obj) {
        return this.roleRepository.save(obj);
    }

    @Override
    public Page<Role> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role get(String id) {
        return null;
    }

    @Override
    public Role update(Role obj) {
        return null;
    }

    @Override
    public void delete(Role obj) {

    }

    @Override
    public Boolean exist(String id) {
        return null;
    }
}
