package org.itsimulator.germes.app.service.benchmark;

import java.util.Set;

import org.itsimulator.germes.app.model.entity.base.AbstractEntity;
import org.itsimulator.germes.app.model.entity.geography.Station;

public class CityCopy extends AbstractEntity {
	private String name;

	private String district;

	private String region;

	private Set<Station> stations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Set<Station> getStations() {
		return stations;
	}

	public void setStations(Set<Station> stations) {
		this.stations = stations;
	}
}