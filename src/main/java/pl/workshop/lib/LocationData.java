package pl.workshop.lib;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class LocationData implements Serializable {

	private static final long serialVersionUID = 1L;

	// all available data
	private List<District> districts;
	private List<City> allCities;
	private List<Street> allStreets;
	
	// data reloaded with ajax
	private List<City> cities;
	private List<Street> streets;

	// selected objects
	private District district;
	private City city;
	private Street street;

	@PostConstruct
	public void init() {
		districts = new ArrayList<>();
		districts.add(new District(0, "opolskie"));
		districts.add(new District(1, "dolno�l�skie"));
		districts.add(new District(2, "�l�skie"));
		districts.add(new District(3, "pomorskie"));
		districts.add(new District(4, "mazowieckie1"));

		allCities = new ArrayList<>();
		allCities.add(new City(0, "Opole", districts.get(0)));
		allCities.add(new City(1, "Prudnik", districts.get(0)));
		allCities.add(new City(2, "Brzeg", districts.get(0)));
		allCities.add(new City(3, "Nysa", districts.get(0)));
		allCities.add(new City(4, "Wroc�aw", districts.get(1)));
		allCities.add(new City(5, "O�awa", districts.get(1)));
		allCities.add(new City(6, "Legnica", districts.get(1)));
		allCities.add(new City(7, "Katowice", districts.get(2)));
		allCities.add(new City(8, "Gliwice", districts.get(2)));
		allCities.add(new City(9, "Tychy", districts.get(2)));

		allStreets = new ArrayList<>();
		allStreets.add(new Street(0, "Rynek", allCities.get(0)));
		allStreets.add(new Street(1, "Kwiatowa", allCities.get(5)));
		allStreets.add(new Street(2, "Opolska", allCities.get(7)));
		allStreets.add(new Street(3, "Ciemna", allCities.get(9)));
		allStreets.add(new Street(4, "Jasna", allCities.get(2)));
		allStreets.add(new Street(5, "Kasztanowa", allCities.get(0)));
		allStreets.add(new Street(6, "Liliowa", allCities.get(1)));
		allStreets.add(new Street(7, "D�uga", allCities.get(4)));
		allStreets.add(new Street(8, "Kili�skiego", allCities.get(3)));
		allStreets.add(new Street(9, "Brzechwy", allCities.get(6)));

		cities = new ArrayList<>();
		streets = new ArrayList<>();

	}

	public List<District> getDistricts() {
		return districts;
	}

	public List<City> getCities() {
		cities.clear();
		if (district == null) {
			district = districts.get(0);
		}		
		for (City c : allCities) {
			if (district.getId() == c.getDictrict().getId()) {
				cities.add(c);
			}
		}
		city = cities.get(0);		
		return cities;
	}

	public List<Street> getStreets() {
		streets.clear();		
		for (Street s : allStreets) {
			if (city.getId() == s.getCity().getId()) {
				streets.add(s);
			}
		}		
		street = streets.get(0);		
		return streets;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Street getStreet() {
		return street;
	}

	public void setStreet(Street street) {
		this.street = street;
	}

}
