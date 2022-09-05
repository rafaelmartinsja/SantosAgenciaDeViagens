package agenciaSantosCrud;

public class Cadastro {

	// Atributos
	private int id_clientes;
	private String nome_clientes;
	private String cpf_clientes;
	private String data_nasci_clientes;
	
	
	//Contrutores
	public Cadastro() {
	}
	
	public Cadastro(int id, String nome, String nome_clientes) {
		this.id_clientes = id;
		this.nome_clientes = nome_clientes;
	}
	//Getters e Setters

	public int getId() {
		return id_clientes;
	}

	public void setId(int id) {
		this.id_clientes = id;
	}

	public String getNome() {
		return nome_clientes;
	}


	//ToString

	@Override
	public String toString() {
		return "Cadastro [id=" + id_clientes + ", nome=" + getNome() + "]";
	}

	public void add(Cadastro clientes) {
		
	}

	public String getNome_clientes() {
		return nome_clientes;
	}

	public void setNome_clientes(String nome_clientes) {
		this.nome_clientes = nome_clientes;
	}

	public String getCpf_clientes() {
		return cpf_clientes;
	}

	public void setCpf_clientes(String cpf_clientes) {
		this.cpf_clientes = cpf_clientes;
	}

	public String getData_nasci_clientes() {
		return data_nasci_clientes;
	}

	public void setData_nasci_clientes(String data_nasci_clientes) {
		this.data_nasci_clientes = data_nasci_clientes;
	}

	public String getOrigem_viagens() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getData_origem_viagens() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDestino_viagens() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getData_destino_viagens() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId_viagens(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setOrigem_viagens(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setData_destino_viagens(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setDestino_viagens(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setData_origem_viagens(String string) {
		// TODO Auto-generated method stub
		
	}

}
