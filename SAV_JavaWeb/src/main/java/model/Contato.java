package model;

public class Contato {

	private int id;
    private String destino;
    private String data_destino;
    private String origem;
    private String data_origem;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getData_destino() {
		return data_destino;
	}
	public void setData_destino(String data_destino) {
		this.data_destino = data_destino;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getData_origem() {
		return data_origem;
	}
	public void setData_origem(String data_origem) {
		this.data_origem = data_origem;
	}
 
	public Contato() {
		
	}
	   
}