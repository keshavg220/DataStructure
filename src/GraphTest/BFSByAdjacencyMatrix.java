package GraphTest;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFSByAdjacencyMatrix {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	int [][] adjacencyMatrix;
	
	public BFSByAdjacencyMatrix(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
		adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
	}
	void bfs() {
		for(GraphNode node:nodeList) {
			if(!node.isVisited()) {
				bfsVisit(node);
			}
		}
	}
	
	void bfsVisit(GraphNode node) {
		LinkedList<GraphNode>queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove(0);
			presentNode.setVisited(true);
			System.out.print(presentNode.getName()+" ");
			
			ArrayList<GraphNode> neighbour = getNeighbours(presentNode);
			for(GraphNode neighbours : neighbour) {
				if(!neighbours.isVisited()) {
					queue.add(neighbours);
					neighbours.setVisited(true);
				}
			}
		}
	}
	public  ArrayList<GraphNode> getNeighbours(GraphNode node) {
		ArrayList<GraphNode> neighbours = new ArrayList<GraphNode>();
		
		//gets row# to search in node index
		int nodeIndex = node.getIndex();
	
		for(int i=0; i<adjacencyMatrix.length;i++) {
			//if a column has 1 in that row then there is a neighbor and add it to list
			if(adjacencyMatrix[nodeIndex][i]==1) {
				neighbours.add(nodeList.get(i));
			}
		}
		return neighbours;
	}
	
	
	// add an undirected edge between two nodes
	public void addUndirectedEdge(int i, int j) {
		//decrement i, j for array indexes
		i--;
		j--;
		adjacencyMatrix[i][j] = 1;
		adjacencyMatrix[j][i] = 1;
		
	}
	
}