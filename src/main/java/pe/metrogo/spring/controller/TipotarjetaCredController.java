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

import pe.metrogo.spring.entity.TipotarjetaCred;
import pe.metrogo.spring.service.ITipotarjetaCredService;

@Controller
@RequestMapping("/ttarjeta")
public class TipotarjetaCredController {

	@Autowired
	private ITipotarjetaCredService tService;

	@RequestMapping("/")
	public String irTipotarjetaCred(Map<String, Object> model) {
		model.put("listaTTarjetas", tService.listar());
		return "listTTarjeta";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("ttarjeta", new TipotarjetaCred());
		return "ttarjeta";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid TipotarjetaCred objTTarjeta, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "ttarjeta";
		} else {
			boolean flag = tService.insertar(objTTarjeta);
			if (flag) {
				return "redirect:/ttarjeta/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/ttarjeta/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<TipotarjetaCred> objTTarjeta = tService.listarId(id);
		if (objTTarjeta == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/ttarjeta/listar";
		} else {
			model.addAttribute("ttarjeta", objTTarjeta);
			return "ttarjeta";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaTTarjetas", tService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaTTarjetas", tService.listar());
		}
		return "listTTarjeta";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTTarjetas", tService.listar());
		return "listTTarjeta";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute TipotarjetaCred ttarjeta) throws ParseException {
		tService.listarId(ttarjeta.getCTTarjeta());
		return "listTTarjeta";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute TipotarjetaCred ttarjeta) throws ParseException {
		List<TipotarjetaCred> listaTTarjetas;
		ttarjeta.setNTTarjeta(ttarjeta.getNTTarjeta());
		listaTTarjetas = tService.buscarTipotarjetaCred(ttarjeta.getNTTarjeta());
		if (listaTTarjetas.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("ListaTTarjetas", listaTTarjetas);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("ttarjeta", new TipotarjetaCred());
		return "ttarjeta";
	}
}
