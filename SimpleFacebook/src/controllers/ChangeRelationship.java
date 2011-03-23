package controllers;

import models.entities.Relationship;
import models.entities.managers.UserManager;


public class ChangeRelationship extends IController {

    @Override
    public void operation() throws Exception {
        models.entities.User u1 = UserManager.getInstance().getUser( this.userID() );
        models.entities.User u2 = UserManager.getInstance().getUser( Integer.parseInt( vars.get("user") ) );
     
        Relationship r = UserManager.getInstance().getRelationship(u1, u2);
        r.changeState();
        
        builder.setRedirect("/Home");
    }

}
