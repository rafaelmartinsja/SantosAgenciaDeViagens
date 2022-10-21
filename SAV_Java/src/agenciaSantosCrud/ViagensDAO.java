package agenciaSantosCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViagensDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo pra salvar

	public void save(Cadastro Viagens) {
		String sql = "INSERT INTO viagens (origem_viagens, data_origem_viagens, destino_viagens, data_destino_viagens)"
				+ "values (?,?,?,?)";

		try {
			// Cria uma conexao com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, Viagens.getOrigem_viagens());

			pstm.setString(2, Viagens.getData_origem_viagens());

			pstm.setString(3, Viagens.getDestino_viagens());

			pstm.setString(4, Viagens.getData_destino_viagens());

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

	public List<Cadastro> getViagens() {
		String sql = "select * from viagens;";

		List<Cadastro> viagens = new ArrayList<Cadastro>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Cadastro viagens1 = new Cadastro();

				viagens1.setId_viagens(rset.getInt("id_viagens"));

				viagens1.setOrigem_viagens(rset.getString("origem_viagens"));

				viagens1.setData_destino_viagens(rset.getString("data_destino_viagens"));

				viagens1.setDestino_viagens(rset.getString("destino_viagens"));

				viagens1.setData_origem_viagens(rset.getString("data_origem_viagens"));

				viagens.add(viagens1);

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

		return viagens;
	}

	// Metodo pra atualizar
	
		public void update(Cadastro Viagens) {
			String sql = "UPDATE viagens SET origem_viagens = ?, data_origem_viagens = ?, destino_viagens = ?, destino_viagens = ?" + "where id_viagens = ?";
			
			try {
				conn = Conexao.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, Viagens.getOrigem_viagens());
				
				pstm.setString(2, Viagens.getData_origem_viagens());
				
				pstm.setString(3, Viagens.getDestino_viagens());
				
				pstm.setString(4, Viagens.getData_destino_viagens());
				
				// Serve para não realizar todos os updates
				pstm.setInt(4, Viagens.getId());

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

		public void deleteById(int id_viagens) {
			String sql = "DELETE FROM clientes WHERE id_viagens = ?";

			try {
				conn = Conexao.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id_viagens);

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

		public static Viagens[] setViagens() {
			// TODO Auto-generated method stub
			return null;
		}

		public void save(Viagens d1) {
			// TODO Auto-generated method stub
			
		}

		public void removebyId(int id_viagens) {
			// TODO Auto-generated method stub
			
		}

		public void update(Viagens d1) {
			// TODO Auto-generated method stub
			
		}
		
}		