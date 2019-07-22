package it.objectmethod.SpringBOOT_World_Map.dao;

import java.util.List;

import it.objectmethod.SpringBOOT_World_Map.model.Country;

public interface ICountryDao {
	public List<String> getContinentsName();

	public List<Country> getCountriesByContinent(String ParContinent);

	public List<Country> getAllCountries();
}
