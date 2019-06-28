package it.objectmethod.SpringBOOT_World_Map.dao;

import java.util.List;

import it.objectmethod.SpringBOOT_World_Map.model.City;
import it.objectmethod.SpringBOOT_World_Map.model.Country;

public interface ICityDao {
	public List<City> getCitiesNamebyCountry(String parNation);

	public void deleteCity(int id);

	public City getCityById(int id);

	public void modCity(City city);

	public void addCity(City city);

	public List<City> getCitiesNamebyCountryOrderBy(String codNazione, String ord);

	public List<Country> getAllCountries();
}
