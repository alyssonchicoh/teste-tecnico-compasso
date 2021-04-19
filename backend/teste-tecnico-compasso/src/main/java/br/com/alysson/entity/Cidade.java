package br.com.alysson.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Cidade {
	
	@Id
	@SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(name = "cid_nome")
	private String nome;
	
	@Column(name = "cid_estado")
	private String  estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	

}
