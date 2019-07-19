package br.com.control.revenda.repository;

import br.com.control.revenda.entity.Database;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseRepository extends JpaRepository<Database, String> {
}
