package html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import entidades.Produto;

@SuppressWarnings("all")
public class HTMLUtils {
	
	private static File htmlFile;
	
	private static void createFile() {
		File user = new File(System.getProperty("user.home"));
		String os = System.getProperty("os.name");
		
		if(os.equals("Mac OS X") || os.equals("Linux")) {
			htmlFile = new File(user, "/Desktop/table.html");
		} else if(os.equals("Windows 10") || os.equals("Windows 7")) {
			htmlFile = new File(user, "\\Desktop\\table.html");
		}
		
		if(!htmlFile.exists()) {
			try {
				htmlFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void writeListInHtml(ArrayList<Produto> estoque, String[] headers) throws IOException {
		createFile();
		PrintWriter pw = new PrintWriter(htmlFile);
		String pageName = "Tabela sorteada";
		
		pw.println(HTMLTag.oTag("doctype"));
		pw.println(HTMLTag.openTag("html", "lang=\"pt-BR\""));
			pw.println(HTMLTag.oTag("head"));
				pw.print(HTMLTag.oTag("title"));
				pw.print(pageName);
				pw.println(HTMLTag.cTag("title"));
			pw.println(HTMLTag.cTag("head"));
			pw.println(HTMLTag.oTag("body"));
				pw.println(HTMLTag.oTag("table"));
					pw.println(HTMLTag.oTag("tr"));
					for(String string : headers) {
						pw.print(HTMLTag.oTag("th"));
						pw.print(string);
						pw.println(HTMLTag.cTag("th"));
					}
					pw.println(HTMLTag.cTag("tr"));
					
					for(Produto produto : estoque) {
						pw.println(HTMLTag.oTag("tr"));
							pw.print(HTMLTag.oTag("td"));
								pw.print(produto.getNome());
							pw.print(HTMLTag.cTag("td"));
							pw.print(HTMLTag.oTag("td"));
								pw.print(produto.getMarca());
							pw.print(HTMLTag.cTag("td"));
							pw.print(HTMLTag.oTag("td"));
								pw.print(produto.getPreco());
							pw.print(HTMLTagDeprecated.TDC.getTag());
							pw.print(HTMLTagDeprecated.TD.getTag());
								pw.print(produto.getEstoque());
							pw.print(HTMLTagDeprecated.TDC.getTag());
						pw.println(HTMLTag.cTag("tr"));
					}
				pw.print(HTMLTagDeprecated.TABLEC.getTag());
			pw.println(HTMLTagDeprecated.BODYC.getTag());
		pw.println(HTMLTagDeprecated.HTMLC.getTag());
		
		pw.flush();
		pw.close();
	}
}
