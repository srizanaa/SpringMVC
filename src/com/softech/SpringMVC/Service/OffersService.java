package com.softech.SpringMVC.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.softech.SpringMVC.Dao.Offer;
import com.softech.SpringMVC.Dao.OffersDAO;

@Service("offerservice")

public class OffersService {
	private OffersDAO offersDao;
	
	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}
	
	
	public List<Offer> getCurrent(){
		return offersDao.getOffers();
	}
	
	
	public boolean create(Offer offer){
		return	offersDao.create(offer);
		}
		


}
