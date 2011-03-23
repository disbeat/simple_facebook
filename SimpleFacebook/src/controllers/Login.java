package controllers;

public class Login extends IController {

    @Override
    public void operation() {
        if (vars.containsKey("userid")) {
            builder.setRedirect("/Home");

        } else {
            new views.LoginView(this).login();
        }

    }

}
