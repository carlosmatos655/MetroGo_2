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
import pe.metrogo.spring.service.INacionalidadService;

@Controller
@RequestMapping("/nacionalidad")
public class NacionalidadController {

	@Autowired
	private INacionalidadService nService;

	@RequestMapping("/bienvenido")
	public String irNacionalidadBienvenido() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irNacionalidad(Map<String, Object> model) {
		model.put("listaNacionalidades", nService.listar());
		return "listNacionalidad";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("nacionalidad", new Nacionalidad());
		return "nacionalidad";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Nacionalidad objNacionalidad, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "nacionalidad";
		} else {
			boolean flag = nService.insertar(objNacionalidad);
			if (flag) {
				return "redirect:/nacionalidad/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/nacionalidad/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Nacionalidad> objNacionalidad = nService.listarId(id);
		if (objNacionalidad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/nacionalidad/listar";
		} else {
			model.addAttribute("nacionalidad", objNacionalidad);
			return "nacionalidad";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				nService.eliminar(id);
				model.put("listaNacionalidades", nService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaNacionalidades", nService.listar());
		}
		return "listNacionalidad";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaNacionalidades", nService.listar());
		return "listNacionalidad";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Nacionalidad nacionalidad) throws ParseException {
		nService.listarId(nacionalidad.getCNacionalidad());
		return "listNacionalidad";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Nacionalidad nacionalidad) throws ParseException {
		List<Nacionalidad> listaNacionalidades;
		nacionalidad.setNNacionalidad(nacionalidad.getNNacionalidad());
		listaNacionalidades = nService.buscarNacionalidad(nacionalidad.getNNacionalidad());
		if (listaNacionalidades.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("ListaNacionalidades", listaNacionalidades);
		return "listNacionalidad";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("nacionalidad", new Nacionalidad());
		return "Bnacionalidad";
	}
}
