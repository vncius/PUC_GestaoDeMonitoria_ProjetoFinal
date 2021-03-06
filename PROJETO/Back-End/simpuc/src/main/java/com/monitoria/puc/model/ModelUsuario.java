package com.monitoria.puc.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.monitoria.puc.utilidades.Utilidades;

/*DESENVOLVEDOR: VINICIUS VIEIRA ABREU*/
/*DATA: 16/11/2019*/
@Entity(name = "usuario")
public class ModelUsuario implements UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	private String matricula;
	
	private String nome;
	
	private String senha;
	
	
	@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_role_id", referencedColumnName = "id", nullable = false)
	private Role role;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "fk_curso_id", referencedColumnName = "id", nullable = false)
	private ModelCurso curso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.trim();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha.trim();
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula.trim();
	}

	public Boolean validaSeCamposObrigatoriosPreenchidos() {
		if (!Utilidades.valorStringEstaPreenchido(this.matricula)) return false;
		if (!Utilidades.valorStringEstaPreenchido(this.nome)) return false;
		if (!Utilidades.valorStringEstaPreenchido(this.senha)) return false;
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<Role> roles = new ArrayList<Role>();
		roles.add(this.role);
		return roles;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.matricula;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public ModelCurso getCurso() {
		return curso;
	}

	public void setCurso(ModelCurso curso) {
		this.curso = curso;
	}
}
