package controllers;

import java.sql.SQLException;

import models.entities.User;
import models.entities.managers.ItemManager;
import models.entities.managers.UserManager;
import models.item.Item;

public class Comment extends IController {

    @Override
    public void operation() {
        
        if (!isLogged()) {
            error("Not logged!");
        } else {

            Integer item_id = Integer.parseInt(vars.get("item_id"));
            String comment = vars.get("comment");

            User creator;
            try {
                creator = UserManager.getInstance().getUser(userID());
                Item item = ItemManager.getInstance().getItem(item_id);
    
                models.item.Comment c = new models.item.Comment(-1);
                c.setContent(comment);
                c.setCreatedBy(creator);
                c.setRelatedTo(item);
    
                item.addComment(comment, creator);
            
            } catch (SQLException e) {
                e.printStackTrace();
            }


            builder.setRedirect("/");
        }
    }

}
