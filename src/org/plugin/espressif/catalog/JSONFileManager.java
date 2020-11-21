package org.plugin.espressif.catalog;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONFileManager {

    public static final String CATALOG_FILE = "catalog.json";
    
    private static final String nameSave = "name";
    private static final String typeSave = "type";
    private static final String descriptionSave = "description";
    private JSONArray data;

    private FileWriter writer;

    public JSONFileManager() throws IOException, ParseException {
        File file = new File(CATALOG_FILE);

        if (!file.exists()) {
            file.createNewFile();
        }
        
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(file);
        data = (JSONArray) parser.parse(reader);
        reader.close();
        
        writer = new FileWriter(file);
    }

    public void addItem(Item item) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(nameSave, item.getName());
        jsonObject.put(typeSave, item.getType().name();
        jsonObject.put(descriptionSave, item.getDescription());
        data.add(jsonObject);
    }
    
    public void save() throws IOException {
        writer.write(data.toJSONString());
        writer.close();
    }

    public List<Item> loadItemList() {
    	List<Item> items = new ArrayList<Item>();
    	
    	Iterator<JSONObject> iterator = data.iterator();
    	
    	while (iterator.hasNext()) {
			JSONObject jsonObject = iterator.next();
			Item item = new Item((String) jsonObject.get(nameSave), ItemType.valueOf((String)jsonObject.get(typeSave)),
					(String) jsonObject.get(descriptionSave));
			items.add(item);
		}
    	
    	return items;
    }
}
