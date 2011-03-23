package controllers;

import java.sql.SQLException;
import java.util.List;

import models.entities.User;
import models.entities.managers.ItemManager;
import models.entities.managers.UserManager;
import models.item.Item;
import views.wall.OrderType;

public class Wall extends IController {

    @Override
    public void operation() throws SQLException {
        int id = Integer.parseInt(vars.get("uid"));
        if (id == -1) {
            error("Can't find a required parameter.");
            return;
        }

        OrderType order = null;
        if (!vars.containsKey("order")) {
            order = OrderType.LATEST;
        } else {
            order = Enum.valueOf(OrderType.class, vars.get("order").toUpperCase());
        }

        User u = UserManager.getInstance().getUser(id);

        boolean myWall = (u.id == userID());
        List<Item> items = ItemManager.getInstance().getLastItems(u.id, 100, myWall);
        new views.WallView(this).wall(u.id, myWall, items, order);

    }

}
