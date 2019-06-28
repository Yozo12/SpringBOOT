package it.objectmethod.SpringBOOT_World_Map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.objectmethod.SpringBOOT_World_Map.dao.ICountryDao;
import it.objectmethod.SpringBOOT_World_Map.model.Country;

@Controller
public class CountryController {
	@Autowired
	private ICountryDao countryDaoImp;

	@RequestMapping("/continent")
	public String differentContinent(ModelMap model) {
		List<String> ContinentList = countryDaoImp.getContinentsName();
		model.addAttribute("continent", ContinentList);
		return "continentList";
	}

	@RequestMapping("/{continent}/nazioni")
	public String NazioniByContinent(@PathVariable("continent") String continent, ModelMap model) {
		List<Country> nationList = countryDaoImp.getCountriesByContinent(continent);
		model.addAttribute("nazioni", nationList);
		return "nationList";
	}

}
