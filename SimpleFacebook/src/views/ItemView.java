package views;

import models.item.Comment;
import models.item.Item;
import models.item.Photo;
import models.item.Text;
import models.item.Video;
import clients.builder.Style;
import clients.builder.Style.Align;
import clients.builder.Style.VAlign;
import controllers.IController;

public class ItemView extends IView {

    public ItemView(IController c) {
        super(c);
    }
    
    void buildComments(int parent, Item i) {
        int t = b.createTable(parent, 1, 6, new Style().fullwidth());

        b.createCell(t, 1, 1, 1, new Style().width(200));

        int cell = b.createCell(t, 1, 2, 5, new Style().vertical().bgcolor(237, 239, 244).padding(4).border(1, 59, 89, 152).valign(VAlign.TOP));
        for (Comment c : i.getComments()) {
            int p = b.createParagraph(cell, new Style().padding(0).margin(0).border(0).maxwidth(250));
            b.createText(p, c.getCreatedBy().getName() + ": ", new Style().font("Tahoma", 12, true).text(59, 89, 152));
            b.createText(p, c.getContent(), new Style().font("Tahoma", 12).text(100, 100, 100).maxwidth(250));
            b.createText(p, "  [" + c.getCreatedOnFormatted() + "]", new Style().font("Tahoma", 10).text(150, 150, 150));
        }

        int form = b.createForm(cell, "commentForm", "/Comment", null);
        b.createInput(form, "comment", false, new Style().width(200).border(1, 59, 89, 152).height(16));
        b.createFormHidden(form, "item_id", "" + i.id);
        b.createText(form, " ", null);
        b.createFormButton(form, "Comment", new Style().font("Tahoma", 12, true).width(100).border(1, 59, 89, 152).text(50,50,50).bgcolor(237, 239, 244).height(21));
    }

    void buildItem(int parent, Item i) {
        int t = b.createTable(parent, 1, 6, new Style().fullwidth());

        int c1 = b.createCell(t, 1, 1, 1, new Style().border(1, 59, 89, 152).bgcolor(237, 239, 244).padding(4).align(Align.CENTER).valign(VAlign.TOP).width(200));
        int p1 = b.createParagraph(c1, null);
        b.createText(p1, i.getCreatedBy().getName(), new Style().text(100, 100, 100).font("Tahoma", 12, true));
        int p2 = b.createParagraph(c1, null);
        b.createText(p2, i.getCreatedOnFormatted(), new Style().text(153, 153, 153).font("Tahoma", 10, true));

        int c2 = b.createCell(t, 1, 2, 5, new Style().border(1, 89, 133, 228).bgcolor(216, 223, 234).padding(4).align(Align.CENTER));
        if (i instanceof Text)
            b.createText(c2, ((Text) i).getContent(), new Style().maxwidth(250));
        else if (i instanceof Video)
            b.createEmbed(c2, ((Video) i).getUrl(), null);
        else if (i instanceof Photo)
            b.createEmbed(c2, ((Photo) i).getUrl(), null);

        buildComments(parent, i);

        int tmp = b.createParagraph(parent, null);
        b.createText(tmp, "", null);
    }


}
