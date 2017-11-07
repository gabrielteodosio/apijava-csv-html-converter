package html;

public class HTMLTag {
	
	public static String oTag(String tag) {
		return (tag.equalsIgnoreCase("doctype") ? "<!DOCTYPE html>" : '<' + tag + '>');
	}
	
	public static String openTag(String tag, String id) {
		return '<' + tag + " id=\"" + id + "\">";
	}
	
	public static String openTag(String tag, String id, String... classes) {
		String cls = "\"";
		for(int i = 0; i < classes.length; i++) {
			if(i == classes.length - 1)
				cls += classes[i] + '\"';
			else
				cls += classes[i] + ' ';
		}
		
		return '<' + tag + " id=\"" + id + "\" class=\"" + cls + "\">";
	}
	
	public static String cTag(String tag) {
		return "</" + tag + '>';
	}
}
