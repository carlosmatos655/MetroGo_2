package pe.metrogo.spring.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.metrogo.spring.entity.Cliente;
import pe.metrogo.spring.entity.Nacionalidad;
import pe.metrogo.spring.entity.Usuario;
import pe.metrogo.spring.service.IClienteService;
import pe.metrogo.spring.service.INacionalidadService;
import pe.metrogo.spring.service.IUsuarioService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private INacionalidadService nService;

	@Autowired
	private IClienteService cService;
	
	@Autowired
	private IUsuarioService uService;

	@RequestMapping("/")
	public String irCliente(Map<String, Object> model) {
		model.put("listaClientes", cService.listar());
		return "listCliente";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaNacionalidades", nService.listar());
		model.addAttribute("nacionalidad", new Nacionalidad());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("usuario", new Usuario());
		return "cliente";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Cliente objCliente, @ModelAttribute @Valid Usuario objUsuario, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaNacionalidades", nService.listar());
			return "cliente";
		} else {
			String bCryptPassword = passwordEncoder.encode(objUsuario.getPassword());
			objUsuario.setEnabled(true);
			objUsuario.setPassword(bCryptPassword);
			objUsuario.setId(objCliente.getCCliente());
			objCliente.setUsuario(objUsuario);
			boolean flag = cService.insertar(objCliente);
			if (flag) {
				return "redirect:/cliente/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/cliente/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Cliente> objCliente = cService.listarId(id);
		if (objCliente == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/cliente/listar";
		} else {
			System.out.println("Antes del insertar");
			model.addAttribute("listaNacionalidades", nService.listar());
			System.out.println("Despues del insertar");
			if (objCliente.isPresent())
				objCliente.ifPresent(c -> model.addAttribute("cliente", c));
			return "cliente";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				cService.eliminar(id);
				model.put("listaClientes", cService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaClientes", cService.listar());
		}
		return "listCliente";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaClientes", cService.listar());
		return "listCliente";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		cService.listarId(cliente.getCCliente());
		return "listCliente";
	}

	@RequestMapping("/find")
	public String findByNNombreyApellido(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		List<Cliente> listaCliente;
		cliente.setNNombreyApellido(cliente.getNNombreyApellido());
		listaCliente = cService.findByNNombreyApellido(cliente.getNNombreyApellido());

		if (listaCliente.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaClientes", listaCliente );
		return "listCliente";
	}
	
	@RequestMapping("/findDNI")
	public String findByNumDNI(Map<String, Object> model, @ModelAttribute Cliente cliente) throws ParseException {
		List<Cliente> listaCliente;
		cliente.setNumDNI(cliente.getNumDNI());
		listaCliente = cService.findByNumDNI(cliente.getNumDNI());

		if (listaCliente.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaClientes", listaCliente );
		return "listCliente";
	}

	@ModelAttribute("cliente")
	public Cliente createModel() {
	    return new Cliente();
	}
}
