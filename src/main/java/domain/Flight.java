package domain;

import java.sql.Time;

public class Flight {
	private String flightNumber;
	private double travelDistance;
	private double cost;
	private Time flightTime;

	public Flight(String flightNumber, double travelDistance, double cost, Time flightTime) {
		super();
		this.flightNumber = flightNumber;
		this.travelDistance = travelDistance;
		this.cost = cost;
		this.flightTime = flightTime;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", travelDistance=" + travelDistance + ", cost=" + cost
				+ ", flightTime=" + flightTime + "]";
	}

}
