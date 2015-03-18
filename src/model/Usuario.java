package model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(schema="pub", name="usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="usuario_sequence")
	@TableGenerator(schema="pub", name="usuario_sequence", initialValue=0, allocationSize=1)
	private Integer id;
	
	private String nome;
	
	private Integer idade;
	
	private Long numerico;
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="usuario")
	private List<Perfil> perfis = new ArrayList<>();

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Long getNumerico() {
		return numerico;
	}

	public void setNumerico(Long numerico) {
		this.numerico = numerico;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
	
}
