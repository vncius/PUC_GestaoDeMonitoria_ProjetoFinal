package com.monitoria.puc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.monitoria.puc.model.ModelUsuario;
import com.monitoria.puc.repository.RepositoryUsuario;

/*DESENVOLVEDOR: VINICIUS VIEIRA ABREU*/
/*DATA: 16/11/2019*/
@Service
public class ImplementacaoUserDetailsService implements UserDetailsService {

	@Autowired
	private RepositoryUsuario usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ModelUsuario usuario = usuarioRepository.findUserByLogin(username);	
		
		if (usuario == null) throw new UsernameNotFoundException("Usuário não foi encontrado");
		
		return new User(usuario.getMatricula(), 
				usuario.getPassword(), 
				usuario.getAuthorities());
	}
}
