package com.softech.SpringMVC.Controller;

import com.softech.SpringMVC.Dao.Offer;
import com.softech.SpringMVC.Service.OffersService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OffersController {

//	@RequestMapping("/")
//	public String showHome() {
//		return("index");
//	}
	
	
	private OffersService OffersService;
	
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.OffersService = offersService;
	}



	@RequestMapping("/")
	public String showHome(Model model) {
		  List<Offer> offers  = OffersService.getCurrent();
		model.addAttribute("offers", offers);
		return "index";
	}
	
	
	@RequestMapping("/createOffer")
	public String getcreatOffer() {
		return "createOffer";
	}

	@RequestMapping(value = "offerCreateMessage", method = RequestMethod.POST)
	public String afterCreate(Model model, Offer offer) {

		OffersService.create(offer);
		List<Offer> offers = OffersService.getCurrent();
		model.addAttribute("offers", offers);
		return "offerCreateMessage";
	}

}






