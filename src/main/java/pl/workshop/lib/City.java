package pl.workshop.lib;

public class City {
	
	private int id;
	private String name;
	private District dictrict;

	public City() {
	}

	public City(int id, String name, District dictrict) {
		this.id = id;
		this.name = name;
		this.dictrict = dictrict;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public District getDictrict() {
		return dictrict;
	}

	public void setDictrict(District dictrict) {
		this.dictrict = dictrict;
	}

}
