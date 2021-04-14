package Application;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



public class Main {

	public static Gson gson;
	public static String[] choosenCities;
	
	public static void main(String[] args) throws IOException {
		
		
		City Arad=new City("Arad",0); //crearea fiecarui oras de pe harta
		City Timisoara =new City("Timisoara",1);//fiecare oras contine copii sai, numele si un id
		City Zerind =new City("Zerind",2);
		City Oradea =new City("Oradea", 3);
		City Sibiu =new City("Sibiu",4);
		City Lugoj =new City("Lugoj",5);
		City Mehadia =new City("Mehadia",6);
		City Drobeta =new City("Drobeta",7);
		City Rimnicu =new City("Rimnicu",8);
		City Fagaras =new City("Fagaras",9);
		City Pitesti =new City("Pitesti",10);
		City Craiova =new City("Craiova",11);
		City Bucharest=new City("Bucharest", 12);
		City Giurgiu= new City("Giurgiu", 13);
		City Urziceni= new City("Urziceni", 14);
		City Vaslui= new City("Vaslui", 15);
		City Iasi= new City("Iasi", 16);
		City Neamt= new City("Neamt", 17);
		City Hirsova= new City("Hirsova", 18);
		City Eforie= new City("Eforie", 19);
		
		Arad.addChild(Timisoara, 118); //crearea fiecarei muchii din graf
		Arad.addChild(Zerind, 75);
		Arad.addChild(Sibiu, 140);
		Timisoara.addChild(Arad, 118);
		Timisoara.addChild(Lugoj, 111);
		Zerind.addChild(Arad, 75);
		Zerind.addChild(Oradea, 71);
		Oradea.addChild(Zerind, 71);
		Oradea.addChild(Sibiu, 151);
		Sibiu.addChild(Arad, 140);
		
		Sibiu.addChild(Oradea, 151);
		Sibiu.addChild(Rimnicu, 80);
		Sibiu.addChild(Fagaras, 99);
		Lugoj.addChild(Timisoara, 111);
		Lugoj.addChild(Mehadia, 70);
		Mehadia.addChild(Lugoj, 70);
		Mehadia.addChild(Drobeta, 75);
		Drobeta.addChild(Mehadia, 75);
		Drobeta.addChild(Craiova, 120);
		Rimnicu.addChild(Sibiu, 80);
		
		Rimnicu.addChild(Craiova, 146);
		Rimnicu.addChild(Pitesti, 97);
		Fagaras.addChild(Sibiu, 99);
		Fagaras.addChild(Bucharest, 211);
		Pitesti.addChild(Rimnicu, 97);
		Pitesti.addChild(Bucharest, 101);
		Pitesti.addChild(Craiova, 138);
		Craiova.addChild(Pitesti, 138);
		Craiova.addChild(Drobeta, 120);
		Craiova.addChild(Rimnicu, 146);
		
		Bucharest.addChild(Pitesti, 101);
		Bucharest.addChild(Fagaras, 211);
		Bucharest.addChild(Giurgiu, 90);
		Bucharest.addChild(Urziceni, 85);
		Urziceni.addChild(Bucharest, 85);
		Urziceni.addChild(Hirsova, 98);
		Urziceni.addChild(Vaslui, 142);
		Vaslui.addChild(Urziceni, 142);
		Vaslui.addChild(Iasi, 92);
		Iasi.addChild(Vaslui, 92);
		
		Iasi.addChild(Neamt, 87);
		Hirsova.addChild(Urziceni, 98);
		Hirsova.addChild(Eforie, 86);
		Eforie.addChild(Hirsova, 86);
		Neamt.addChild(Iasi, 87);
		Giurgiu.addChild(Bucharest, 90);
		
		ArrayList<City> cities=new ArrayList<City>();
		cities.add(Arad);
		cities.add(Timisoara);
		cities.add(Zerind);
		cities.add(Oradea);
		cities.add(Sibiu);
		cities.add(Lugoj);
		cities.add(Mehadia);
		cities.add(Drobeta);
		cities.add(Rimnicu);
		cities.add(Fagaras); //lista cu toate orasele de pe harta
		
		cities.add(Pitesti);
		cities.add(Craiova);
		cities.add(Bucharest);
		cities.add(Giurgiu);
		cities.add(Urziceni);
		cities.add(Vaslui);
		cities.add(Iasi);
		cities.add(Neamt);
		cities.add(Hirsova);
		cities.add(Eforie);
		
		gson = new GsonBuilder().create();
		
		for(int i=0;i<10;i++) {
			long TimeEx;
			PriorityQueue p1=new PriorityQueue();//crearea cate unui queue pentru fiecare grup de 2 orase introduse
			String fileName = "C:\\Users\\Alina\\Desktop\\Code\\ExperimentalData\\input_"+i+".json";
			Path path = new File(fileName).toPath();
			
			try (Reader reader = Files.newBufferedReader(path, 
		            StandardCharsets.UTF_8)) {
		         choosenCities=gson.fromJson(reader, String[].class);
		         long startTime = System.nanoTime();//startTime ia valoarea timpului inainte de apelarea functiei de rezolvare a problemei
		         AStar.AStarSearch(cities, choosenCities[0].intern(), choosenCities[1].intern(), p1);
		         long stopTime = System.nanoTime();//timpul dupa rezolvarea problemei
		         TimeEx=stopTime-startTime;//se face diferenta intre timpul de stop si cel de start pt a afla timpul efectiv de executie al apelului
		    }    // nu este luat in calcul timupl de citire si scriere in fisier
			Gson gson1 = new GsonBuilder().create();
		    
		    String fileName1 = "C:\\Users\\Alina\\Desktop\\Code\\ExperimentalData\\output_"+i+".json";
		    
		    try (FileOutputStream fos = new FileOutputStream(fileName1);
			        OutputStreamWriter isr = new OutputStreamWriter(fos, 
			                StandardCharsets.UTF_8)) {
		    	gson1.toJson("The routes for the two friends from "+choosenCities[0].intern()+" to "+choosenCities[1].intern()+" are:", isr);
		    	gson1.toJson(p1.Printpaths(), isr);//scrierea in fisier a ruteluor prietenilor
		    	gson1.toJson("Timpul de executie: "+TimeEx+"ns", isr);//scrierea timpului
		    }
		}
		
	}

}
