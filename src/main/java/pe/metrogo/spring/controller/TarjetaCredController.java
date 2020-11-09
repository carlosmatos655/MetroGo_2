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

import pe.metrogo.spring.entity.EntidadBancaria;
import pe.metrogo.spring.entity.TarjetaCred;
import pe.metrogo.spring.entity.TipotarjetaCred;
import pe.metrogo.spring.entity.Cliente;
import pe.metrogo.spring.service.IClienteService;
import pe.metrogo.spring.service.IEntidadBancariaService;
import pe.metrogo.spring.service.ITarjetaCredService;
import pe.metrogo.spring.service.ITipotarjetaCredService;

@Controller
@RequestMapping("/tarjeta")
public class TarjetaCredController {

	@Autowired
	private ITarjetaCredService tService;

	@Autowired
	private IClienteService cService;

	@Autowired
	private ITipotarjetaCredService iService;

	@Autowired
	private IEntidadBancariaService eService;

	@RequestMapping("/")
	public String irUsuario(Map<String, Object> model) {
		model.put("listaTarjetas", tService.listar());
		return "listTarjeta";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("listaClientes", cService.listar());
		model.addAttribute("listaEntidades", eService.listar());
		model.addAttribute("listaTTarjetas", iService.listar());
		model.addAttribute("tarjeta", new TarjetaCred());
		model.addAttribute("cliente", new Cliente());
		model.addAttribute("entidad", new EntidadBancaria());
		model.addAttribute("ttarjeta", new TipotarjetaCred());
		return "tarjeta";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute @Valid TarjetaCred objTarjeta, BindingResult binRes, Model model)
			throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaClientes", cService.listar());
			model.addAttribute("listaEntidades", eService.listar());
			model.addAttribute("listaTTarjetas", iService.listar());
			return "tarjeta";
		} else {
			boolean flag = tService.insertar(objTarjeta);
			if (flag) {
				return "redirect:/tarjeta/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/tarjeta/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<TarjetaCred> objTarjeta = tService.listarId(id);
		if (objTarjeta == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/tarjeta/listar";
		} else {
			model.addAttribute("listaClientes", cService.listar());
			model.addAttribute("listaEntidades", eService.listar());
			model.addAttribute("listaTTarjetas", iService.listar());
			if (objTarjeta.isPresent())
				objTarjeta.ifPresent(t -> model.addAttribute("tarjeta", t));
			return "tarjeta";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaTarjetas", tService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Sucedio un error");
			model.put("listaTarjetas", tService.listar());
		}
		return "listTarjeta";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTarjetas", tService.listar());
		return "listTarjeta";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute TarjetaCred tarjeta) throws ParseException {
		tService.listarId(tarjeta.getCTarjeta());
		return "listTarjeta";
	}

	/*
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute TarjetaCred tarjeta) throws ParseException {
		List<TarjetaCred> listaTarjetas;
		tarjeta.setUsuario(tarjeta.getUsuario());
		listaTarjetas = tService.buscarUsuario(tarjeta.getUsuario());
		if (listaTarjetas.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("ListaTarjetas", listaTarjetas);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("tarjeta", new TarjetaCred());
		return "tarjeta";
	}
	*/
}
