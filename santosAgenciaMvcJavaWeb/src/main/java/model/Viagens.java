package model;

import java.util.Date;

public class Viagens {

	private int id_viagens;
	private String origem_viagens;
	private Date data_origem_viagens;
	private String destino_viagens;
	private Date data_destino_viagens;
	
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
	public Date getData_origem_viagens() {
		return data_origem_viagens;
	}
	public void setData_origem_viagens(Date data_origem_viagens) {
		this.data_origem_viagens = data_origem_viagens;
	}
	public String getDestino_viagens() {
		return destino_viagens;
	}
	public void setDestino_viagens(String destino_viagens) {
		this.destino_viagens = destino_viagens;
	}
	public Date getData_destino_viagens() {
		return data_destino_viagens;
	}
	public void setData_destino_viagens(Date data_destino_viagens) {
		this.data_destino_viagens = data_destino_viagens;
	}
	
	public Viagens() {
		
	}
	
	public Viagens(int id_viagens, String origem_viagens, Date data_origem_viagens, String destino_viagens, Date data_destino_viagens) {

		this.id_viagens=id_viagens;
		this.origem_viagens=origem_viagens;
		this.data_origem_viagens=data_origem_viagens;
		this.destino_viagens=destino_viagens;
		this.data_destino_viagens=data_destino_viagens;
	}

}