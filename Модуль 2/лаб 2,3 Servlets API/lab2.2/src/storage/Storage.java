package storage;

import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import data.CarOwner;
import data.Constant;

public class Storage {
    
    private static boolean writeMap(Map<Integer, CarOwner> objects) {
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constant.FileName)))
        {
            oos.writeObject(objects);
            return true;
        }
        catch(Exception ex){
        	return false;
        } 
    }
    
    @SuppressWarnings("unchecked")
	private static Map<Integer, CarOwner> readMap(){
    	Map<Integer, CarOwner> objects=new HashMap<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constant.FileName)))
        {
        	objects=((Map<Integer, CarOwner>)ois.readObject());
        }
        catch(Exception ex){}
        return objects;
    }
    

    public static Collection<CarOwner> readAll() {
    	Map<Integer, CarOwner> objects=readMap();
        return objects.values();
    }

    public static CarOwner readById(Integer id) {
    	Map<Integer, CarOwner> objects=readMap();
        return objects.get(id);
    }

    public static void create(CarOwner object) {
    	Map<Integer, CarOwner> objects=readMap();
        Integer id = 1;
        Set<Integer> ids = objects.keySet();
        if(!ids.isEmpty()) {
            id += Collections.max(ids);
        }
        object.setId(id);
        objects.put(id, object);
        writeMap(objects);
    }

    public static void update(CarOwner object) {
    	Map<Integer, CarOwner> objects=readMap();
        objects.put(object.getId(), object);
        writeMap(objects);
    }

    public static void delete(Integer id) {
    	Map<Integer, CarOwner> objects=readMap();
        objects.remove(id);
        writeMap(objects);
    }
}
