package models.entities;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import models.entities.managers.UserManager;
import models.item.Item;

public class User{
    
    public int id;
    private boolean loaded = false;
    
    private HashMap<String, String> attributes = new HashMap<String, String>();
    private List <User> friends = null;
    
    private HashMap<Integer, User> ignoredUsers = new HashMap<Integer, User>();
    private HashMap<Integer, Item> ignoredItems = new HashMap<Integer, Item>();
    
    
    public User(int id) {
        this.id = id;
    }
    
    public String getName() {
    	return getAttribute("first_name") + " " + getAttribute("last_name");
    }
    
    public void putAttribute(String key, String value) {
        attributes.put(key, value);
    }
    
    public String getAttribute(String key) {
        if (!loaded) 
        	try {
        		UserManager.getInstance().loadUser(this);
        	} catch(Exception e) { e.printStackTrace(); }
        return attributes.get(key);
    }
    
    public HashMap<String, String> getAttributes() {
        return attributes;
    }
    
    @Override
    public boolean equals(Object user) {
        return this.id == ((User)user).id;
    }
    
    
    public List<User> getFriends() throws SQLException {
        if (friends == null)
            friends = UserManager.getInstance().getFriends(id);
        return friends;
    }
    
    
    public boolean addFriend(User friend) throws SQLException{
        if (friend.id == id)
            return false;
        
        if (friends == null)
            friends = UserManager.getInstance().getFriends(id);
        
        
        boolean success = ! hasFriend(friend);

        if ( success ) {
            for (int i = 0; i < friends.size(); i++)
                if (friends.get(i).getName().compareTo(getName()) > 0) {
                    friends.add(i,friend);
                    break;
                }
        }
        
        return success;    
    }
    
    public boolean removeFriend(User friend) throws SQLException, ClassNotFoundException {
        if (friends == null) {
            friends = UserManager.getInstance().getFriends(id);
            loaded = true;
        }
        
        return friends.remove(friend);
    }
    
    public boolean hasFriend(User friend) throws SQLException {
        if (friends == null)
            friends = UserManager.getInstance().getFriends(id);
        
        for ( User f : friends )
            if ( f.equals(friend) )
                return true;
        return false;
    }
    
    public User getFriend(long id) {
        for ( User f : friends )
            if ( f.id == id )
                return f;
        return null;
    }

    
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("==== USER DESCRIPTION ====\n");
        sb.append("id: ").append(id).append("\n");
        
        for (String key :attributes.keySet() )
            sb.append(key).append(": ").append(attributes.get(key)).append("\n");
        
        sb.append("Friend count: ").append(friends.size()).append("\n");

        return sb.toString();
    }


    public boolean isLoaded() {
        return loaded;
    }


    public void setLoaded(boolean isLoaded) {
        this.loaded = isLoaded;
    }
    
    
    public void addIgnoredUser(User u) {
        ignoredUsers.put(u.id, u);
    }
    
    public void addIgnoredItems(Item i) {
        ignoredItems.put(i.id, i);
    }
    
    public void removeIgnoredUser(User u) {
        ignoredUsers.remove(u.id);
    }
    
    public void removeIgnoredItems(Item i) {
        ignoredItems.remove(i.id);
    }
    
    public boolean isIgnored(Item i) {
        return ignoredItems.containsKey(i.id) || ignoredUsers.containsKey(i.getCreatedBy().id);
    }
    
}
