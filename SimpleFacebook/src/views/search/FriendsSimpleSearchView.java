package views.search;

import java.sql.SQLException;
import java.util.List;

import controllers.IController;

import models.entities.User;
import models.entities.managers.ItemManager;
import models.entities.managers.UserManager;
import models.item.Item;
import views.SearchView;

public class FriendsSimpleSearchView extends SearchView {

    public FriendsSimpleSearchView(IController c) {
        super(c);
    }

    @Override
    public List<Item> searchItems(User user, String query) {
        try {
            return ItemManager.getInstance().searchItem(query, 20, user);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> searchPeople(User user, String query) {
        try {
            return UserManager.getInstance().searchUser(query, 20, user);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
