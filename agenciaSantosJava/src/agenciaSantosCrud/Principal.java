package agenciaSantosCrud;

import java.util.Scanner;

public class Principal {

	@SuppressWarnings("static-access")
	public static void main(String args[]) {

		CadastroDAO CadastroDAO = new CadastroDAO();
		Cadastro c1 = new Cadastro();
		Viagens d1 = new Viagens();
		ViagensDAO ViagensDAO = new ViagensDAO();
		

		Scanner entrada = new Scanner(System.in);
		
		int escolha = 0;
		
		String nome_clientes = "";
		String cpf_clientes;
		String data_nasci_clientes;
		
		String origem_viagens;
		String data_destino_viagens;
		String destino_viagens;
		String data_origem_viagens;
		
		int id_clientes = 0;
		int id_viagens = 0;

		do {

			System.out.println("✈︎ Santos Agência de Viagens ✈︎");
			System.out.println("Escolha uma opção:");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Excluir Cliente");
			System.out.println("3 - Atualizar Cliente");
			System.out.println("4 - Mostrar todos os Clientes Cadastrados");
			System.out.println("5 - Cadastrar Viagem:");
			System.out.println("6 - Deletar Viagens");
			System.out.println("7 - Mostrar todos as Viagens");
			System.out.println("8 - Atualizar Viagens");
			System.out.println("9 - Procurar uma Viagens por ID");
		

			System.out.println("0 - Sair");
			escolha = entrada.nextInt();

			switch (escolha) {
				// metodo salvar
			case 1: {
				System.out.println("Digite o nome para o cadastro: ");
				nome_clientes = entrada.next();
				System.out.println("Digite o cpf para  o cadastro: ");
				cpf_clientes = entrada.next();
				System.out.println("Digite a data de nascimento para o Cadastro: ");
				data_nasci_clientes = entrada.next();
				c1.setNome_clientes(nome_clientes);
				c1.setCpf_clientes(cpf_clientes);
				c1.setData_nasci_clientes(data_nasci_clientes);

				CadastroDAO.save(c1);
				break;
			}
			// metodo Deletar 
			case 2: {
				System.out.println("Digite o ID do cliente para exclusão: ");
				try {
					id_clientes = entrada.nextInt();
					
					CadastroDAO.removeById(id_clientes);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" ID não foi encontrado");
				}

				break;
			}
			// método de atualizar
			case 3: {

				System.out.println("Digite o ID do cliente que deseja atualizar: ");
				id_clientes = entrada.nextInt();

				System.out.println("Digite o novo nome do cliente: ");
				nome_clientes = entrada.next();
				c1.setNome_clientes(nome_clientes);
				
				System.out.println("Digite o cpf para cliente: ");
				cpf_clientes = entrada.next();
				c1.setCpf_clientes(cpf_clientes);
				
				System.out.println("Digite a data de nascimento: ");
				data_nasci_clientes = entrada.next();				
				c1.setData_nasci_clientes(data_nasci_clientes);
				

				c1.setId(id_clientes);

				CadastroDAO.update(c1);
			}
			case 4: {
				// READ - Leitura
				try {
					for (Cadastro c2: CadastroDAO.getCadastros()) {
						System.out.println("Nome: " + c2.getNome_clientes());
						System.out.println("Cpf:  " + c2.getCpf_clientes());
						System.out.println("Data de nascimento: "+ c2.getData_nasci_clientes());
						System.out.println("-------------------------------");
					} 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
				
			case 5: {
				// Cadastrar Novo Viagens
				try {
					{
						System.out.println("Digite a Origem: ");
						origem_viagens = entrada.next();
						System.out.println("Digite a data do Embarque: ");
						data_destino_viagens = entrada.next();
						System.out.println("Digite o Destino: ");
						destino_viagens = entrada.next();
						System.out.println("Digite a data do Desembarque: ");
						data_origem_viagens = entrada.next();
						d1.setOrigem_viagens(origem_viagens);
						d1.setData_destino_viagens(data_destino_viagens);
						d1.setDestino_viagens(destino_viagens);
						d1.setData_origem_viagens(data_origem_viagens);
		
						ViagensDAO.save(d1);
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
				
			case 6: {
				
				try {
					System.out.println("Digite o ID da Viagem para exclusão: ");
				try {
					id_viagens = entrada.nextInt();
					
					ViagensDAO.removebyId(id_viagens);
					
				} catch (Exception e) {
					// e.getMessage();
					 
					System.out.println(" ID não foi encontrado");
				}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
				
			case 7: {
				// READ - Leitura Viagens
				try {
					for (Cadastro d2Viagens: ViagensDAO.getViagens()) {
			            System.out.println("Origem: " + d1.getOrigem_viagens());
			            System.out.println("Data Origem: " + d1.getData_destino_viagens());
			            System.out.println("Destino: " + d1.getDestino_viagens());
						System.out.println("Data Destino:  " + d1.getData_origem_viagens);
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				break;
				
			case 8: {
				// READ - Atualizar Viagens
						try {
						System.out.println("Digite o ID da Viagens que deseja atualizar: ");
									id_viagens = entrada.nextInt();
					
									System.out.println("Digite a Origem a ser atualizada: ");
									origem_viagens = entrada.next();
									System.out.println("Digite a nova data do Embarque: ");
									data_destino_viagens = entrada.next();
									System.out.println("Digite o novo Destino: ");
									destino_viagens = entrada.next();
									System.out.println("Digite a nova data do Desembarque: ");
									data_origem_viagens = entrada.next();
									d1.setOrigem_viagens(origem_viagens);
									d1.setData_destino_viagens(data_destino_viagens);
									d1.setDestino_viagens(destino_viagens);
									d1.setData_origem_viagens(data_origem_viagens);
					
									d1.setId_viagens(id_viagens);
					
									ViagensDAO.update(d1);
				} catch (Exception e) {
					// 
					e.printStackTrace();
				}
			}
				break;
				
			case 9: {
				// READ - Leitura
				try {
					for (Cadastro d1Viagens: ViagensDAO.getViagens()) {
			            System.out.println("Nome Cliente: " + d1.getNome_clientes());
			            System.out.println("Origem: " + d1.getOrigem_viagens());
			            System.out.println("Data Origem: " + d1.getData_destino_viagens());
						System.out.println("Destino:  " + d1.getDestino_viagens());
						System.out.println("Data Destino:  " + d1.getData_origem_viagens);
						System.out.println("ID Viagem:  " + d1.getId_clientes);
						System.out.println("ID Cliente:  " + d1.getId_clientes);
			            
			            
			            System.out.println("-------------------------------");
			        }
				} catch (Exception e) {
					// 
					e.printStackTrace();
				}
			}
				break;
						
			case 0: {
				System.out.println(" Você saiu do menu ");
				break;
			}
			default:
				System.out.println("Opção invalida: ");

			};

		} while (escolha != 9);

		entrada.close();

	}
}
