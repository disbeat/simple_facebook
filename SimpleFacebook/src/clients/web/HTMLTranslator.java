package clients.web;

import java.util.Iterator;

import utils.Utils;
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
import clients.builder.Style;

public class HTMLTranslator extends InterfaceTranslator {

    

	public void translate(Document doc) {
		String style = getStyleString(doc.style());

		append("<?xml version='1.0' encoding='utf-8' ?>");
		append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		append("<html style='height: 100%; width: 100%; margin: 0; padding: 0; border: 0;'>");
		append("<head><title>");
		append(doc.getTitle());
		append("</title></head><body style='" + style + "'>");

		for (Element ele : doc.getElements())
			ele.accept(this);

		append("</body></html>");
	}

	public void translate(Input input) {
		String style = getStyleString(input.style());
		append("<input style='" + style + "' name='" + input.getName() + "' " + ((input.isPasswordInput()) ? "type=password " : "") + "/>");
	}

	public void translate(Button button) {
		String style = getStyleString(button.style());
		append("<a style='" + style + "' " + ((button.isForRoot()) ? " target='_parent' " : "") + " href='" + button.getAction() + "'>" + button.getName() + "</a>");
	}

	public void translate(FormButton button) {
		String style = getStyleString(button.style());
		append("<input style='" + style + "' type='submit' value='" + button.getText() + "' />");
	}

	public void translate(Form form) {
		append("<form target='_parent' name='" + form.getName() + "' action='" + form.getAction() + "'>");

		for (Element ele : form.getElements())
			ele.accept(this);

		append("</form>");
	}

	public void translate(Paragraph paragraph) {
		String style = getStyleString(paragraph.style());

		append("<p style='" + style + "'>");

		for (Element ele : paragraph.getElements())
			ele.accept(this);

		append("</p>");
	}

	public void translate(Image image) {

		String style = getStyleString(image.style());
		append("<img style='" + style + "' src='" + image.getUrl() + "' />");

	}

	public String getStyleString(Style style) {
		if (style == null)
			return "";

		StringBuffer s = new StringBuffer();
		if (style.border != -1)
			s.append(String.format("border: solid %dpx #%s; ", style.border, Utils.color2Hex(style.borderColor)));
		if (style.margin != -1)
			s.append(String.format("margin: %dpx; ", style.margin));
		if (style.padding != -1)
			s.append(String.format("padding: %dpx; ", style.padding));
		if (style.align != null)
			s.append(String.format("text-align: %s; ", style.align.name()));
		if (style.valign != null)
			s.append(String.format("vertical-align: %s; ", style.valign.name()));
		if (style.textColor != null)
			s.append(String.format("color: #%s; ", Utils.color2Hex(style.textColor)));
		if (style.bgColor != null)
			s.append(String.format("background-color: #%s; ", Utils.color2Hex(style.bgColor)));

		s.append(String.format("font-family: %s; font-size: %dpx; font-weight: %s; ", style.fontName, style.fontSize, (style.fontBold) ? "bold" : "none"));

		if (style.width != -1)
			s.append(String.format("width: %s; ", (style.width == Integer.MAX_VALUE) ? ("100%") : (style.width + "px")));
		if (style.height != -1)
			s.append(String.format("height: %s; ", (style.height == Integer.MAX_VALUE) ? ("100%") : (style.height + "px")));

		return s.toString();
	}

	public void translate(ExternalFrame frame) {

		String style = getStyleString(frame.style());
		append("<iframe scrolling='" + (frame.getScrolling() ? "yes" : "no") + "' style='" + style + "' src=\"" + frame.getAction() + "\">iFrame not supported!</iframe>");

	}

	public void translate(TextSpan span) {

		String style = getStyleString(span.style());
		append("<span style='" + style + "'>" + span.getText() + "</span>");

	}

	public void translate(Embed embed) {
		append("<object width='500' height='350'><param name='movie' value='" + embed.getSrc()
				+ "'></param><param name='allowFullScreen' value='true'></param><param name='allowscriptaccess' value='always'></param><embed src='" + embed.getSrc()
				+ "' type='application/x-shockwave-flash' allowscriptaccess='always' allowfullscreen='true' width='500' height='350'></embed></object>");
	}

	public void translate(Table table) {
		Iterator<Element> it = table.getElements().iterator();

		append("<table style='" + getStyleString(table.style()) + "'>");
		for (int row = 0; row < table.getRows(); row++) {
			append("<tr>");
			for (int col = 0; col < table.getCols(); col++) {

				Cell cell = new Cell(row, col, 1);
				if (it.hasNext())
					cell = (Cell) it.next();

				String style = getStyleString(cell.style());
				float percent = (1.0f / table.getCols()) * cell.span * 100.0f;
				append("<td cellpadding='0' style='" + style + "' width='" + percent + "%' colspan='" + cell.span + "'>");

				cell.accept(this);

				append("</td>");

				col += cell.span - 1;
			}
			append("</tr>");
		}
		append("</table>");
	}

	public void translate(FormHidden hidden) {
		append("<input type='hidden' name='" + hidden.getName() + "' value='" + hidden.getValue() + "'>");
	}

	public void translate(Cell cell) {
		for (Element ele : cell.getElements())
			ele.accept(this);
	}
}
