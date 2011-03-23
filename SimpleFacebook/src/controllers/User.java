package controllers;

import models.entities.managers.UserManager;

public class User extends IController {

    @Override
    public void operation() throws Exception {
        if (!isLogged()) {
            error("Not logged!");
            return;
        }

        int id = Integer.parseInt(vars.get("uid"));
        models.entities.User u = UserManager.getInstance().getUser(id);

        new views.HomeView(this).user(u);

    }

}
