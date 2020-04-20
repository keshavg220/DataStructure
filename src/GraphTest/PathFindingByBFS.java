package GraphTest;
import java.util.*;

public class PathFindingByBFS {
	ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
	
	public PathFindingByBFS(ArrayList<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	public static void pathPrint(GraphNode node) {
		if(node.getParent()!=null) {
			pathPrint(node.getParent());
		}
			System.out.print(node + " ");
		
	}
	
	void BFSForSSSP(GraphNode node) {
		LinkedList<GraphNode>queue = new LinkedList<GraphNode>();
		queue.add(node);
		while(!queue.isEmpty()) {
			GraphNode presentNode = queue.remove(0);
			presentNode.setVisited(true);
			System.out.print("Printing path for node "+presentNode.getName()+": ");
			pathPrint(presentNode);
			System.out.println();
			for(GraphNode neighbour :presentNode.getNeighbour()) {
				if(!neighbour.isVisited()) {
					queue.add(neighbour);
					neighbour.setVisited(true);
					neighbour.setParent(presentNode);
				}
			}
		}
	}
	public void addUndirectedEdge(int i,int j) {
		GraphNode first = nodeList.get(i);
		GraphNode second = nodeList.get(j);
		first.getNeighbour().add(second);
		second.getNeighbour().add(first);
		
	}
}