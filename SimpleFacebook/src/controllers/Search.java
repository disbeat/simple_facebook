package controllers;

import java.sql.SQLException;

import models.entities.managers.UserManager;
import views.search.SimpleSearchView;

public class Search extends IController {

    @Override
    public void operation() throws SQLException {
        if (!isLogged()) {
            error("Not logged!");
            return;
        }
        
        String query = vars.get("query");
        
        new SimpleSearchView(this).search(query, UserManager.getInstance().getUser(userID()));
        
        // friends only
        //new FriendsSearchView(this).search(query, UserManager.getInstance().getUser(userID()));

    }

}
