package views;

import java.util.List;

import models.entities.User;
import models.item.Item;
import clients.builder.Style;
import clients.builder.Style.Align;
import clients.builder.Style.VAlign;
import controllers.IController;

public abstract class SearchView extends IView{

    public SearchView(IController c) {
        super(c);
    }

    public void createSearchForm(int parent) {

        int p = b.createParagraph(parent, null);
        b.createText(p, "Search Users or Items", new Style().font(20));
        
        int f = b.createForm(parent, "search", "/Search", null);

        int t = b.createTable(f, 2, 1, new Style().fullwidth().border(1, 59, 89, 152));

        int c = b.createCell(t, 1, 1, 1, new Style().bgcolor(216, 223, 234).padding(4).align(Align.CENTER));
        b.createInput(c, "query", false, new Style().height(30).fullwidth());

        int c2 = b.createCell(t, 2, 1, 1, new Style().bgcolor(237, 239, 244).padding(4).align(Align.RIGHT));
        b.createFormButton(c2, "Search", new Style().width(120).height(30).font("Verdana", 18, true));

    }

    public void search(String query, User user) {
        int page = b.createPage("Search items or people", new Style());
        
        if (query == null) query = "";
        
        createSearchForm(page);
        
        b.createParagraph(page, new Style());
        
        int t = b.createTable(page, 1, 3, new Style().fullwidth().border(1, 59, 89, 152));

        int c1 = b.createCell(t, 1, 1, 2, new Style().bgcolor(216, 223, 234).padding(30).align(Align.CENTER).valign(VAlign.TOP).vertical());
       

        int c2 = b.createCell(t, 1, 3, 1, new Style().bgcolor(237, 239, 244).padding(30).align(Align.LEFT).valign(VAlign.TOP).vertical());

        
        //search users
        
        b.createText(c1, "Items found:", new Style().font(20));
        b.createParagraph(c1, new Style().height(20));
        List<Item> items = searchItems(user, query);
        
        ItemView itemView = new ItemView(controller);
        
        for (Item item: items)
            itemView.buildItem(c1, item);
        
        
        //search people
        
        b.createText(c2, "People found:", new Style().font(20).align(Align.CENTER));
        b.createParagraph(c2, new Style().height(20));
        List<User> users = searchPeople(user, query);
        
        for (User u: users) {
            int line = b.createParagraph(c2, null);
            b.createImage(line, u.getAttribute("photo"), new Style().width(35).height(35));
            b.createButton(line, u.getName(), "User?uid=" + u.id, true, null);
        }

    }
    
    public abstract List<User> searchPeople(User user, String query);
    
    public abstract List<Item> searchItems(User user, String query);

}
