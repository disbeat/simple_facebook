package controllers;

public class Register extends IController {

    @Override
    public void operation() {
        if (vars.containsKey("userid")) {
            builder.setRedirect("/Home");

        } else {
            new views.RegisterView(this).register();
        }

    }

}
