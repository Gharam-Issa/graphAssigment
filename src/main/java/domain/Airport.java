package domain;

public class Airport {
	private String airport_code;
	private String city;

	public Airport(String airport_code, String city) {
		super();
		this.airport_code = airport_code;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Airport [airport_code=" + airport_code + ", city=" + city + "]";
	}

}
