package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Contato contato) {

		// os ? são os parâmetros que nós vamos adicionar na base de dados

		String sql = "INSERT INTO viagens (destino,data_destino,origem,data_origem)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getDestino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, contato.getData_destino());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, contato.getOrigem());
			// Adiciona o valor do quarto parâmetro da sql
			pstm.setString(4, contato.getData_origem());

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

	public void removeById(int id) {

		String sql = "DELETE FROM viagens WHERE id = ?";

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);

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

	public void update(Contato contato) {

		String sql = "UPDATE viagens SET destino = ?, data_destino = ?, origem = ?, data_origem = ? " + " WHERE id = ?";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, contato.getDestino());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, contato.getData_destino());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, contato.getOrigem());
			// Adiciona o valor do quarto parâmetro da sql
			pstm.setString(4, contato.getData_origem());

			pstm.setInt(5, contato.getId());

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

	public List<Contato> getContatos() {

		String sql = "SELECT * FROM viagens";

		List<Contato> contatos = new ArrayList<Contato>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Contato contato = new Contato();

				// Recupera o id do banco e atribui ele ao objeto
				contato.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				contato.setDestino(rset.getString("destino"));

				// Recupera a idade do banco e atribui ele ao objeto
				contato.setData_destino(rset.getString("data_destino"));

				// Recupera a data do banco e atribui ela ao objeto
				contato.setOrigem(rset.getString("origem"));
				
				// Recupera a data do banco e atribui ela ao objeto
				contato.setData_origem(rset.getString("data_origem"));

				// Adiciono o contato recuperado, a lista de contatos
				contatos.add(contato);
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

		return contatos;
	}


	public Contato getContatoById(int id) {

		String sql = "SELECT * FROM viagens where id = ?";
		Contato contato = new Contato();

		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();
			
			contato.setDestino(rset.getString("destino"));
			contato.setData_destino(rset.getString("data_destino"));
			contato.setOrigem(rset.getString("origem"));
			contato.setData_origem(rset.getString("data_origem"));
			contato.setId(rset.getInt("id"));

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
		return contato;
	}
}
