package com.monitoria.puc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.monitoria.puc.model.ModelUsuario;

/*DESENVOLVEDOR: VINICIUS VIEIRA ABREU*/
/*DATA: 16/11/2019*/
@Repository
public interface RepositoryUsuario extends CrudRepository<ModelUsuario, Long> {

	@Query("select u from usuario u where u.matricula = ?1")
	ModelUsuario findUserByLogin(String matricula);

}
