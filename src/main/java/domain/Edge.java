package domain;

public class Edge<V, E> {
	private E element;
	private Vertex<V, E> source;
	private Vertex<V, E> destination;

	public Edge() {
		super();
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Vertex<V, E> getSource() {
		return source;
	}

	public void setSource(Vertex<V, E> source) {
		this.source = source;
	}

	public Vertex<V, E> getDestination() {
		return destination;
	}

	public void setDestination(Vertex<V, E> destination) {
		this.destination = destination;
	}

}
