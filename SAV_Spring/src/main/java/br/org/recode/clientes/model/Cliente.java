package br.org.recode.clientes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destino;
    @Column(nullable = false)
    private String data_destino;
    @Column(nullable = false)
    private String origem;
    @Column(nullable = false)
    private String data_origem;
 
    public Cliente(Long id, String destino, String data_destino, String origem, String data_origem) {
        this.id = id;
        this.destino = destino;
        this.data_destino = data_destino;
        this.origem = origem;
        this.data_destino = data_origem;
    }

    public Cliente() {
		
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
     
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((destino == null) ? 0 : destino.hashCode());
        result = prime * result + ((data_destino == null) ? 0 : data_destino.hashCode());
        result = prime * result + ((origem == null) ? 0 : origem.hashCode());
        result = prime * result + ((data_origem == null) ? 0 : data_origem.hashCode());
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
        Cliente other = (Cliente) obj;
        if (destino == null) {
            if (other.destino != null)
                return false;
        } else if (!destino.equals(other.destino))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (data_destino == null) {
            if (other.data_destino != null)
                return false;
        } else if (!data_destino.equals(other.data_destino))
            return false;
        if (origem == null) {
            if (other.origem != null)
                return false;
        } else if (!origem.equals(other.origem))
            return false;
        if (data_origem == null) {
            if (other.data_origem != null)
                return false;
        } else if (!data_origem.equals(other.data_origem))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", destino=" + destino + ", data_destino=" + data_destino + ", origem=" + origem + ", data_origem=" + data_origem + "]";

    }
}
