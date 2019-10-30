package com.monitoria.puc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity(name = "curso")
public class ModelCurso implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(columnDefinition = "text")
	private String descricao;
	
	@JsonBackReference
	@OneToOne(mappedBy = "curso")
    private ModelCronogramaMonitoria cronogramaMonitoria;

	
	@JsonCreator
	public ModelCurso(Long id) {
		this.id = id;
	}
	
	@JsonCreator
	public ModelCurso(String id) {
		this.id = Long.parseLong(id);
	}
	
	
	
	
	
	
}