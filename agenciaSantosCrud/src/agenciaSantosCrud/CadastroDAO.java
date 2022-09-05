package agenciaSantosCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar
	
	public void save(Cadastro Clientes) {
		String sql = "INSERT INTO Clientes (nome_clientes, cpf_clientes, data_nasci_clientes)" + "values (?,?,?)";

		try {
			// Cria uma conexao com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, Clientes.getNome_clientes());
			
			pstm.setString(2, Clientes.getCpf_clientes());
			
			pstm.setString(3, Clientes.getData_nasci_clientes());

			// Executar a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	// Metodo para Ler
	
	public List<Cadastro> getClientes() {
		String sql = "select * from Clientes;";

		List<Cadastro> clientes = new ArrayList<Cadastro>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Cadastro clientes1 = new Cadastro();

				clientes1.setId(rset.getInt("id_clientes"));

				clientes1.setNome_clientes(rset.getString("nome_clientes"));
				
				clientes1.setCpf_clientes(rset.getString("cpf_clientes"));
			
				clientes1.setData_nasci_clientes(rset.getString("data_nasci_clientes"));
		
				clientes.add(clientes1);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return clientes;
	}
	
	// Metodo pra atualizar
	
	public void update(Cadastro Clientes) {
		String sql = "UPDATE clientes SET nome_clientes = ?, cpf_clientes = ?, data_nasci_clientes = ?" + "where id_clientes = ?";
		
		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, Clientes.getNome_clientes());
			
			pstm.setString(2, Clientes.getCpf_clientes());
			
			pstm.setString(3, Clientes.getData_nasci_clientes());
			
			// Serve para não realizar todos os updates
			pstm.setInt(4, Clientes.getId());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Metodo para deletar
	
	public void deleteById(int id_clientes) {
		String sql = "DELETE FROM clientes WHERE id_clientes = ?";

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id_clientes);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Cadastro[] getcadastros() {
		return null;
	}

	public Cadastro getcadastroById(int id) {
		return null;
	}
}
