package com.projetointegradorgrupo3.ProjetoReintegrar.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegradorgrupo3.ProjetoReintegrar.model.Postagem;


@Repository
public interface PostagemRepository extends JpaRepository<Postagem,Long> {
		
		public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
		public List<Postagem> findAllByCorpoContainingIgnoreCase(String corpo);
		public List<Postagem> findAllByData(Date data);
		
}
