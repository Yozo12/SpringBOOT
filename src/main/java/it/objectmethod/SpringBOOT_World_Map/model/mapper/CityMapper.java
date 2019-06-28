package it.objectmethod.SpringBOOT_World_Map.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import it.objectmethod.SpringBOOT_World_Map.model.City;

public class CityMapper implements org.springframework.jdbc.core.RowMapper<City> {

	@Override
	public City mapRow(ResultSet rs, int rowNum) throws SQLException {
		City city = new City();
		city.setCityName(rs.getString("Name"));
		city.setCodNation(rs.getString("CountryCode"));
		city.setId(rs.getString("ID"));
		city.setPopulation(rs.getInt("population"));
		return city;

	}
}