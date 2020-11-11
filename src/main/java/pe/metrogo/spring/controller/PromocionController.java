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

import pe.metrogo.spring.entity.Promocion;
import pe.metrogo.spring.service.IPromocionService;

@Controller
@RequestMapping("/promocion")
public class PromocionController {

	@Autowired
	private IPromocionService pService;

	@RequestMapping("/")
	public String irPromocion(Map<String, Object> model) {
		model.put("listaPromociones", pService.listar());
		return "listPromocion";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("promocion", new Promocion());
		return "promocion";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid Promocion objPromocion, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			return "promocion";
		} else {
			boolean flag = pService.insertar(objPromocion);
			if (flag) {
				return "redirect:/promocion/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/promocion/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Promocion> objPromocion = pService.listarId(id);
		if (objPromocion == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/promocion/listar";
		} else {
			model.addAttribute("promocion", objPromocion);
			return "promocion";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaPromociones", pService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaPromociones", pService.listar());
		}
		return "listPromocion";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPromociones", pService.listar());
		return "listPromocion";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute Promocion promocion) throws ParseException {
		pService.listarId(promocion.getCPromocion());
		return "listPromocion";
	}
	
	@RequestMapping("/find")
	public String findByNPromocion(Map<String, Object> model, @ModelAttribute Promocion promocion) throws ParseException {
		List<Promocion> listaPromocion;
		promocion.setNPromocion(promocion.getNPromocion());
		listaPromocion = pService.findByNPromocion(promocion.getNPromocion());

		if (listaPromocion.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listaPromociones", listaPromocion );
		return "listPromocion";
	}
	
	@ModelAttribute("nacionalidad")
	public Promocion createModel() {
	    return new Promocion();
	}
}
