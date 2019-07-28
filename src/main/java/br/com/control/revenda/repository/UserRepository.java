package br.com.control.revenda.repository;

import br.com.control.revenda.entity.UserApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserApplication, String> {

    UserApplication findByUsername(String username);

}
