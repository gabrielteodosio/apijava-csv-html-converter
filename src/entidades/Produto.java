package entidades;

public class Produto {
	private String nome, marca;
	private Double preco;
	private Integer estoque;
	
	public Produto(String nome, String marca, Double preco, Integer estoque) {
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.estoque = estoque;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return  nome + ';' + marca + ';' + preco + ';' + estoque;
	}
}
