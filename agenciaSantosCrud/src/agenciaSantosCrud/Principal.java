package agenciaSantosCrud;

import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String args[]) {

		CadastroDAO cadastroDAO = new CadastroDAO();
		Cadastro cadastro = new Cadastro();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String nome = "";
		int idade = 0;
		int codigo = 0;

		do {

			System.out.println("===== Santos Agência de Viagens =====");
			System.out.println("1 - Cadastro de cadastro");
			System.out.println("2 - Excluir cadastro");
			System.out.println("3 - Atualizar cadastro");
			System.out.println("4 - Mostrar cadastros");
			System.out.println("5 - Buscar por ID");
			System.out.println("6 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o nome do cadastro: ");
				nome = entrada.next();
				cadastro.setNome(nome);

				System.out.println("Digite a idade do cadastro: ");
				idade = entrada.nextInt();
				cadastro.setIdade(idade);

				cadastro.setDataCadastro(new Date());

				cadastroDAO.save(cadastro);
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do cadastro para exclusao: ");
				try {
					codigo = entrada.nextInt();
					
					cadastroDAO.removeById(codigo);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" Nenhum cadastro para excluir ");
				}

				break;
			}
			case 3: {

				System.out.println("Digite o codigo do cadastro para atualizar: ");
				codigo = entrada.nextInt();

				System.out.println("Digite o novo nome do cadastro: ");
				nome = entrada.next();
				cadastro.setNome(nome);

				System.out.println("Digite a nova idade do cadastro: ");
				idade = entrada.nextInt();
				cadastro.setIdade(idade);

				cadastro.setDataCadastro(new Date());

				cadastro.setId(codigo);

				cadastroDAO.update(cadastro);
			}
			case 4: {
				for (Cadastro c : CadastroDAO.getcadastros()) {

					System.out.println("NOME: " + c.getNome());
					System.out.println("IDADE: " + c.getIdade());
					System.out.println("DATA CADASTRO: " + c.getDataCadastro());

					System.out.println("----------------------------------- ");
				}
				break;
			}
			case 5: {

				System.out.print("Digite o ID para buscar: ");
				int id = entrada.nextInt();
				
				Cadastro c = new Cadastro();

				c = cadastroDAO.getcadastroById(id);

				System.out.println("NOME: " + c.getNome());
				System.out.println("IDADE: " + c.getIdade());
				System.out.println("DATA CADASTRO: " + c.getDataCadastro());

				System.out.println("----------------------------------- ");
			}
				break;

			case 6: {
				System.out.println(" === Obrigado por usar nossa Agenda === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			}
			;

		} while (opcao != 6);

		entrada.close();

	}
}
