package agenciaSantosCrud;

public class Viagens {

	// Atributos
	
	private int id_viagens;
	private String origem_viagens;
	private String data_destino_viagens;
	private String destino_viagens;
	private String data_origem_viagens;
	
	//Contrutores

	public Viagens() {
	}

	//Getters e Setters
	
	public int getId_viagens() {
		return id_viagens;
	}

	public void setId_viagens(int id_viagens) {
		this.id_viagens = id_viagens;
	}

	public String getOrigem_viagens() {
		return origem_viagens;
	}

	public void setOrigem_viagens(String origem_viagens) {
		this.origem_viagens = origem_viagens;
	}

	public String getData_destino_viagens() {
		return data_destino_viagens;
	}

	public void setData_destino_viagens(String data_destino_viagens) {
		this.data_destino_viagens = data_destino_viagens;
	}

	public String getDestino_viagens() {
		return destino_viagens;
	}

	public void setDestino_viagens(String destino_viagens) {
		this.destino_viagens = destino_viagens;
	}

	public String getData_origem_viagens() {
		return data_origem_viagens;
	}

	public void setData_origem_viagens(String data_origem_viagens) {
		this.data_origem_viagens = data_origem_viagens;
	}
	
}
