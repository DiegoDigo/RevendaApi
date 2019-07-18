package br.com.control.revenda.repository;

import br.com.control.revenda.entity.Revenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevendaRepository extends JpaRepository<Revenda, String> {}
