package agenciaSantosCrud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	// Metodo para Ler

		public List<Cadastro> getCompra() {
			String sql = "select * from compra;";

			List<Cadastro> compra = new ArrayList<Cadastro>();

			// Classe que vai recuperar os dados do banco de dados
			ResultSet rset = null;

			try {
				conn = Conexao.createConnectionMySQL();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {

					Cadastro compra1 = new Cadastro();

					compra1.setId_viagens(rset.getInt("id_clientes"));

					compra1.setId_viagens(rset.getInt("id_viagens"));

					compra1.add(compra1);

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

			return compra;
		}

	
}
