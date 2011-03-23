package controllers;

import models.entities.managers.UserManager;

public class CheckRegister extends IController {

    @Override
    public void operation() throws Exception {
        models.entities.User u = new models.entities.User(-1);
        
        for (String key : vars.keySet()) {
            u.putAttribute(key, vars.get(key));
        }
        
        UserManager.getInstance().persistUser(u);
        
        builder.setRedirect("/Login");
    }

}
