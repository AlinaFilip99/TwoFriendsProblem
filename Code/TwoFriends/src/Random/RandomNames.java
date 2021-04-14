package Random;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;


public class RandomNames {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<String> cities=new ArrayList<String>();
		cities.add("Arad");
		cities.add("Timisoara");
		cities.add("Zerind");
		cities.add("Oradea");
		cities.add("Sibiu");
		cities.add("Lugoj");
		cities.add("Mehadia");
		cities.add("Drobeta");
		cities.add("Rimnicu");
		cities.add("Fagaras");//lista cu numele de orase disponibile
		cities.add("Pitesti");
		cities.add("Craiova");
		cities.add("Bucharest");
		cities.add("Giurgiu");
		cities.add("Urziceni");
		cities.add("Vaslui");
		cities.add("Iasi");
		cities.add("Neamt");
		cities.add("Hirsova");
		cities.add("Eforie");

		
		for(int i=0;i<10;i++) {//se creeaza 10 fisiere input
		Gson gson = new Gson();
		String fileName = "C:\\Users\\Alina\\Desktop\\Code\\ExperimentalData\\input_"+i+".json";
		try (FileOutputStream fos = new FileOutputStream(fileName);
		        OutputStreamWriter isr = new OutputStreamWriter(fos, 
		                StandardCharsets.UTF_8)) {
			Random nr1=new Random();//crearea a 2 numere random
			Random nr2=new Random();
			
			String City1=cities.get(nr1.nextInt(cities.size()));//Alegarea numelui corespunzator cifrei random
			String City2=cities.get(nr2.nextInt(cities.size()));//din lista
			
			String[] choosenCities= {"x", "y"};//crearea unui vector string
			choosenCities[0]=City1;//asignarea valorilor--orasul prietenului 1
			choosenCities[1]=City2;//orasul prietenului 2
			
			gson.toJson(choosenCities, isr);//scrierea in fisier a vectorului
	}
		}

}
}
