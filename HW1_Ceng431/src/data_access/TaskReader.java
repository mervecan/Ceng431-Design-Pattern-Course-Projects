package data_access;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import business.Tasks;

public class TaskReader {
	public HashMap<String, Double> readTasksProbablities() throws NumberFormatException, IOException{
		
	
	String filePath = "file/test.txt";
    HashMap<String, Double> map = new HashMap<String, Double>();

    String line;
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    while ((line = reader.readLine()) != null)
    {
        String[] parts = line.split(":", 2);
        if (parts.length >= 2)
        {
        		for( Tasks t : Tasks.values()) {
        			if(t.name().equals(parts[0])){
        				String key = parts[0];
        				if(Double.valueOf(parts[1])<= 1 && Double.valueOf(parts[1]) >= 0) {
        					Double value = Double.valueOf(parts[1]);
            	            map.put(key, value);
        				}     
        			}
        		}
        } else {
            System.out.println("ignoring line: " + line);
        }
    }

    for (String key : map.keySet())
    {
        //System.out.println(key + ":" + map.get(key));
    }
    reader.close();
    return map;
	}
}
