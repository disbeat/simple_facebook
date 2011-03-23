package views;

import clients.builder.Style;
import controllers.IController;

public class RegisterView extends IView{

    public RegisterView(IController controller) {
        super(controller);
    }
    
    public void createRegisterForm(int parent) {
        int form = b.createForm(parent, "Register", "/CheckRegister", null);
        
        int p = b.createParagraph(form, null);
        b.createText(p, "Email: ", null);
        b.createInput(p, "email", false, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "Password: ", null);
        b.createInput(p, "password", true, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "First name: ", null);
        b.createInput(p, "first_name", false, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "Last name: ", null);
        b.createInput(p, "last_name", false, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "Photo(url): ", null);
        b.createInput(p, "photo", false, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "Birthday: ", null);
        b.createInput(p, "birthday", false, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "Sex: ", null);
        b.createInput(p, "sex", false, null);
        
        p = b.createParagraph(form, null);
        b.createText(p, "Phone: ", null);
        b.createInput(p, "phone", false, null);
        
        b.createFormButton(form, "Register", new Style().width(80).font("Verdana", 14, true));
    }

    public void register() {
        int page = b.createPage("Register", new Style());
        
        createRegisterForm(page);
    }
}
