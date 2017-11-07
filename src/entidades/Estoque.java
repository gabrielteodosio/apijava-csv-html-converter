package entidades;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import org.w3c.dom.html.HTMLUListElement;

import html.HTMLUtils;

@SuppressWarnings("all")
public class Estoque {
	private static String[] headers;
	
	public static void main(String[] args) {
		
		File stockFile = null;
		try {
			stockFile = getDesktopDir("estoque.csv");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		ArrayList<Produto> stock = arqToList(stockFile);
		
		sortArrayList(stock);
		
		System.out.println(stock.get(0).getNome() + ", R$ " + stock.get(0).getPreco());
		System.out.println(stock.get(1).getNome() + ", R$ " + stock.get(1).getPreco());
		
		try {
			HTMLUtils.writeListInHtml(stock, headers);
			System.out.println("\nArquivo HTML gerado com sucesso.");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("\nArquivo HTML não foi gerado.");
		}
	}
	
	private static File getDesktopDir(String nomeArquivo) throws Exception {
		File user = new File(System.getProperty("user.home"));
		String os = System.getProperty("os.name");
		
		if(os.equals("Mac OS X") || os.equals("Linux")) {
			return new File(user, "/Desktop/" + nomeArquivo);
		} else if(os.equals("Windows 10") || os.equals("Windows 7")) {
			return new File(user, "\\Desktop\\" + nomeArquivo);
		}

		throw new Exception("Não foi possivel encontrar o arquivo,");
	}
	
	private static ArrayList<Produto> arqToList(File file) {
		ArrayList<Produto> estoque = new ArrayList<>();
		String linhaDosArquivos = new String();
		
		try {
			Scanner leitor = new Scanner(file);
			headers = leitor.nextLine().split(";"); // PARA CASO PRECISE DOS TÓPICOS DE CADA LINHA DO ARQUIVO
			
			while (leitor.hasNext()){
				linhaDosArquivos = leitor.nextLine();
				
				String[] valoresEntreVirgulas = linhaDosArquivos.split(";");
				Produto produto = new Produto(valoresEntreVirgulas[0], valoresEntreVirgulas[1], Double.parseDouble(valoresEntreVirgulas[2]), Integer.parseInt(valoresEntreVirgulas[3]));
				
				estoque.add(produto);
			}
			
			leitor.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
		
		return estoque;
	}
	
	private static void showElements(ArrayList<Produto> estoque) {
		for(Produto produto : estoque) {
			System.out.println(produto);
		}
	}
	
	private static void sortArrayList(ArrayList<Produto> estoque) {
		Collections.sort(estoque, new Comparator() {
			public int compare(Object o1, Object o2) {
                Produto p1 = (Produto) o1;
                Produto p2 = (Produto) o2;
                return p1.getPreco() > p2.getPreco() ? -1 : (p1.getPreco() > p2.getPreco() ? +1 : 0);
            }
		});
	}
	
}
