package org.germes.presentation.admin.bean;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.itsimulator.germes.app.model.entity.geography.City;
import org.itsimulator.germes.app.model.transform.Transformable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * {@link CityBean} is value holder of the city data
 * for admin project
 * @author Morenets
 *
 */
@Named("currentCity")
@ViewScoped
@ToString
@Getter @Setter
public class CityBean implements Serializable, Transformable<City> {
	private static final long serialVersionUID = -2187178300935394009L;

	private int id;
	
	private String name;
	
	private String district;
	
	private String region;	

	/**
	 * Clears bean content
	 */
	public void clear() {
		id = 0;
		setName("");
		setDistrict("");
		setRegion("");
	}

	@Override
	public void transform(City city) {
	}

	@Override
	public City untransform(City city) {
		return city;
	}

}
