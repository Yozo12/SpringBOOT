package it.objectmethod.SpringBOOT_World_Map.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Service;

import it.objectmethod.SpringBOOT_World_Map.dao.ICityDao;
import it.objectmethod.SpringBOOT_World_Map.model.City;
import it.objectmethod.SpringBOOT_World_Map.model.Country;
import it.objectmethod.SpringBOOT_World_Map.utils.Constants;

@Service
public class CityDaoImp extends NamedParameterJdbcDaoSupport implements ICityDao {
	@Autowired
	public CityDaoImp(DataSource dataSource) {
		super();
		setDataSource(dataSource);
	}

	@Override
	public List<City> getCitiesNamebyCountry(String parNation) {
		List<City> CityDao = null;
		String sql = "select t1.ID id, t1.Name cityName, t1.CountryCode codNation, t1.Population population from city t1 JOIN country t2 ON t1.countrycode=t2.Code  where t1.CountryCode=:Codiceparam ";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("Codiceparam", parNation);
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);

		CityDao = getNamedParameterJdbcTemplate().query(sql, params, rm);
		return CityDao;
	}

	@Override
	public void deleteCity(int id) {
		String sql = "delete from city where id=:id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public City getCityById(int id) {
		City CityDao = null;
		String sql = "select Name cityName,CountryCode codNation,population population,ID id from city where id=:id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		CityDao = getNamedParameterJdbcTemplate().queryForObject(sql, params, rm);
		return CityDao;
	}

	@Override
	public void modCity(City city) {
		String sql = "UPDATE city SET city.Name =:parName, city.population=:parPop, city.countryCode =:parCode where city.ID= :id";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", city.getId());
		params.addValue("parName", city.getCityName());
		params.addValue("parPop", city.getPopulation());
		params.addValue("parCode", city.getCodNation());
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public void addCity(City city) {
		String sql = "INSERT INTO city(Name, population, CountryCode) VALUES ( :parName , :parPop , :parCode)";
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parName", city.getCityName());
		params.addValue("parPop", city.getPopulation());
		params.addValue("parCode", city.getCodNation());
		getNamedParameterJdbcTemplate().update(sql, params);
	}

	@Override
	public List<City> getCitiesNamebyCountryOrderBy(String codNazione, String ord) {

		List<City> CityDao = null;
		String parametro = null;
		String qry = "select t1.ID id, t1.Name cityName, t1.CountryCode  codNation, t1.Population population from city t1 JOIN country t2 ON t1.countrycode=t2.Code  where t1.CountryCode=:parCode ";
		if (ord.equals(Constants.AZ)) {
			parametro = "order by cityName ASC";
			qry = qry + parametro;
		} else if (ord.equals(Constants.ZA)) {
			parametro = "order by cityName DESC";
			qry = qry + parametro;
		} else if (ord.equals(Constants.POPA)) {
			parametro = " order by population ASC";
			qry = qry + parametro;
		} else if (ord.equals(Constants.POPD)) {
			parametro = " order by population DESC";
			qry = qry + parametro;
		}
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("parCode", codNazione);
		BeanPropertyRowMapper<City> rm = new BeanPropertyRowMapper<City>(City.class);
		CityDao = getNamedParameterJdbcTemplate().query(qry, params, rm);
		return CityDao;
	}

	@Override
	public List<Country> getAllCountries() {

		String sql = "select Code codNation,Name nameNation, Population population,Continent nameContinent from country";
		List<Country> country = null;
		BeanPropertyRowMapper<Country> rm = new BeanPropertyRowMapper<Country>(Country.class);
		country = getNamedParameterJdbcTemplate().query(sql, rm);
		return country;
	}
}
