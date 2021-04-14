package Application;

import java.util.HashMap;
import java.util.LinkedList;

public class PriorityQueue {
	
	private static HashMap<HashMap<LinkedList<City>, LinkedList<City>>, Integer> route;//lista cu rutele celor 2 prieteni si distanta acesteia
	private static HashMap<LinkedList<City>, LinkedList<City>> minroute;//ruta cu distanta minima gasita
	 
	public PriorityQueue() {
		route=new HashMap<HashMap<LinkedList<City>, LinkedList<City>>, Integer>();//crearea listei
		minroute=new HashMap<LinkedList<City>, LinkedList<City>>();//crearea rutei minime
	}

	public void addPaths(LinkedList<City> route1, LinkedList<City> route2, int h) {//adauga rutele prietenilor in tabel si distanta
		
		HashMap<LinkedList<City>, LinkedList<City>> aux=new HashMap<LinkedList<City>, LinkedList<City>>();//creaza o lista auxilioara care adaugarutele intr-un tabel
		aux.put(route1, route2);//adauga rutele individuale in lista
		route.put(aux, h);//adauga lista cu rutele in lista si distanta
	}
	
	public static void minH() {//calculul rutei cu distanta minima
		
		int min=32000;//initializare minim
		for(HashMap<LinkedList<City>, LinkedList<City>> i1 : route.keySet()) {//pentru fiecare lista cu rute in tabel
				if(route.get(i1)<min) {//daca distanta este mai mica ca minimul
					minroute=i1;//ruta minima devine lista cu rute
					min=route.get(i1);//minimul devine distanta listei adaugate
				}
		}
	}
	
	public String Printpaths() {//returneaza un string cu rutele fiecarui prieten
		minH();//calculaeaza ruta cu distanta minima
		String route1=" ";
		String route2=" ";
				for(LinkedList<City> i2 : minroute.keySet()) {//pentru ruta prietenului 1
					for(int i=0;i<i2.size();i++) {//pt fiecare element din lista
						route1=route1+i2.get(i).getinfo()+" ";//se aduga numele orasului la string
					}
				}	
				for(LinkedList<City> i3 : minroute.values()) {//pentru ruta prietenului 2
					for(int j=0;j<i3.size();j++) {//pt fiecare element din lista
						route2=route2+i3.get(j).getinfo()+" ";//adauga numele orasului la lista
					}
				}
				String routes="Prietenul 1: ["+route1+"]; Prietenul 2: ["+route2+"]";//creaza un string pentru reprezentarea mai stilizata a rezultatului in fisier folosind string-urile cu rutele prietenilor
				return routes;//returneaza string-ul ce trebuie scris in fisier
			
	}
	
	
	
}
