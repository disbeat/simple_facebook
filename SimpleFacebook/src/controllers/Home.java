package controllers;

import java.sql.SQLException;

import models.entities.User;
import models.entities.managers.UserManager;

public class Home extends IController {

    @Override
    public void operation() throws SQLException {
        if (!isLogged()) {
            error("Not logged!");
            return;
        }

        int userID = userID();
        User u = UserManager.getInstance().getUser(userID);

        new views.HomeView(this).index(u);
    }

}
