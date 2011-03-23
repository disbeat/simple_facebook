package views;

import clients.builder.Style;
import clients.builder.Style.Align;
import controllers.IController;

public class LoginView extends IView {
	public LoginView(IController c) {
		super(c);
	}

	public void login() {
		int page = b.createPage("SimpleFacebook - Login", new Style());

		int form = b.createForm(page, "login", "/Check", new Style().center());

		int t = b.createTable(form, 6, 1, new Style().width(400).border(1, 200, 200, 200));

		int c1 = b.createCell(t, 1, 1, 1, new Style().bgcolor(59, 89, 151));
		b.createImage(c1, "http://img59.imageshack.us/img59/1262/sfb.png", new Style().width(234).height(86));

		int c2 = b.createCell(t, 2, 1, 1, new Style().bgcolor(59, 89, 151).align(Align.CENTER).height(50));
		b.createText(c2, "Login Form", new Style().font(30).text(255, 255, 255));

		int c3 = b.createCell(t, 3, 1, 1, new Style().align(Align.CENTER));
		int p1 = b.createParagraph(c3, null);
		b.createText(p1, "Login: ", null);
		b.createInput(p1, "email", false, null);

		int c4 = b.createCell(t, 4, 1, 1, new Style().align(Align.CENTER));
		int p2 = b.createParagraph(c4, null);
		b.createText(p2, "Password: ", null);
		b.createInput(p2, "passwd", true, null);

		int c5 = b.createCell(t, 5, 1, 1, new Style().align(Align.CENTER));
		b.createFormButton(c5, "Login", new Style().width(80).font("Verdana", 14, true));

		int c6 = b.createCell(t, 6, 1, 1, new Style().align(Align.CENTER));
		b.createButton(c6, "Create new user", "/Register", true, new Style());

	}
}
