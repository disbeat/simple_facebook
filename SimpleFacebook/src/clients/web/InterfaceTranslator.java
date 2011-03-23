package clients.web;

import views.markup.Button;
import views.markup.Cell;
import views.markup.Document;
import views.markup.Embed;
import views.markup.ExternalFrame;
import views.markup.Form;
import views.markup.FormButton;
import views.markup.FormHidden;
import views.markup.Image;
import views.markup.Input;
import views.markup.Paragraph;
import views.markup.Table;
import views.markup.TextSpan;

public abstract class InterfaceTranslator {
    
    StringBuffer body = null;
    Document doc = null;

    public InterfaceTranslator() {
        this.body = new StringBuffer(1000);
    }

    public String toHTML() {
        return body.toString();
    }
    
    protected void append(String text) {
        body.append(text);
    }
    
    public abstract void translate(Document doc);
    
    public abstract void translate(Input input);

    public abstract void translate(Button button);
    
    public abstract void translate(FormButton button);
    
    public abstract void translate(Form form);
    
    public abstract void translate(Paragraph paragraph);
    
    public abstract void translate(Image image);
    
    public abstract void translate(ExternalFrame frame);

    public abstract void translate(TextSpan span);
    
    public abstract void translate(Embed embed);
    
    public abstract void translate(Table table);

    public abstract void translate(FormHidden hidden);

    public abstract void translate(Cell cell);

}
