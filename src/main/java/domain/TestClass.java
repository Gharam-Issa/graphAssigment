package domain;

public class TestClass {

	public static void main(String[] args) {
		Airport airport = new Airport("DFW", "Germany");
		Graph<Airport, Flight> graph = new Graph<Airport, Flight>("graph1", 0);
	}
}
