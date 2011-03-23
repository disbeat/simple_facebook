package clients.builder;



public interface InterfaceBuilder {
	void setRedirect(String path);
	void setCookie(String name, String value);
	
	int createPage(String title, Style style);
	int createButton(int parent, String name, String action, boolean forRoot, Style style);
	int createCell(int parent, int row, int col, int span, Style style);
	int createEmbed(int parent, String url, Style style);
	int createExternalFrame(int parent, String action, boolean scrolling, Style style);
	int createForm(int parent, String name, String action, Style style);
	int createFormHidden(int parent, String name, String value);
	int createImage(int parent, String url, Style style);
	int createInput(int parent, String name, boolean isPassword, Style style);
	int createParagraph(int parent, Style style);
	int createText(int parent, String text, Style style);
	int createTable(int parent, int rows, int cols, Style style);
	int createFormButton(int parent, String label, Style style);
	
	BuilderResult getResult();
}
