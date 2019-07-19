package br.com.control.revenda.repository;

import br.com.control.revenda.entity.Web;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebRepository extends JpaRepository<Web, String> {
}
