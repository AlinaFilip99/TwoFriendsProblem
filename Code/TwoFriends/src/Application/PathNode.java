package Application;

import java.util.LinkedList;

public class PathNode 
{ 
private City city = null; 
private PathNode previousNode = null; 
public PathNode(City p, PathNode previous) 
{ 
city = p; 
previousNode = previous; 
} 

public City getCity() 
{ 
return city; //returneaza orasul din nod
} 

public LinkedList<City> collapse() 
{ 
LinkedList<City> path= new LinkedList<City>();//creaza lista cu orase; 
PathNode node = this; //nodul este elementul apelant
while (node != null) //cat timp node este diferit de null
{ 
path.addFirst(node.city); //adauga la inceput fiecare oras
node = node.previousNode; //nodul devine nodul alterior al orasului adaugat
} 

return path; //returneaza lista
} 

public static void createPaths(BFS bfsl, BFS bfs2, int connection, PriorityQueue p1) 
{ 
PathNode endl = bfsl.visited.get(connection); //calea catre nodul final al sursei
PathNode end2 = bfs2.visited.get(connection); //calea catre nodul final al destinatiei

LinkedList<City> pathOne = endl.collapse(); //alcatuieste lista de orase incepand cu orasul final
LinkedList<City> pathTwo = end2.collapse(); //alcatuieste lista de orase incepand cu orasul final

int H=AStar.CalculateH(pathOne)+AStar.CalculateH(pathTwo);//calculeaza distanta totala a putei pentru ambi prieteni
p1.addPaths(pathOne, pathTwo, H);//adauga ruta la Queue

}
} 
