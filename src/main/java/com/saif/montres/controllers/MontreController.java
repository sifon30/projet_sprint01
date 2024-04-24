package com.saif.montres.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.saif.montres.entities.Montre;
import com.saif.montres.service.MontreService;
@Controller
public class MontreController {
@Autowired
MontreService montreService;
 @RequestMapping("/ListeMontres")
public String listeMontres(ModelMap modelMap , @RequestParam (name="page",defaultValue = "0") int page,
		@RequestParam (name="size", defaultValue = "2") int size)

{
	 Page<Montre> mons = montreService.getAllMontresParPage(page, size);
	 modelMap.addAttribute("montres", mons);
	  modelMap.addAttribute("pages", new int[mons.getTotalPages()]);
	 modelMap.addAttribute("currentPage", page);
	 modelMap.addAttribute("size", size);

	 return "listeMontres";

}
 @RequestMapping("/showCreate")
public String showCreate()
{
return "createMontre";
}
@RequestMapping("/saveMontre")
public String saveMontre(@ModelAttribute("Montre") Montre montre, 
@RequestParam("date") String date,
ModelMap modelMap) throws ParseException 
{
//conversion de la date 
 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
 Date dateCreation = dateformat.parse(String.valueOf(date));
 montre.setDateCreation(dateCreation);
 
Montre saveMontre = montreService.saveMontre(montre);
String msg ="montre enregistré avec Id "+saveMontre.getIdMontre();
modelMap.addAttribute("msg", msg);
return "createMontre";
}

@RequestMapping("/supprimerMontre")
public String supprimerMontre(@RequestParam("id") Long id,ModelMap modelMap, @RequestParam (name="page",defaultValue = "0") int page,
 @RequestParam (name="size", defaultValue = "2") int size)

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
public String editerMontre(@RequestParam("id") Long id,
 ModelMap modelMap)
{
Montre m= montreService.getMontre(id);
modelMap.addAttribute("montre", m);
return "editerMontre";
}
@RequestMapping("/updateMontre")
public String updateMontre(@ModelAttribute("montre") Montre 
montre, @RequestParam("date") String date,
 ModelMap modelMap) throws ParseException 
{
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
