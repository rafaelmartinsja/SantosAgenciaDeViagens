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
		String cpf;
		String clientes;

		do {

			System.out.println("===== Santos Agência de Viagens =====");
			System.out.println("1 - Cadastro de cadastro");
			System.out.println("2 - Excluir cadastro");
			System.out.println("3 - Atualizar cadastro");
			System.out.println("4 - Mostrar cadastros");
			System.out.println("5 - Cadastro de Viagem");
			System.out.println("6 - Mostrar Viagem");
			System.out.println("7 - Atualizar Viagem");
			System.out.println("8 - Deletar Viagem");
			System.out.println("9 - Mostrar Compra");
			System.out.println("10 - Sair");
			opcao = entrada.nextInt();

			switch (opcao) {
			case 1: {
				System.out.println("Digite o nome do cadastro: ");
				nome = entrada.next();
				System.out.println("Digite o cpf: ");
				cpf = entrada.next();
				System.out.println("Digite a data de nascimento: ");
				clientes = entrada.next();
				cadastro.setNome_clientes(nome);
				cadastro.setCpf_clientes(cpf);
				cadastro.setData_nasci_clientes(clientes);

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
				cadastro.setNome_clientes(nome);
				
				System.out.println("Digite o novo cpf: ");
				cpf = entrada.next();
				cadastro.setCpf_clientes(cpf);
				
				System.out.println("Digite a nova data de nascimento: ");
				clientes = entrada.next();				
				cadastro.setData_nasci_clientes(clientes);
				

				cadastro.setId(codigo);

				cadastroDAO.update(cadastro);
			}
			case 4: {
				// READ - Leitura
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getNome_clientes());
			            System.out.println("CPF: " + c2.getCpf_clientes());
			            System.out.println("Data de Nascimento: " + c2.getData_nasci_clientes());
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 5: {
				// Cadastrar Viagem
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getOrigem_viagens());
			            System.out.println("CPF: " + c2.getData_origem_viagens());
			            System.out.println("Data de Nascimento: " + Viagens.getDestino_viagens());
			            System.out.println("Data de Nascimento: " + Viagens.getData_destino_viagens());
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 6: {
				// READ - Leitura
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getNome_clientes());
			            System.out.println("CPF: " + c2.getCpf_clientes());
			            System.out.println("Data de Nascimento: " + c2.getData_nasci_clientes());
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 7: {
				// READ - Leitura
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getNome_clientes());
			            System.out.println("CPF: " + c2.getCpf_clientes());
			            System.out.println("Data de Nascimento: " + c2.getData_nasci_clientes());
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 8: {
				// READ - Leitura
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getNome_clientes());
			            System.out.println("CPF: " + c2.getCpf_clientes());
			            System.out.println("Data de Nascimento: " + c2.getData_nasci_clientes());
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
				
			case 9: {
				// READ - Leitura
				try {
					for (Cadastro c2: cadastroDAO.getClientes()) {
			            System.out.println("Nome: " + c2.getNome_clientes());
			            System.out.println("CPF: " + c2.getCpf_clientes());
			            System.out.println("Data de Nascimento: " + c2.getData_nasci_clientes());
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				break;
						
			case 10: {
				System.out.println(" === Obrigado por usar nossa Agenda === ");
				break;
			}
			default:
				System.out.println("Opcao invalida: ");

			};

		} while (opcao != 9);

		entrada.close();

	}
}
