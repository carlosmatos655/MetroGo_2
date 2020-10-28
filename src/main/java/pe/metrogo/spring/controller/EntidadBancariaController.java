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

import pe.metrogo.spring.entity.EntidadBancaria;
import pe.metrogo.spring.service.IEntidadBancariaService;

@Controller
@RequestMapping("/entidad")
public class EntidadBancariaController {

	@Autowired
	private IEntidadBancariaService eService;

	@RequestMapping("/")
	public String irEntidad(Map<String, Object> model) {
		model.put("listaEntidades", eService.listar());
		return "listEntidad";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("entidad", new EntidadBancaria());
		return "entidad";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid EntidadBancaria objEntidad, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "entidadbancaria";
		} else {
			boolean flag = eService.insertar(objEntidad);
			if (flag) {
				return "redirect:/entidad/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/entidad/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<EntidadBancaria> objEntidad = eService.listarId(id);
		if (objEntidad == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/entidad/listar";
		} else {
			model.addAttribute("entidad", objEntidad);
			return "entidad";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				eService.eliminar(id);
				model.put("listaEntidades", eService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaEntidades", eService.listar());
		}
		return "listEntidad";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaEntidades", eService.listar());
		return "listEntidad";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute EntidadBancaria entidad) throws ParseException {
		eService.listarId(entidad.getCEntidad());
		return "listNacionalidad";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute EntidadBancaria entidad) throws ParseException {
		List<EntidadBancaria> listaEntidades;
		entidad.setNEntidad(entidad.getNEntidad());
		listaEntidades = eService.buscarEntidadBancaria(entidad.getNEntidad());
		if (listaEntidades.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("ListaEntidades", listaEntidades);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("entidad", new EntidadBancaria());
		return "entidad";
	}
}
