package domain;

import java.util.LinkedList;

public class Vertex<V, E> {
	private V element;
	private LinkedList<Edge> incidence_list_out;
	private LinkedList<Edge> incidence_list_in;

	public Vertex() {
		super();
		incidence_list_out = new LinkedList<Edge>();
		incidence_list_in = new LinkedList<Edge>();
	}

	public V getElement() {
		return element;
	}

	public void setElement(V element) {
		this.element = element;
	}

	public LinkedList<Edge> getIncidence_list_out() {
		return incidence_list_out;
	}

	public void setIncidence_list_out(LinkedList<Edge> incidence_list_out) {
		this.incidence_list_out = incidence_list_out;
	}

	public LinkedList<Edge> getIncidence_list_in() {
		return incidence_list_in;
	}

	public void setIncidence_list_in(LinkedList<Edge> incidence_list_in) {
		this.incidence_list_in = incidence_list_in;
	}

}
