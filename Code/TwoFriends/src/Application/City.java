package Application;

import java.util.HashMap;

public class City 
{ 
    private HashMap<City, Integer> children = new HashMap<City, Integer>(); 
    private int cityID; 
    private String info; 
  
    public City(String name, int id) //constructorul fiecarui oras
    { 
    	this.info=name;//informatiile despre oras (numele)
        this.cityID =id; //id-ul orasului
    } 
    public String getinfo() //returneaza informatiile(numele) despre oras
    { 
        return info; 
    } 
    
    public HashMap<City, Integer> getChildren() //returneaza lista cu copii orasului
    { 
        return children; 
    } 
    public int getID() //returneaza id-ul orasului
    { 
        return cityID; 
    } 
    
    public void addChild(City child, int value) //adauga un copil la lista
    { 
        children.put(child, value);
    } 
    
} 

