package it.objectmethod.SpringBOOT_World_Map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.SpringBOOT_World_Map.dao.ICountryDao;
import it.objectmethod.SpringBOOT_World_Map.model.Country;

@RestController
public class CountryController {
	@Autowired
	private ICountryDao countryDaoImp;

	@GetMapping("/continent")
	public List<String> differentContinent(ModelMap model) {
		List<String> ContinentList = countryDaoImp.getContinentsName();
		model.addAttribute("continent", ContinentList);
		return ContinentList;
	}

	@GetMapping("/{continent}/nazioni")
	public List<Country> NazioniByContinent(@PathVariable("continent") String continent, ModelMap model) {
		List<Country> nationList = countryDaoImp.getCountriesByContinent(continent);
		model.addAttribute("nazioni", nationList);
		return nationList;
	}

}
