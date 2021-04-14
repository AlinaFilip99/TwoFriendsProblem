package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class AStar {
	public static void AStarSearch(ArrayList<City> cities, String a, String b, PriorityQueue p) {
		BiBFS.findPathBiBFS(cities, a, b, p);//apelarea functiei de cautare bidirectional BFS
	}
	
	public static int CalculateH(LinkedList<City> a) {//calculul distantei pentru o ruta unui prieten
		int h=0;
		HashMap<City, Integer> children =new HashMap<City, Integer>();
		int i=0;
		while(i<a.size()-1) {//cat timp i este mai mic decat numarul oraselor din lista -1
			children=a.get(i).getChildren();//se obtin copii orasului curent
			i++;//incrementare i si trecerea la orasul urmator
			for(City i1 : children.keySet()) {//pentru fiecare oras copil ar orasului
				if(a.get(i).getinfo()==i1.getinfo()) {//daca numele orasului urmator dupa orasul curent este egal cu cel al orasului copil
					h=h+children.get(i1);//se aduna valoarea copilului la distanta, care este defapt distanta dintre orasul curent si cel urmator
					
				}
				
			}
		}
		return h;//returneaza distanta rutei
	}
}
