package it.objectmethod.SpringBOOT_World_Map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.SpringBOOT_World_Map.dao.ICityDao;
import it.objectmethod.SpringBOOT_World_Map.model.City;
import it.objectmethod.SpringBOOT_World_Map.utils.Constants;

@CrossOrigin
@RestController
public class CityController {

	@Autowired
	private ICityDao cityDaoImp;

	@GetMapping("/citta/elenco")
	public List<City> cittaByNazioni(@RequestParam("nazione") String nazione, ModelMap model) {

		List<City> cityList = cityDaoImp.getCitiesNamebyCountry(nazione);
		model.addAttribute("citta", cityList);
		model.addAttribute("AZ", Constants.AZ);
		model.addAttribute("POPA", Constants.POPA);

		return cityList;
	}

	@DeleteMapping("/citta/elimina")
	public ResponseEntity<Integer> delete(@RequestParam("id") int cityid) {
		int ret = cityDaoImp.deleteCity(cityid);
		if (ret != 1) {
			return new ResponseEntity<Integer>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(ret, HttpStatus.OK);
	}

	@GetMapping("/citta/load")
	public City cittaLoad(@RequestParam("id") int id, ModelMap model) {
		City cittabyid = null;
		if (id > 0) {
			cittabyid = cityDaoImp.getCityById(id);
		}
		model.addAttribute("citta", cittabyid);
		return cittabyid;
	}

	@PostMapping("/citta")
	public ResponseEntity<Integer> modificaAggiungi(@RequestBody City city) {
		int ret = 0;

		if (city.getId() > 0) {
			ret = cityDaoImp.modCity(city);

		} else if (city.getId() == 0) {
			ret = cityDaoImp.addCity(city);

		}
		if (ret != 1) {
			return new ResponseEntity<Integer>(ret, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(ret, HttpStatus.OK);

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
		List<City> cityList = cityDaoImp.getCitiesNamebyCountryOrderBy(codNazione, ord);
		model.addAttribute("citta", cityList);
		model.addAttribute("AZ", AZ);
		model.addAttribute("POPA", POPA);
		return cityList;
	}
}