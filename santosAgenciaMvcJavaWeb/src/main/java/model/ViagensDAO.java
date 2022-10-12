package model;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ViagensDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Viagens viagens) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO viagens(origem_viagens,data_origem_viagens,destino_viagens,data_destino_viagens)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, viagens.getOrigem_viagens());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setDate(2, (Date) viagens.getData_origem_viagens());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, viagens.getDestino_viagens());
			// Adiciona o valor do quarto parâmetro da sql
			pstm.setDate(4, new Date(viagens.getData_origem_viagens().getTime()));
			
			
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

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

	public void removeById(int id_viagens) {

		String sql = "DELETE FROM viagens WHERE id_viagens = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

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

	public void update(Viagens viagens) {

		String sql = "UPDATE viagens SET nome = ?, origem_viagens = ?, data_origem_viagens = ?, destino_viagens = ?, data_destino_viagens = ? " + " WHERE id_viagens = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, viagens.getOrigem_viagens());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setDate(2, (Date) viagens.getData_origem_viagens());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, viagens.getDestino_viagens());
			// Adiciona o valor do quarto parâmetro da sql
			pstm.setDate(4, new Date(viagens.getData_origem_viagens().getTime()));

			pstm.setInt(5, viagens.getId_viagens());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

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

	public List<Viagens> getviagenss() {

		String sql = "SELECT * FROM viagens";

		List<Viagens> viagenss = new ArrayList<Viagens>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Viagens viagens = new Viagens();

				// Recupera o id do banco e atribui ele ao objeto
				viagens.setId_viagens(rset.getInt("id_viagens"));

				// Recupera o nome do banco e atribui ele ao objeto
				viagens.setOrigem_viagens(rset.getString("origem_viagens"));

				// Recupera a idade do banco e atribui ele ao objeto
				viagens.setData_origem_viagens(rset.getDate("data_destino_viagens"));

				// Recupera a data do banco e atribui ela ao objeto
				viagens.setDestino_viagens(rset.getString("destino_viagens"));
				
				// Recupera a idade do banco e atribui ele ao objeto
				viagens.setData_destino_viagens(rset.getDate("data_destino_viagens"));

				// Adiciono o viagens recuperado, a lista de viagenss
				viagenss.add(viagens);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

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

		return viagenss;
	}


	public Viagens getviagensById(int id) {

		String sql = "SELECT * FROM viagens where id = ?";
		Viagens viagens = new Viagens();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			viagens.setOrigem_viagens(rset.getString("origem_viagens"));
			viagens.setData_origem_viagens(rset.getDate("data_origem_viagens"));
			viagens.setDestino_viagens(rset.getString("destino_viagens"));
			viagens.setData_destino_viagens(rset.getDate("data_destino_viagens"));
			viagens.setId_viagens(rset.getInt("id_viagens"));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
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
}
