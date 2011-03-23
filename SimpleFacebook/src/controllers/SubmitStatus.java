package controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;

import models.entities.User;
import models.entities.managers.ItemManager;
import models.entities.managers.UserManager;
import models.item.Item;
import models.item.Photo;
import models.item.Text;
import models.item.Video;
import external.StatusUpdater;

public class SubmitStatus extends IController {

    @Override
    public void operation() throws SQLException {
        if (!isLogged()) {
            error("Not logged!");
        } else {

            final String status = vars.get("status");
            User creator = UserManager.getInstance().getUser(userID());

            Item i = null;
            if (isURL(status) && status.contains("youtube")) {
                i = new Video(-1, status);
            } else if (isURL(status)) {
                i = new Photo(-1, status);
            } else {
                i = new Text(-1, status);
            }
            i.setCreatedBy(creator);
            ItemManager.getInstance().persistItem(i);

            new StatusUpdater().updateStatus(status);

            builder.setRedirect("/");

        }

    }

    
    public boolean isURL(String text) {
        try {
            new URL(text);
            return true;
        } catch (MalformedURLException e) {
        }
        return false;
    }

}
