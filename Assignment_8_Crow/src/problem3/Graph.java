package problem3;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Graph {
	private HashMap<String, Vertex> map;

	public Graph()
	{
		map = new HashMap<>();
	}

	public void addEdge(String v1, String v2, int weight)
	{
		//ensure each vertex exists in map
		addVertex(v1);
		addVertex(v2);
		//connect vertex1 to vertex2 with given weight
		map.get(v1).addEdge(v2, weight);
	}
	public void addEdge(String v1, String v2)
	{
		addEdge(v1, v2, 1);
	}
	public void addUndirectedEdge(String v1, String v2, int weight)
	{
		addEdge(v1, v2, weight);
		addEdge(v2, v1, weight);
	}
	public void addUndirectedEdge(String v1, String v2)
	{
		addUndirectedEdge(v1, v2, 1);
	}

	private void addVertex(String v)
	{
		if(!map.containsKey(v))//if vertex isn't already in the map
		{
			map.put(v, new Vertex(v));//create vertex and add to map
		}
	}
	public String toString()
	{
		String output = "Graph:\n";

		if(map.size() > 0)
		{
			for(Entry<String,Vertex> e : map.entrySet())
			{
				output += "("+e.getKey()+", "+e.getValue()+")\n";
			}
		}

		return output;
	}

	public void printPath(String vs, String ve, String type)
	{
		if(map.containsKey(vs) && map.containsKey(ve))
		{
			System.out.println(type.toUpperCase());
			Vertex s = map.get(vs);
			if(type.toLowerCase().equals("unweighted"))
			{
				unweighted(s);
			}
			else if(type.toLowerCase().equals("weighted"))
			{
				weighted(s);
			}
			else if(type.toLowerCase().equals("negative"))
			{
				negative(s);
			}
			Vertex e = map.get(ve);
			/*
			 * Pseudocode
			if(e.dist != INFINITY){
				String path = "";
				Vertex curr = e;
				while(curr.path != null){
					path += curr;
					curr = curr.path;
				}
				path = s + path;
				print(path)
				print(dist)
			}else{
				print("can not reach end");
			}
			 */
			if(e.dist != Integer.MAX_VALUE)
			{
				String path = "";
				Vertex curr = e;
				while(curr.path != null)
				{
					if(path != "")
					{
						path = curr.getName() + "," + path;
					}
					else
					{
						path = curr.getName();
					}
					curr = curr.path;
				}
				path = s.getName() + "," + path;
				System.out.println(path);
				System.out.println(e.dist);
			}
			else
			{
				System.out.println("End is not reachable from Start");
			}
		}
	}
	public void unweighted(Vertex s)
	{
		/*
		 * Pseudocode from textbook PG 372
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist == INFINITY){
					w.dist = v.dist + 1;
					w.path = v;
					q.enqueue(w);
				}
			}
		}
		 */
		LinkedList<Vertex> q = new LinkedList<>();//can be used like a queue
		for(Entry<String, Vertex> vertexEntry : map.entrySet())
		{
			Vertex v = vertexEntry.getValue();
			v.dist = Integer.MAX_VALUE;//~2+ billion ~INFINITY
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.addLast(s);//queue.enqueue is FIFO, so add at end and take off beginning
		while(!q.isEmpty())
		{
			Vertex v = q.removeFirst();//q.dequeue();, remove from beginning because adding to end
			for(Entry<String, Integer> adjacent : v.getAdjacencyList().entrySet())
			{
				Vertex w = map.get(adjacent.getKey());//adjacent.getKey is name of adjacent vertex
				if(w.dist == Integer.MAX_VALUE)//INFINITY
				{
					w.dist = v.dist + 1;
					w.path = v;//how we got to this vertex
					q.addLast(w);//q.enqueue(w);
				}
			}
		}
	}
	public void weighted(Vertex s)
	{
		/*
		 * Pseudocode
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		//implement Comparable<Vertex> based on distance for PriorityQueue
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
			v.known = false;
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();//smallest distance in queue
			v.known = true;
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
				}
				if(!w.known){
					q.enqueue(w);
				}
			}
		}
		 */
		PriorityQueue<Vertex> q = new PriorityQueue<>();
		for(Entry<String, Vertex> vertexEntry : map.entrySet())
		{
			Vertex v = vertexEntry.getValue();
			v.dist = Integer.MAX_VALUE;//INFINITY
			v.path = null;//added to make sure we clear the path between runs of pathing methods
			v.known = false;
		}
		s.dist = 0;
		q.offer(s);//q.enqueue(s);
		while(!q.isEmpty())
		{
			Vertex v = q.poll();//q.dequeue();//smallest distance in queue
			//System.out.println(v.getName()+":"+q.size());
			v.known = true;
			for(Entry<String, Integer> adjacent : v.getAdjacencyList().entrySet())
			{
				Vertex w = map.get(adjacent.getKey());//adjacent.getKey is name of adjacent vertex
				Integer weight = adjacent.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					w.path = v;
				}
				if(!w.known){
					q.offer(w);//q.enqueue(w);
				}
			}
		}

	}
	public void negative(Vertex s)
	{
		/*
		 * Pseudocode
		Queue<Vertex> q = new Queue<Vertex>();
		for each Vertex v{
			v.dist = INFINITY;
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.enqueue(s);
		while(!q.isEmpty()){
			Vertex v = q.dequeue();
			for each Vertex w adjacent to v{
				if(w.dist > v.dist + w.weight){
					w.dist = v.dist + w.weight;
					w.path = v;
					if(!q.contains(w)){
						q.enqueue(w);
					}
				}
			}
		}
		 */
		LinkedList<Vertex> q = new LinkedList<>();//can be used like a queue
		for(Entry<String, Vertex> vertexEntry : map.entrySet())
		{
			Vertex v = vertexEntry.getValue();
			v.dist = Integer.MAX_VALUE;//~2+ billion ~INFINITY
			v.path = null;//added to make sure we clear the path between runs of pathing methods
		}
		s.dist = 0;
		q.addLast(s);//queue.enqueue is FIFO, so add at end and take off beginning
		while(!q.isEmpty())
		{
			Vertex v = q.removeFirst();//q.dequeue();, remove from beginning because adding to end
			for(Entry<String, Integer> adjacent : v.getAdjacencyList().entrySet())
			{
				Vertex w = map.get(adjacent.getKey());//adjacent.getKey is name of adjacent vertex
				Integer weight = adjacent.getValue();
				if(w.dist > v.dist + weight){
					w.dist = v.dist + weight;
					if(w.dist < 0)//stop negative cycle infinite recursion
						w.dist = 0;
					w.path = v;
					if(!q.contains(w)){
						q.addLast(w);//q.enqueue(w);
					}
				}
			}
		}
	}


	public void printMaxDistance()
	{
		int maxDist = 0;
		String vert = "";
		for(Map.Entry<String, Vertex> vertex : map.entrySet())
			if(vertex.getValue().dist != Integer.MAX_VALUE && vertex.getValue().dist > maxDist)
			{
				maxDist = vertex.getValue().dist;
				vert = vertex.getKey();
			}
		System.out.println("MAX:"+vert+":"+maxDist);
	}
	
    public void topologicalSort(){ // THIS RUNS IN O(N^3)
    	MyQueue<Vertex> stack = new MyQueue<>(); //1
        // 1
    	for(Vertex vertex : map.values()){ // O(N^3)
        	if(vertex.known == false) { // 1N
        		topologicalSortHelper(stack, vertex); // O(N^2)
        	}
        	// 1N
        }
        
        stack.printStack();
    }
    private void topologicalSortHelper(MyQueue<Vertex> stack, Vertex vertex){ // O(N^2)
        vertex.known = true;
    	for(Vertex va : map.values()) { // O(N^2)
        	if(va.known == false) {
        		topologicalSortHelper(stack, va); //O(N)
        	}
        }
    	stack.enqueue(vertex); // O(1)
    }
}
