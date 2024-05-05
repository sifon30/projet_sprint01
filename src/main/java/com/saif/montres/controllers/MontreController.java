package com.saif.montres.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.saif.montres.entities.Genre;
import com.saif.montres.entities.Montre;
import com.saif.montres.service.MontreService;

import jakarta.validation.Valid;

@Controller
public class MontreController {
	@Autowired
	MontreService montreService;
	@GetMapping("/accessDenied")
	public String error()
	{
	return "accessDenied";
	}


	@RequestMapping("/ListeMontres")
	public String listeMontres(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		Page<Montre> mons = montreService.getAllMontresParPage(page, size);
		modelMap.addAttribute("montres", mons);
		modelMap.addAttribute("pages", new int[mons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);

		return "listeMontres";

	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("montre", new Montre());
		List<Genre> gens = montreService.getAllGenres();
		modelMap.addAttribute("mode","new");
		modelMap.addAttribute("genres", gens);

		return "formMontre";
	}

	@RequestMapping("/saveMontre")
	public String saveMontre(@Valid Montre montre, BindingResult bindingResult,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size){
		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors())		return "formMontre";		
		if (montre.getIdMontre()==null) //ajout
			isNew=true;
		montreService.saveMontre(montre);
		if (isNew) //ajout
		{
		Page<Montre> mons = montreService.getAllMontresParPage(page, size);
		currentPage = mons.getTotalPages()-1;
		}
		else //modif
			currentPage=page;
		
		return ("redirect:/ListeMontres?page="+currentPage+"&size="+size);

			


	}

	@RequestMapping("/supprimerMontre")
	public String supprimerMontre(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size)

	{
		montreService.deleteMontreById(id);
		Page<Montre> mons = montreService.getAllMontresParPage(page, size);
		modelMap.addAttribute("montres", mons);
		modelMap.addAttribute("pages", new int[mons.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeMontres";
	}

	@RequestMapping("/modifierMontre")
	public String editerMontre(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Montre m = montreService.getMontre(id);
		List<Genre> gens = montreService.getAllGenres();

		modelMap.addAttribute("montre", m);
		modelMap.addAttribute("mode","edit");
		modelMap.addAttribute("genres", gens);
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);



		return "formMontre";
	}

	@RequestMapping("/updateMontre")
	public String updateMontre(@ModelAttribute("montre") Montre montre, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
//conversion de la date 
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		montre.setDateCreation(dateCreation);

		montreService.updateMontre(montre);
		List<Montre> mons = montreService.getAllMontres();
		modelMap.addAttribute("montres", mons);
		return "listeMontres";
	}
}
