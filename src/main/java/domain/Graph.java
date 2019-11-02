package domain;

import java.util.LinkedList;
import java.util.List;

public class Graph<V, E> {
	private String graphName;
	private int numOfVertices;
	private int numOfEdges;
	private int graphType;
	private LinkedList<Vertex<V, E>> vertices;

	public Graph(String graphName, int graphType) {
		super();
		this.graphName = graphName;
		this.graphType = graphType;
		vertices = new LinkedList<Vertex<V, E>>();
	}

	public Vertex<V, E> insertVertex(V inputVertex) {
		Vertex<V, E> vertex = new Vertex<V, E>();
		vertex.setElement(inputVertex);
		numOfVertices++;
		vertices.add(vertex);
		return vertex;
	}

	public Edge<V, E> insertEdge(Vertex<V, E> src, Vertex<V, E> dest, E element) {
		for (int i = 0; i < src.getIncidence_list_out().size(); i++) {
			Edge edge = src.getIncidence_list_out().get(i);
			for (int j = 0; j < dest.getIncidence_list_in().size(); j++) {
				if (edge.equals(dest.getIncidence_list_in().get(j)))
					throw new IllegalArgumentException("This edge already exists");
			}
		}
		Edge<V, E> edge = new Edge<V, E>();
		edge.setElement(element);
		edge.setSource(src);
		edge.setDestination(dest);
		src.getIncidence_list_out().add(edge);
		dest.getIncidence_list_in().add(edge);
		numOfEdges++;
		return edge;
	}

	public void removeVertex(Vertex<V, E> vertex) {
		for (int i = 0; i < vertex.getIncidence_list_out().size(); i++) {
			vertex.getIncidence_list_out().get(i).getDestination().getIncidence_list_in().remove(i);
			vertex.getIncidence_list_out().remove(i);
		}
		vertices.remove(vertex);
		numOfVertices--;
	}

	public void removeEdge(Edge<V, E> egde) {
		egde.getSource().getIncidence_list_out().remove(egde);
		egde.getDestination().getIncidence_list_in().remove(egde);
		numOfEdges--;
	}

	public boolean validate(Edge<V, E> edge) {
		for (int i = 0; i < vertices.size(); i++) {
			Vertex<V, E> v = vertices.get(i);
			for (int j = 0; j < v.getIncidence_list_out().size(); j++) {
				if (v.getIncidence_list_out().get(j).equals(edge))
					return true;
			}
			for (int j = 0; j < v.getIncidence_list_in().size(); j++) {
				if (v.getIncidence_list_in().get(j).equals(edge))
					return true;
			}

		}
		return false;
	}

	public int numVertices() {
		return numOfVertices;
	}

	public void vertices() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.println(vertices.get(i).getElement());
		}
	}

	public int numEdges() {
		return numOfEdges;
	}

	public void edges() {
		for (int i = 0; i < vertices.size(); i++) {
			Vertex<V, E> v = vertices.get(i);
			System.out.println("All edges from vertex number " + i + " are:");
			for (int j = 0; j < v.getIncidence_list_out().size(); j++) {
				System.out.println("Outgoing edge number " + j + " : " + v.getIncidence_list_out().get(j));
			}
			for (int j = 0; j < v.getIncidence_list_in().size(); j++) {
				System.out.println("Ingoing edge number " + j + " : " + v.getIncidence_list_in().get(j));
			}
			System.out.println();

		}
	}

	public Edge<V, E> getEdge(Vertex<V, E> src, Vertex<V, E> dest) { // here i assumed that the graph is directed bc
																		// the question requiers a directed graph
		if (graphType == 1) {
			for (int i = 0; i < src.getIncidence_list_out().size(); i++) {
				if (src.getIncidence_list_out().get(i).getDestination().equals(dest))
					return src.getIncidence_list_out().get(i);
			}
		}
		return null;
	}

	public int outDegree(Vertex<V, E> src) {
		return src.getIncidence_list_out().size();
	}

	public int inDegree(Vertex<V, E> src) { // in directed graphs, not necessarily that outDegree equals the inDegree as
											// it in the undirected graph
		return src.getIncidence_list_in().size();
	}

	public void outGoingEdges(Vertex<V, E> vertex) {
		for (int i = 0; i < vertex.getIncidence_list_out().size(); i++) {
			System.out.println("OutGoing edge number " + (i + 1) + " is " + vertex.getIncidence_list_out().get(i));
		}
	}

	public void inGoingEdges(Vertex<V, E> vertex) {
		for (int i = 0; i < vertex.getIncidence_list_in().size(); i++) {
			System.out.println("inGoing edge number " + (i + 1) + " is " + vertex.getIncidence_list_in().get(i));

		}
	}

}