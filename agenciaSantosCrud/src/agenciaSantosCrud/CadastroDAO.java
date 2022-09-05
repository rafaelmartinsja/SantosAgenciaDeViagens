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
	public void save(Cadastro clientes) {
		String sql = "INSERT INTO clientes (nome_cli) values(?);";

		try {
			// Cria uma conexao com o banco
			conn = Conexao.createConnectionMySQL();

			// Cria um PreparedStatement, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adicionar o valor do primeiro parametro da sql
			pstm.setString(1, clientes.getNome());

			// Executar a sql para inser��o dos dados
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
		String sql = "select * from clientes;";

		List<Cadastro> clientes = new ArrayList<Cadastro>();

		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {
				
				Cadastro clientes1 = new Cadastro();

				clientes1.setId(rset.getInt("cod_cli"));

				clientes1.setNome(rset.getString("nome_cli"));

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
	public void update(Cadastro clientes) {
		String sql = "UPDATE clientes set nome_cli = ? where cod_cli = ?;";

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setString(1, clientes.getNome());

			pstm.setInt(2, clientes.getId());

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
	public void deleteById(int cod_cli) {
		String sql = "DELETE FROM clientes WHERE cod_cli = ?";

		try {
			conn = Conexao.createConnectionMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, cod_cli);

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
	
	public void removeById(int codigo) {
		// TODO Auto-generated method stub
		
	}

	public static Cadastro[] getcadastros() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cadastro getcadastroById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
