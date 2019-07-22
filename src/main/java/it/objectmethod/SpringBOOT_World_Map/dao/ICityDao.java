package it.objectmethod.SpringBOOT_World_Map.dao;

import java.util.List;

import it.objectmethod.SpringBOOT_World_Map.model.City;

public interface ICityDao {
	public List<City> getCitiesNamebyCountry(String parNation);

	public int deleteCity(int id);

	public City getCityById(int id);

	public int modCity(City city);

	public int addCity(City city);

	public List<City> getCitiesNamebyCountryOrderBy(String codNazione, String ord);

}
