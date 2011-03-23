package clients.builder;

import java.util.HashMap;

public class HierarchicalBuilding<T> {
	private HashMap<Integer, T> keys = new HashMap<Integer, T>();
	private int keyCurrID = 0;
	
	protected synchronized int putObject(T obj) {
		int id = keyCurrID++;
		keys.put(id, obj);
		return id;
	}
	
	protected T getObject(int id) {
		return keys.get(id);
	}
	
}
