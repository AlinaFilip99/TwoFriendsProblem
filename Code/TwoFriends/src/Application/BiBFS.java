package Application;

import java.util.ArrayList;
import java.util.HashMap;

public class BiBFS{

public static void findPathBiBFS(ArrayList<City> cities, String source, String destination,PriorityQueue p1) 
{ 
	City sourceC=null;//initializare oras sursa(de plecare)
	City destinationC=null;//initilizare oras destinatie
	for(int i=0;i<cities.size();i++) {//pt fiecare oras in lista de orase
		if(cities.get(i).getinfo()==source) {//daca numele orasului este egal cu cel al orasului sursa
			sourceC=cities.get(i);//orasul sursa devine orasul respectiv
		}
		
		if(cities.get(i).getinfo()==destination) {//daca numele orasului este egal cu cel al orasului destinatie
			destinationC=cities.get(i);//orasul destinatie devine orasul respectiv
		}
	}
	if(sourceC==null  || destinationC==null) {//Daca nu s-au gasit orasele sursa si destinatie in lista de orase
		System.out.println("Error");//acestea nu au fost introduse corect, deloc sau nu exista
	}
BFS sourceData = new BFS(cities.get(sourceC.getID())); //crearea unui BFS de la sursa
BFS destData = new BFS(cities.get(destinationC.getID())); //crearea unui BFS de la destinatie
City collision=null;//coliziunea dintre ele este nula la inceput
while (!sourceData.isFinished() && !destData.isFinished()) //cat timp mai sunt orase de vizitat in BFS sursa si destinatie
{ 

collision = searchLevel(cities, sourceData, destData); //se cauta o coliziune de la sursa la destinatie
if (collision != null) {
	 PathNode.createPaths(sourceData, destData, collision.getID(), p1);//cand se gaseste una se creaza caile pentru prieteni
}

collision = searchLevel(cities, destData, sourceData); //se cauta o coliziune de la destinatie la sursa
if (collision != null) {
	PathNode.createPaths(sourceData, destData, collision.getID(), p1); //cand se gaseste una se creaza caile pentru prieteni
}	
} 

} 


public static City searchLevel(ArrayList<City> cities, BFS primary, BFS secondary) 
{ 

int count = primary.toVisit.size(); //se extrage numarul de noduri ce trebuie vizitate pentru BFS-ul primar
for (int i= 0; i < count; i++) //pt fiecare nod ce trebuie vizitat
{ 

PathNode pathNode = primary.toVisit.poll(); //se creeaza o cale care nodul ce trebuie vizitat
int cityid = pathNode.getCity().getID(); //se obtine id-ul orasului ce trebuie vizitat

if (secondary.visited.containsKey(cityid)) //daca BFS-ul secundar contine in nodurile vizitate orasul ce trebuie vizitat
		return pathNode.getCity();//inseamna ca a aparut o coliziune, deci se returneaza orasul respectiv

City city = pathNode.getCity();//se extrage orasul ce trebuie vizitat 
HashMap<City, Integer> children = city.getChildren(); //se obtin copii orasului ce trebuie vizitat
for (City i1 : children.keySet()) //pentru fiecare oras copil ar orasului ce trebuie vizitat
{ 
if (!primary.visited.containsKey(i1.getID())) //daca orasul copil nu a fost vizitat de BFS-ul primar
{ 	
        City child= cities.get(i1.getID()); //se obtine orasul copil
        PathNode next = new PathNode(child, pathNode); //se creaza o cale catre orasul copil cu previousnode fiind orasul parinte
        primary.visited.put(i1.getID(), next); //se adauga orasul copil in lista cu noduri vizitate
        primary.toVisit.add(next);//se treze la urmatorul oras de vizitat
} 
} 
} 
return null; //daca nu s-a gasit nicio coliziune nu returneaza nimic
} 





}


