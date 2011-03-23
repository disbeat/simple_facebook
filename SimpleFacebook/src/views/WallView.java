package views;

import java.util.List;

import models.item.Item;
import views.search.SimpleSearchView;
import views.wall.BaseIterator;
import views.wall.OrderStrategy;
import views.wall.OrderType;
import views.wall.WallIterator;
import clients.builder.Style;
import clients.builder.Style.Align;
import controllers.IController;

public class WallView extends IView {
	public WallView(IController c) {
		super(c);
	}

	void buildForm(int parent) {
		int f = b.createForm(parent, "submitStatus", "/SubmitStatus", null);

		int t = b.createTable(f, 2, 1, new Style().fullwidth().border(1, 59, 89, 152));

		int c = b.createCell(t, 1, 1, 1, new Style().bgcolor(216, 223, 234).padding(4).align(Align.CENTER));
		b.createInput(c, "status", false, new Style().height(70).fullwidth());

		int c2 = b.createCell(t, 2, 1, 1, new Style().bgcolor(237, 239, 244).padding(4).align(Align.RIGHT));
		b.createFormButton(c2, "Submit", new Style().width(120).height(30).font("Verdana", 18, true));

		int tmp = b.createParagraph(parent, null);
		b.createText(tmp, "", null);
		
	}

	void buildOrderMenu(int parent, long uid) {
		int p = b.createParagraph(parent, new Style().align(Align.RIGHT));
		b.createText(p, "Order: ", new Style().font(11).text(120, 120, 120));
		b.createButton(p, "Recent", "?uid=" + uid + "&order=latest", false, new Style().font(11).text(60, 60, 60));
		b.createText(p, " ", null);
		b.createButton(p, "Older", "?uid=" + uid + "&order=older", false, new Style().font(11).text(60, 60, 60));
		b.createText(p, " ", null);
		b.createButton(p, "Most Active", "?uid=" + uid + "&order=activity", false, new Style().font(11).text(60, 60, 60));
		b.createText(p, " ", null);
		b.createButton(p, "Type", "?uid=" + uid + "&order=type", false, new Style().font(11).text(60, 60, 60));
	}

	public void wall(long uid, boolean submitForm, List<Item> items, OrderType order) {
		int page = b.createPage("Wall", new Style().maxwidth(400));
		
		
		// template method type of search
		
		//new FriendsSimpleSearchView(controller).createSearchForm(page);
        new SimpleSearchView(controller).createSearchForm(page);

		int p = b.createParagraph(page, null);
		b.createText(p, "Wall", new Style().font(30));

		if (submitForm)
			buildForm(page);

		buildOrderMenu(page, uid);

		// Lets build a list of items based on the requested order
		OrderStrategy strategy = order.getInstance();
		strategy.setItems(items);
		BaseIterator iterator = new WallIterator(strategy);
		
		ItemView itemView = new ItemView(controller);
		
		while (!iterator.done()) {
			Item item = iterator.item();
			itemView.buildItem(page, item);
			iterator.next();
		}

	}
}

