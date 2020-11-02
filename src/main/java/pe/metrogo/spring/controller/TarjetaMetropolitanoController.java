package pe.metrogo.spring.controller;

import java.text.ParseException;
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

import pe.metrogo.spring.entity.TarjetaMetropolitano;
import pe.metrogo.spring.service.ITarjetaMetropolitanoService;

@Controller
@RequestMapping("/tmetro")
public class TarjetaMetropolitanoController {

	@Autowired
	private ITarjetaMetropolitanoService tService;

	@RequestMapping("/")
	public String irTarjetaMetropolitano(Map<String, Object> model) {
		model.put("listaTMetros", tService.listar());
		return "listTMetro";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("tmetro", new TarjetaMetropolitano());
		return "tmetro";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid TarjetaMetropolitano objTMetro, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "tmetro";
		} else {
			boolean flag = tService.insertar(objTMetro);
			if (flag) {
				return "redirect:/tmetro/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/tmetro/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<TarjetaMetropolitano> objTMetro = tService.listarId(id);
		if (objTMetro == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/tmetro/listar";
		} else {
			model.addAttribute("tmetro", objTMetro);
			return "tmetro";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaTMetros", tService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaTMetros", tService.listar());
		}
		return "listTMetro";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTMetros", tService.listar());
		return "listTMetro";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute TarjetaMetropolitano tmetro) throws ParseException {
		tService.listarId(tmetro.getCTarjetaMetro());
		return "listTMetro";
	}
	
	/*
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute TarjetaMetropolitano tmetro) throws ParseException {
		List<TarjetaMetropolitano> listaTMetros;
		tmetro.setDVencimiento(tmetro.getCTarjetaMetro());
		listaNacionalidades = nService.buscarNacionalidad(nacionalidad.getNNacionalidad());
		if (listaNacionalidades.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("ListaNacionalidades", listaNacionalidades);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("nacionalidad", new Nacionalidad());
		return "nacionalidad";
	}
	*/
}