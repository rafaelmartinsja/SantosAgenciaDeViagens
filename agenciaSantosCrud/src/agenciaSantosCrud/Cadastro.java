package agenciaSantosCrud;

import java.util.Date;

public class Cadastro {

	// Atributos
	private int id;
	private String nome;
	
	//Contrutores
	public Cadastro() {
	}
	
	public Cadastro(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	//Getters e Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	//ToString

	@Override
	public String toString() {
		return "Cadastro [id=" + id + ", nome=" + nome + "]";
	}

	public void add(Cadastro clientes) {
		// TODO Auto-generated method stub
		
	}

	public void setIdade(int idade) {
		// TODO Auto-generated method stub
		
	}

	public void setDataCadastro(Date date) {
		// TODO Auto-generated method stub
		
	}

	public String getIdade() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDataCadastro() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
