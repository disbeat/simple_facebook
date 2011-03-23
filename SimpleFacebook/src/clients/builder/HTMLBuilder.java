package clients.builder;

import java.util.HashMap;

import utils.HTTPUtils;
import views.markup.Button;
import views.markup.Cell;
import views.markup.Document;
import views.markup.Element;
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
import clients.web.InterfaceTranslator;

public class HTMLBuilder extends HierarchicalBuilding<Element> implements InterfaceBuilder {
	HashMap<String, String> cookies = new HashMap<String, String>();
	String redirectPath = null;
	Document page = null;
	InterfaceTranslator visitor = null;

	public HTMLBuilder(InterfaceTranslator visitor) {
		this.visitor = visitor;
	}
	
	@Override
	public void setCookie(String name, String value) {
		cookies.put(name, value);
	}

	@Override
	public void setRedirect(String path) {
		this.redirectPath = path;
	}

	@Override
	public int createPage(String title, Style style) {
		page = new Document(title);
		page.style(style);

		return putObject(page);
	}

	@Override
	public int createButton(int parent, String name, String action, boolean forRoot, Style style) {
		Element ele = new Button(name, action, forRoot).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createExternalFrame(int parent, String action, boolean scrolling, Style style) {
		Element ele = new ExternalFrame(action, scrolling).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createEmbed(int parent, String url, Style style) {
		Element ele = new Embed(url).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createCell(int parent, int row, int col, int span, Style style) {
		Element ele = new Cell(row, col, span).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createFormButton(int parent, String label, Style style) {
		Element ele = new FormButton(label).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createImage(int parent, String url, Style style) {
		Element ele = new Image(url).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createInput(int parent, String name, boolean isPassword, Style style) {
		Element ele = new Input(name, isPassword).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createForm(int parent, String name, String action, Style style) {
		Element ele = new Form(name, action);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createFormHidden(int parent, String name, String value) {
		Element ele = new FormHidden(name, value);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createParagraph(int parent, Style style) {
		Element ele = new Paragraph().style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createTable(int parent, int rows, int cols, Style style) {
		Element ele = new Table(rows, cols).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	@Override
	public int createText(int parent, String text, Style style) {
		Element ele = new TextSpan(text).style(style);
		getObject(parent).add(ele);
		return putObject(ele);
	}

	public BuilderResult getResult() {
	    if (page != null)
	        page.accept(visitor);
		String html = visitor.toHTML();
		return new BuilderResult(html, redirectPath, HTTPUtils.getCookiesString(cookies));
	}
}
