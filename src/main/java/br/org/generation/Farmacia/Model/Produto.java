package br.org.generation.Farmacia.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_produtos")
public class Produto {
	
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 
 @NotBlank(message = "Atributo é obrigatório")
 private String nome;
 
 @NotNull(message = "Preço é obrigatório") // Trocado NotBlank por NotNull uma vez que estava dando erro 500 com a mensagem:
 // message": "HV000030: No validator could be found for constraint 'javax.validation.constraints.NotBlank' validating type 'java.lang.Double'. Check configuration for 'preco'"
 private double preco;
 
 @NotBlank(message = "Fabricante é obrigatório")
 @Size(min = 2, max = 50, message = "Fabricante deve ter no mínimo 2 caracteres")
 private String fabricante;
 
 @ManyToOne //Muitos produtos, podem pertencer a uma categoria
 @JsonIgnoreProperties("Categoria") // prevenindo recursividade.
 private Categoria categoria; // Referenciando categoria, sem lista. 



public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public double getPreco() {
	return preco;
}

public void setPreco(double preco) {
	this.preco = preco;
}

public String getFabricante() {
	return fabricante;
}

public void setFabricante(String fabricante) {
	this.fabricante = fabricante;
}

public Categoria getCategoria() {
	return categoria;
}

public void setCategoria(Categoria categoria) {
	this.categoria = categoria;
}


}
