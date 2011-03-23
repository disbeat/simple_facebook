package controllers;

import java.sql.SQLException;

import models.entities.User;
import models.entities.managers.UserManager;

public class Check extends IController {

    @Override
    public void operation() {
        String email = vars.get("email");
        String passwd = vars.get("passwd");
        User u = null;
        try {
            u = UserManager.getInstance().validateCredentials(email, passwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        boolean loginSuccess = (u != null);

        if (loginSuccess) {
            builder.setCookie("userid", Long.toString(u.id));
            builder.setRedirect("/Home");
        } else {
            builder.setRedirect("/Login");
        }

    }

}
