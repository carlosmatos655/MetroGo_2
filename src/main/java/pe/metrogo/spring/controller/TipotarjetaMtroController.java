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

import pe.metrogo.spring.entity.TipotarjetaMtro;
import pe.metrogo.spring.service.ITipotarjetaMtroService;

@Controller
@RequestMapping("/ttarjetametro")
public class TipotarjetaMtroController {

	@Autowired
	private ITipotarjetaMtroService tService;

	@RequestMapping("/")
	public String irTipotarjetaMtro(Map<String, Object> model) {
		model.put("listaTTarjetasMetro", tService.listar());
		return "listTTarjetaMetro";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("ttarjetametro", new TipotarjetaMtro());
		return "ttarjetametro";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute ("ttarjetametro") @Valid TipotarjetaMtro ttarjetametro, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "ttarjetametro";
		} else {
			boolean flag = tService.insertar(ttarjetametro);
			if (flag) {
				return "redirect:/ttarjetametro/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/ttarjetametro/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<TipotarjetaMtro> objTipotarjetaMtro = tService.listarId(id);
		if (objTipotarjetaMtro == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/ttarjetametro/listar";
		} else {
			model.addAttribute("ttarjetametro", objTipotarjetaMtro);
			return "ttarjetametro";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaTTarjetasMetro", tService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaTTarjetasMetro", tService.listar());
		}
		return "listTTarjetaMetro";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTTarjetasMetro", tService.listar());
		return "listTTarjetaMetro";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute TipotarjetaMtro ttarjetametro) throws ParseException {
		tService.listarId(ttarjetametro.getCTTarjetaMetro());
		return "listTTarjetaMetro";
	}
	
	@RequestMapping("/find")
	public String findByNTTarjetaMetro(Map<String, Object> model, @ModelAttribute TipotarjetaMtro ttarjetametro) throws ParseException {
		List<TipotarjetaMtro> listaTTarjetaMetro;
		ttarjetametro.setNTTarjetaMetro(ttarjetametro.getNTTarjetaMetro());
		listaTTarjetaMetro = tService.findByNTTarjetaMetro(ttarjetametro.getNTTarjetaMetro());

		if (listaTTarjetaMetro.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaTTarjetasMetro", listaTTarjetaMetro );
		return "listTTarjetaMetro";
	}
	
	@ModelAttribute("ttarjetametro")
	public TipotarjetaMtro createModel() {
	    return new TipotarjetaMtro();
	}
}
