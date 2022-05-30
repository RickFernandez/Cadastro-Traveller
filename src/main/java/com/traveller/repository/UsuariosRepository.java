package com.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event.ID;

import com.traveller.model.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, ID>{

}
