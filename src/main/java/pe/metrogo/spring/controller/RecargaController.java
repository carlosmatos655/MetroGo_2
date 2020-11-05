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

import pe.metrogo.spring.entity.Promocion;
import pe.metrogo.spring.entity.Recarga;
import pe.metrogo.spring.entity.TarjetaMetropolitano;
import pe.metrogo.spring.service.IPromocionService;
import pe.metrogo.spring.service.IRecargaService;
import pe.metrogo.spring.service.ITarjetaMetropolitanoService;

@Controller
@RequestMapping("/recarga")
public class RecargaController {

	@Autowired
	private IRecargaService rService;
	
	@Autowired
	private IPromocionService pService;

	@Autowired
	private ITarjetaMetropolitanoService tService;

	@RequestMapping("/")
	public String irRecarga(Map<String, Object> model) {
		model.put("listaRecargas", rService.listar());
		return "listRecarga";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listPromociones", pService.listar());
		model.addAttribute("listTMetros", tService.listar());
		model.addAttribute("promocion", new Promocion());
		model.addAttribute("tmetro", new TarjetaMetropolitano());
		model.addAttribute("recarga", new Recarga());
		return "recarga";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Recarga objRecarga, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listPromociones", pService.listar());
			model.addAttribute("listTMetros", tService.listar());
			return "recarga";
		} else {
			boolean flag = rService.insertar(objRecarga);
			if (flag) {
				return "redirect:/recarga/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/recarga/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Recarga> objRecarga = rService.listarId(id);
		if (objRecarga == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/recarga/listar";
		} else {
			model.addAttribute("listPromociones", pService.listar());
			model.addAttribute("listTMetros", tService.listar());
			if (objRecarga.isPresent())
				objRecarga.ifPresent(r -> model.addAttribute("recarga", r));
			return "recarga";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				rService.eliminar(id);
				model.put("listaRecargas", rService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaRecargas", rService.listar());
		}
		return "listRecarga";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaRecargas", rService.listar());
		return "listRecarga";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Recarga recarga) throws ParseException {
		rService.listarId(recarga.getCRecarga());
		return "listRecarga";
	}
	
	/*
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Nacionalidad nacionalidad) throws ParseException {
		List<Nacionalidad> listaNacionalidades;
		nacionalidad.setNNacionalidad(nacionalidad.getNNacionalidad());
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
