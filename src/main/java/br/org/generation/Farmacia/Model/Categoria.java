package br.org.generation.Farmacia.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_categorias")

public class Categoria {

	@Id // identificando o ID como chave primária de tb_categorias
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = " Categoria não pode ser nulo")
	private String categoria; // higiene-pessoal, cosmetico, medicamento

	@NotNull(message = "Descrição não pode ser nulo")
	@Size(min = 2, max = 100, message = "Campo descrição tem que ter no mínimo 2 caracteres e maximo de 100")
	private String descrição;

	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL) // estava sem o cascade.Adicionado
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

}
