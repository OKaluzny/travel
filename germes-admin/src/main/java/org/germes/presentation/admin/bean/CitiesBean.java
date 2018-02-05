package org.germes.presentation.admin.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.service.GeographicService;

@Named
@RequestScoped
/**
 * Managed bean that keeps all the cities for the main page
 * 
 * @author Morenets
 *
 */
public class CitiesBean {

	private final GeographicService geographicService;
	
	@Inject
	public CitiesBean(GeographicService geographicService) {
		this.geographicService = geographicService;
	}

	public List<City> getCities() {
		return geographicService.findCities();
	}
}
