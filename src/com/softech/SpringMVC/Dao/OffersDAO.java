package com.softech.SpringMVC.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;



@Component("offersDao")
public class OffersDAO {
	private NamedParameterJdbcTemplate jdbc;
	
	public OffersDAO() {
		System.out.println("Successfully configured OffersDAO");
		
	}	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Offer> getOffers() {

		return jdbc.query("select * from test",new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();

				offer.setId(rs.getInt("id"));
				offer.setUsername(rs.getString("username"));
				offer.setPassword(rs.getString("password"));
				

				return offer;
			}

		});
	}


public boolean create(Offer offer) {
		
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into test (id,username, password) values (:id,:username, :password)", params) == 1;
	}
			
	}

	
	
	
	





