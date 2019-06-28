package it.objectmethod.SpringBOOT_World_Map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.SpringBOOT_World_Map.dao.ICityDao;
import it.objectmethod.SpringBOOT_World_Map.model.City;
import it.objectmethod.SpringBOOT_World_Map.model.Country;
import it.objectmethod.SpringBOOT_World_Map.model.wrappers.CityandCountriesWrapper;
import it.objectmethod.SpringBOOT_World_Map.utils.Constants;

@RestController
public class CityController {

	@Autowired
	private ICityDao CityDaoImp;

	@GetMapping("/citta/elenco")
	public List<City> cittaByNazioni(@RequestParam("nazione") String nazione, ModelMap model) {

		List<City> cityList = CityDaoImp.getCitiesNamebyCountry(nazione);
		model.addAttribute("citta", cityList);
		model.addAttribute("AZ", Constants.AZ);
		model.addAttribute("POPA", Constants.POPA);

		return cityList;
	}

	@DeleteMapping("/citta")
	public String Delete(@RequestParam("cityid") int cityid, @RequestParam("codNazione") String codNazione) {
		CityDaoImp.deleteCity(cityid);
		return "fatto";
	}

	@GetMapping("/citta/{id}")
	public CityandCountriesWrapper cittaLoad(@PathVariable("id") int id, ModelMap model) {
		CityandCountriesWrapper wrapper = new CityandCountriesWrapper();
		List<Country> listNazioni = null;
		City cittabyid = null;
		listNazioni = CityDaoImp.getAllCountries();
		wrapper.setCountries(listNazioni);
		if (id > 0) {

			cittabyid = CityDaoImp.getCityById(id);
			wrapper.setCity(cittabyid);
		}
		model.addAttribute("nazioni", wrapper);
		model.addAttribute("citta", wrapper);

		return wrapper;

	}

	@PostMapping("/citta")
	public String modificaAggiungi(@RequestBody City city) {

		if (city.getId() != "") {
			CityDaoImp.modCity(city);
		} else if (city.getId() == "") {
			CityDaoImp.addCity(city);
		}
		return "fatto";
	}

	@GetMapping("/citta")
	public List<City> ordina(@RequestParam("codNazione") String codNazione, @RequestParam("ord") String ord,
			ModelMap model) {

		String AZ = null;
		String POPA = null;
		if (ord.equals(Constants.AZ)) {
			AZ = Constants.ZA;
		} else {
			AZ = Constants.AZ;
		}
		if (ord.equals(Constants.POPA)) {
			POPA = Constants.POPD;
		} else {
			POPA = Constants.POPA;
		}
		List<City> cityList = CityDaoImp.getCitiesNamebyCountryOrderBy(codNazione, ord);
		model.addAttribute("citta", cityList);
		model.addAttribute("AZ", AZ);
		model.addAttribute("POPA", POPA);
		return cityList;
	}
}