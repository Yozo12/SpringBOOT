package it.objectmethod.SpringBOOT_World_Map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.SpringBOOT_World_Map.dao.ICountryDao;
import it.objectmethod.SpringBOOT_World_Map.model.Country;

@CrossOrigin
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

	@GetMapping("/nazioni")
	public List<Country> NazioniByContinent(@RequestParam("continent") String continent, ModelMap model) {
		List<Country> nationList = countryDaoImp.getCountriesByContinent(continent);
		model.addAttribute("nazioni", nationList);
		return nationList;
	}

	@GetMapping("/allnazioni")
	public List<Country> allNazioni() {
		List<Country> nationList = countryDaoImp.getAllCountries();
		return nationList;
	}

}
