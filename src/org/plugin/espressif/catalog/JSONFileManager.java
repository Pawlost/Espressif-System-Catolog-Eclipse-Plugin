package org.plugin.espressif.catalog;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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

    private IFile file;

    public JSONFileManager() throws IOException, ParseException, CoreException {
        Path path = new Path(CATALOG_FILE);
        file = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(path);
       
        if (!file.exists()) {
            file.create(new ByteArrayInputStream("".getBytes()), IResource.NONE, null);;
        } else {
        	
            InputStreamReader isReader = new InputStreamReader(file.getContents());
            //Creating a BufferedReader object
            BufferedReader reader = new BufferedReader(isReader);
            StringBuffer sb = new StringBuffer();
            String str;
            while((str = reader.readLine())!= null){
               sb.append(str);
            }
        	
        	if (file.getContents().available() > 0) {
            JSONParser parser = new JSONParser();
            data = (JSONArray) parser.parse(sb.toString());
            reader.close();
        	} else {
        		data = new JSONArray();
        	}
        }
    }

    public void addItem(Item item) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(nameSave, item.getName());
        jsonObject.put(typeSave, item.getType().name());
        jsonObject.put(descriptionSave, item.getDescription());
        data.add(jsonObject);
    }

    public void save() throws IOException, CoreException {
    	ByteArrayInputStream stream  = new ByteArrayInputStream(data.toJSONString().getBytes());
    	file.setContents(stream, IResource.NONE, null);
    }

    public List<Item> loadItemList() {
        List<Item> items = new ArrayList<Item>();

        Iterator<JSONObject> iterator = data.iterator();

        while (iterator.hasNext()) {
            JSONObject jsonObject = iterator.next();
            Item item = new Item((String) jsonObject.get(nameSave), ItemType.valueOf((String) jsonObject.get(typeSave)),
                    (String) jsonObject.get(descriptionSave));
            items.add(item);
        }

        return items;
    }
}
