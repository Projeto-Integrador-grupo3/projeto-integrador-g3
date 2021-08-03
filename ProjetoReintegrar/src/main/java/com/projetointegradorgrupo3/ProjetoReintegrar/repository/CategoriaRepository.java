package com.projetointegradorgrupo3.ProjetoReintegrar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetointegradorgrupo3.ProjetoReintegrar.model.Categoria;

@Repository

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
	public List<Categoria> findAllByAreaContainingIgnoreCase(String area);
	public List<Categoria> findAllBySetorContainingIgnoreCase(String setor);
	public List<Categoria> findAllByCargoContainingIgnoreCase(String cargo);
	public List<Categoria> findAllByPeriodoContainingIgnoreCase(String periodo);

}
