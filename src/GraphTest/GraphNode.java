package GraphTest;

import java.util.*;

public class GraphNode {
	private int index;
	private String name;
	private ArrayList<GraphNode> neighbours= new ArrayList<GraphNode>();
	private boolean isVisited = false;
	private GraphNode parent;
	
	public GraphNode(String name,int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	public ArrayList<GraphNode> getNeighbour() {
		return neighbours;
	}
	public void setNeighbours(ArrayList<GraphNode> neighbours) {
		this.neighbours = neighbours;
	}
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}
	public GraphNode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return  name ;
	}

}
	
	
