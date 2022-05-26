package com.traveller.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.traveller.model.NovoLocal;

//Cria uma interface (TravellerRepository) que herda os métodos escritos do Spring (JpaRepository)que trabalhará com a classe 'NovoLocal' através do atributo identificador 'ID' (do tipo Long)
public interface TravellerRepository extends JpaRepository<NovoLocal, Long> {
	
}
