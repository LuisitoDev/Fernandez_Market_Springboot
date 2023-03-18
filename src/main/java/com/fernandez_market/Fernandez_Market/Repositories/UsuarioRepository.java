package com.fernandez_market.Fernandez_Market.Repositories;

import com.fernandez_market.Fernandez_Market.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {
}
