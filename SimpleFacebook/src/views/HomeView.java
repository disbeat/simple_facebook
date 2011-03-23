package views;

import java.util.HashMap;

import models.entities.Relationship;
import models.entities.User;
import models.entities.managers.UserManager;
import clients.builder.Style;
import clients.builder.Style.Align;
import controllers.IController;

public class HomeView extends IView {
	public HomeView(IController c) {
		super(c);
	}

	public void index(User u) {
		int page = b.createPage("SimpleFacebook", new Style().fullwidth().fullheight());

		int t = b.createTable(page, 1, 5, new Style().fullheight().fullwidth().padding(5));

		int c1 = b.createCell(t, 1, 1, 1, new Style().border(1, 59, 89, 152));
		b.createExternalFrame(c1, "MyInfo", false, new Style().fullheight().fullwidth().border(0));
		int c2 = b.createCell(t, 1, 2, 3, new Style());
		b.createExternalFrame(c2, "Wall?uid=" + u.id, true, new Style().fullheight().fullwidth().border(0));
		int c3 = b.createCell(t, 1, 5, 1, new Style().border(1, 59, 89, 152));
		b.createExternalFrame(c3, "Friends?uid=" + u.id+"&cache="+System.currentTimeMillis(), 
		        true, new Style().fullheight().fullwidth().border(0));
	}

	public void myinfo(User u) {
		int page = b.createPage("My Info", new Style().bgcolor(242, 242, 242).vertical());

		int t = b.createTable(page, 3, 1, new Style().fullwidth());
		int c1 = b.createCell(t, 1, 1, 1, new Style().bgcolor(59, 89, 151).align(Align.CENTER));
		b.createImage(c1, "http://img59.imageshack.us/img59/1262/sfb.png", new Style().width(234).height(86));

		b.createCell(t, 2, 1, 1, null);
		
		int c3 = b.createCell(t, 3, 1, 1, new Style().vertical());

		int p = b.createParagraph(c3, null);
		b.createText(p, "Hello " + u.getAttribute("first_name") + " " + u.getAttribute("last_name"), new Style().font(30));

		p = b.createParagraph(c3, null);
		b.createImage(p, u.getAttribute("photo"), new Style().width(150).height(150));

	}

	public void userinfo(User u) {
		int page = b.createPage("User Info", new Style().bgcolor(242, 242, 242));

		int p = b.createParagraph(page, null);
		b.createText(p, u.getAttribute("first_name") + " " + u.getAttribute("last_name") + " Profile", new Style().font(25));
		b.createImage(page, u.getAttribute("photo"), null);
		
		try {
            Relationship r = UserManager.getInstance().getRelationship(UserManager.getInstance().getUser(controller.userID()), u);
            r.buildInterface(b, page);
        } catch (Exception e) {
            e.printStackTrace();
        }

		HashMap<String, String> attrs = u.getAttributes();
		for (String key : attrs.keySet()) {
			if (key.equals("password") || key.equals("photo") || key.equals("first_name") || key.equals("last_name"))
				continue;

			int line = b.createParagraph(page, null);
			b.createText(line, key + ": " + attrs.get(key), null);
		}

	}

	public void friends(User u) throws Exception {
		int page = b.createPage("Friends", new Style().bgcolor(242, 242, 242).padding(5));

		int p = b.createParagraph(page, null);
		b.createText(p, "Friends List", new Style().font(30));

		for (User f : u.getFriends()) {
			int line = b.createParagraph(page, null);
			b.createImage(line, f.getAttribute("photo"), new Style().width(35).height(35));
			b.createButton(line, f.getName(), "User?uid=" + f.id, true, null);
		}
	}

	public void user(User u) throws Exception {
		int page = b.createPage("Profile", new Style().fullwidth().fullheight());

		int t = b.createTable(page, 1, 5, new Style().fullheight().fullwidth().padding(5));

		int c1 = b.createCell(t, 1, 1, 1, new Style().border(1, 59, 89, 152));
		b.createExternalFrame(c1, "Info?uid=" + u.id, false, new Style().fullheight().fullwidth().border(0));
		int c2 = b.createCell(t, 1, 2, 3, new Style());
		b.createExternalFrame(c2, "Wall?uid=" + u.id, true, new Style().fullheight().fullwidth().border(0));
		int c3 = b.createCell(t, 1, 5, 1, new Style().border(1, 59, 89, 152));
		b.createExternalFrame(c3, "Friends?uid=" + u.id, true, new Style().fullheight().fullwidth().border(0));

	}

}
