package br.org.recode.clientes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.org.recode.clientes.model.Cliente;
import br.org.recode.clientes.repository.ClienteRepository;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	// Lista, exibe, mostra os clientes.
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cliente/listar.html");

		List<Cliente> clientes = clienteRepository.findAll();
		modelAndView.addObject("clientes", clientes);

		return modelAndView;
	}

	// Cadastra os clientes.
	@GetMapping("/cadastrar")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cliente/cadastro");

		modelAndView.addObject("cliente", new Cliente());

		return modelAndView;
	}

	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Cliente cliente, @RequestParam("fileCliente") MultipartFile file) throws IOException {

		cliente.setOrigem(file.toString());

		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		clienteRepository.save(cliente);

		return modelAndView;
	}

	// Edita a partir do click
	@GetMapping("/imagem/{id}")
	@ResponseBody
	public String exibirImagen(@PathVariable("id") Long id) {
		@SuppressWarnings("deprecation")
		Cliente cliente = this.clienteRepository.getOne(id);
		return cliente.getOrigem();
	}

	// Vai para página de edição apartir do click
	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");

		@SuppressWarnings("deprecation")
		Cliente cliente = clienteRepository.getOne(id);
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

	// Excluir
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		clienteRepository.deleteById(id);

		return modelAndView;
	}

	// Editar ao clicar no botão editar

	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cliente/edicao");

		@SuppressWarnings("deprecation")
		Cliente cliente = clienteRepository.getOne(id);
		modelAndView.addObject("cliente", cliente);

		return modelAndView;
	}

	@PostMapping("/{id}/editar")
	public ModelAndView editar(Cliente cliente) {
		ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

		clienteRepository.save(cliente);

		return modelAndView;
	}

}
