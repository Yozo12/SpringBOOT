package it.objectmethod.SpringBOOT_World_Map.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.SpringBOOT_World_Map.dao.ICountryDao;
import it.objectmethod.SpringBOOT_World_Map.model.Country;

@Service
public class CountryDaoImp extends NamedParameterJdbcDaoSupport implements ICountryDao {
	@Autowired
	public CountryDaoImp(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<String> getContinentsName() {
		List<String> country = null;
		String sql = "select distinct continent nameContinent from country";
		country = getJdbcTemplate().queryForList(sql, String.class);
		return country;
	}

	@Override
	public List<Country> getCountriesByContinent(String ParContinent) {
		List<Country> country = null;
		String sql = "select name nameNation, Code codNation, Continent nameContinent, population from country where continent=:continentparam";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("continentparam", ParContinent);
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return country;
	}

}
