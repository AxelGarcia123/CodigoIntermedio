package model;

import java.util.ArrayList;
import java.util.List;

public class Triplos {
	
	public String triplos(String cadena) {
		List<String> signos = new ArrayList<String>();
		List<String> triplos = new ArrayList<String>();
		String subcadenaAux = "";
		if(cadena.charAt(1) == '=')
			cadena = cadena.substring(2);
		
		if(cadena.contains("(") && cadena.contains(")")) {
			String subcadena = cadena.substring(cadena.indexOf("("), cadena.indexOf(")") + 1);
			subcadenaAux = subcadena;
			for(int i = 0; i < subcadena.length(); i++) {
				switch(subcadena.charAt(i)) {
					case '+':
						signos.add(String.valueOf(subcadena.charAt(i)));
						break;
					case '-':
						signos.add(String.valueOf(subcadena.charAt(i)));
						break;
					case '*':
						signos.add(String.valueOf(subcadena.charAt(i)));
						break;
					case '/':
						signos.add(String.valueOf(subcadena.charAt(i)));
						break;
					default:
						System.out.println("Signo incorrecto: "+ subcadena.charAt(i));
					break;
				}
			}
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("*") || signos.get(i).equals("/")) {
					int posicion = subcadena.indexOf(signos.get(i));
					triplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.charAt(posicion - 1) + ","+ subcadena.charAt(posicion + 1) + ")");
					System.out.println(subcadena.substring(0, posicion - 1));
					subcadena = subcadena.substring(0, posicion - 1) + " " + subcadena.substring(posicion + 2);
				}
			}
			
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("+") || signos.get(i).equals("-")) {
					int posicion = subcadena.indexOf(signos.get(i));
					triplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.charAt(posicion - 1) + ","+ subcadena.charAt(posicion + 1) + ")");
					System.out.println(subcadena.substring(0, posicion - 1));
					subcadena = subcadena.substring(0, posicion - 1) + " " + subcadena.substring(posicion + 2);
				}
			}
			signos.clear();
			cadena = cadena.replace(subcadenaAux, " ");
			
			for(int i = 0; i < cadena.length(); i++) {
				switch(cadena.charAt(i)) {
					case '+':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					case '-':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					case '*':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					case '/':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					default:
						System.out.println("Signo incorrecto: "+ cadena.charAt(i));
					break;
				}
			}
			
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("*") || signos.get(i).equals("/")) {
					int posicion = cadena.indexOf(signos.get(i));
					triplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + ")");
					System.out.println(cadena.substring(0, posicion - 1));
					cadena = cadena.substring(0, posicion - 1) + " "+ cadena.substring(posicion + 2);
				}
			}
			
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("+") || signos.get(i).equals("-")) {
					int posicion = cadena.indexOf(signos.get(i));
					triplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + ")");
					System.out.println(cadena.substring(0, posicion - 1));
					cadena = cadena.substring(0, posicion - 1) + " "+ cadena.substring(posicion + 2);
				}
			}
			String triplosTerminados = "";
			for (String datos : triplos)
				triplosTerminados += datos + "\n";
			return triplosTerminados;
		}
		else {
			for(int i = 0; i < cadena.length(); i++) {
				switch(cadena.charAt(i)) {
					case '+':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					case '-':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					case '*':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					case '/':
						signos.add(String.valueOf(cadena.charAt(i)));
						break;
					default:
						System.out.println("Signo incorrecto: "+ cadena.charAt(i));
					break;
				}
			}
			
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("*") || signos.get(i).equals("/")) {
					int posicion = cadena.indexOf(signos.get(i));
					triplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + ")");
					System.out.println(cadena.substring(0, posicion - 1));
					cadena = cadena.substring(0, posicion - 1) + " "+ cadena.substring(posicion + 2);
				}
			}
			
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("+") || signos.get(i).equals("-")) {
					int posicion = cadena.indexOf(signos.get(i));
					triplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + ")");
					System.out.println(cadena.substring(0, posicion - 1));
					cadena = cadena.substring(0, posicion - 1) + " "+ cadena.substring(posicion + 2);
				}
			}
			String triplosTerminados = "";
			for (String datos : triplos)
				triplosTerminados += datos + "\n";
			return triplosTerminados;
		}
	}
}