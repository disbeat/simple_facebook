package controllers;

import models.entities.User;
import models.entities.managers.UserManager;

public class Friends extends IController {

    @Override
    public void operation() throws Exception {
        int id = Integer.parseInt(vars.get("uid"));
        if (id == -1) {
            error("Can't find a required parameter.");
            return;
        }

        User u = UserManager.getInstance().getUser(id);

        new views.HomeView(this).friends(u);
    }

}
