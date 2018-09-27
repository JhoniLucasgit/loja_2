package br.senac.rn.loja.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table //cria uma tabela com o nome tb_departamentos, obs: não é obrigatório
@Entity //cria uma entidade(classe representada em uma tabela)
public class Departamento implements Comparable<Departamento>{

	@Id //pk = chave primaria
	@GeneratedValue(strategy=GenerationType.IDENTITY) // faz o auto incremento da pk
	//como renomear as colunas @Column(name="")
	//o @ de cima representa a linha de baixo
	private Integer id;
	private String nome;
	private String sigla;
	private Float desconto;
	private String fone;
	
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
	
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public Float getDesconto() {
		return desconto;
	}
	
	public void setDesconto(Float desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nome=" + nome + ", sigla=" + sigla + ", desconto=" + desconto + ", fone="
				+ fone + "]";
	}

	@Override
	public int compareTo(Departamento departamento) {
		return id.compareTo(departamento.id);
	}
	
}
