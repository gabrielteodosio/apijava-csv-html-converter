package html;

public enum HTMLTagDeprecated {
//	DOCTYPE("!DOCTYPE html"),
	HTML("html"),
	HTMLC("/html"),
	HEAD("head"),
	HEADC("/head"),
	TITLE("title"),
	TITLEC("/title"),
	BODY("body"),
	BODYC("/body"),
	P("p"),
	PC("/p"),
	TABLE("table"),
	TABLEC("/table"),
	TR("tr"),
	TRC("/tr"),
	TH("th"),
	THC("/th"),
	TD("td"),
	TDC("/td");
	
	private final String tag;
	
	HTMLTagDeprecated(String tag) {
		this.tag = tag;
	}
	
	public String getTag() {
		return '<' + this.tag + '>';
	}
}
