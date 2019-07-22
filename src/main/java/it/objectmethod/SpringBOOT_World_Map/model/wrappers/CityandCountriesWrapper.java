package it.objectmethod.SpringBOOT_World_Map.model.wrappers;

import java.util.List;

import it.objectmethod.SpringBOOT_World_Map.model.City;
import it.objectmethod.SpringBOOT_World_Map.model.Country;

public class CityandCountriesWrapper {
	City city;
	List<Country> countries;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
