package controllers;

import java.sql.SQLException;

import models.entities.User;
import models.entities.managers.UserManager;

public class MyInfo extends IController {

    @Override
    public void operation() throws SQLException {
        if (!isLogged()) {
            error("Not logged!");
            return;
        }

        int id = Integer.parseInt(vars.get("userid"));
        User u = UserManager.getInstance().getUser(id);

        new views.HomeView(this).myinfo(u);

    }

}
