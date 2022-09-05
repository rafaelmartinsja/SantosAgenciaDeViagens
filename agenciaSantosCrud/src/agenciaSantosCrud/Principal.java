package agenciaSantosCrud;

import java.util.Scanner;



public class Principal {

	public static void main(String args[]) {

		CadastroDAO cadastroDAO = new CadastroDAO();
		Cadastro cadastro = new Cadastro();

		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		String nome = "";
		int codigo = 0;

		do {

			System.out.println("===== Santos Agência de Viagens =====");
			System.out.println("1 - Cadastro de cadastro");
			System.out.println("2 - Excluir cadastro");
			System.out.println("3 - Atualizar cadastro");
			System.out.println("4 - Mostrar cadastros");
			System.out.println("5 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o nome do cadastro: ");
				nome = entrada.next();
				cadastro.setNome(nome);

				cadastroDAO.save(cadastro);
				break;
			}
			case 2: {
				System.out.println("Digite o codigo do cadastro para exclusao: ");
				try {
					codigo = entrada.nextInt();
					
					cadastroDAO.deleteById(codigo);
					
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

				cadastro.setId(codigo);

				cadastroDAO.update(cadastro);
			}
			case 4: {
				// READ
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getNome());
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
						
			case 5: {
				System.out.println(" === Obrigado por usar nossa Agenda === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			};

		} while (opcao != 6);

		entrada.close();

	}
}
