package problem3;

public class GraphTester {

	public static void main(String[] args) {
		Graph g = new Graph();

		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		g.addEdge("C", "A");
		g.addEdge("C", "D");
		g.addEdge("D", "E");
		g.addEdge("E", "F");
		g.addEdge("A", "B");
		g.addEdge("Y", "Z");

//		System.out.println(g);

		//g.printPath("A", "D", "unweighted");
		//g.printPath("D", "E", "weighted");
		//g.printPath("A", "D", "negative");//

		g.topologicalSort();;

	}

}
