package it.objectmethod.SpringBOOT_World_Map.model;

public class City {

	int population, id;

	String cityName, codNation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCodNation() {
		return codNation;
	}

	public void setCodNation(String codNation) {
		this.codNation = codNation;
	}

}