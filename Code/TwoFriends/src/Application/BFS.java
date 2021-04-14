package Application;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS 
{ 
public Queue<PathNode> toVisit = new LinkedList<PathNode>(); 
public HashMap<Integer, PathNode> visited = new HashMap<Integer, PathNode>(); 

public BFS(City root) 
{ 
PathNode sourcePath = new PathNode(root, null); //creeaza o cale catre radacina
toVisit.add(sourcePath); //adauga calea la noduri de vizitat
visited.put(root.getID(), sourcePath); //adauga radacina ca nod vizitat
} 
public boolean isFinished() 
{ 
return toVisit.isEmpty(); //verifica daca lista cu noduri de vizitat este goala
} 
}
