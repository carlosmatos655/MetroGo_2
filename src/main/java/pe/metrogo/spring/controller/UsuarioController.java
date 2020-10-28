package pe.metrogo.spring.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.metrogo.spring.entity.Nacionalidad;
import pe.metrogo.spring.entity.Usuario;
import pe.metrogo.spring.service.INacionalidadService;
import pe.metrogo.spring.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private INacionalidadService nService;

	@Autowired
	private IUsuarioService uService;

	@RequestMapping("/")
	public String irUsuario(Map<String, Object> model) {
		model.put("listaUsuarios", uService.listar());
		return "listUsuario";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaNacionalidades", nService.listar());
		model.addAttribute("nacionalidad", new Nacionalidad());
		model.addAttribute("usuario", new Usuario());
		return "usuario";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Usuario objUsuario, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaNacionalidades", nService.listar());
			return "usuario";
		} else {
			boolean flag = uService.insertar(objUsuario);
			if (flag) {
				return "redirect:/usuario/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/usuario/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Usuario> objUsuario = uService.listarId(id);
		if (objUsuario == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/usuario/listar";
		} else {
			model.addAttribute("listaNacionalidades", nService.listar());
			if (objUsuario.isPresent())
				objUsuario.ifPresent(u -> model.addAttribute("usuario", u));
			return "usuario";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				uService.eliminar(id);
				model.put("listaUsuarios", uService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaUsuarios", uService.listar());
		}
		return "listUsuario";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaUsuarios", uService.listar());
		return "listUsuario";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException {
		nService.listarId(usuario.getCDNI());
		return "listUsuario";
	}

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Usuario usuario) throws ParseException {
		List<Usuario> listaUsuarios;
		usuario.setNNombreyApellido(usuario.getNNombreyApellido());
		listaUsuarios = uService.buscarUsuario(usuario.getNNombreyApellido());
		if (listaUsuarios.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("ListaUsuarios", listaUsuarios);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "usuario";
	}
}
