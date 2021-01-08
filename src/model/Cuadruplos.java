package model;

import java.util.ArrayList;
import java.util.List;

public class Cuadruplos {
	private List<String> cuadruplos;

	public List<String> cuadruplos(String cadena) {
		List<String> signos = new ArrayList<String>();
		cuadruplos = new ArrayList<String>();
		String subcadenaAux = "";
		String asignacion = "";
		int count = 0;
		if(cadena.charAt(1) == '=') {
			asignacion = String.valueOf(cadena.charAt(0));
			cadena = cadena.substring(2);
		}
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
				}
			}
			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("*") || signos.get(i).equals("/")) {
					int posicion = subcadena.indexOf(signos.get(i));
					count++;
					if(isNumeric(String.valueOf(subcadena.charAt(posicion - 1))) && String.valueOf(subcadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.substring(posicion - 2, posicion) + ","+ subcadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 2) + "t" + count + subcadena.substring(posicion + 2);
					}
					else if(isNumeric(String.valueOf(subcadena.charAt(posicion - 1)))) {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.substring(posicion - 2, posicion) + ","+ subcadena.charAt(posicion + 1) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 2) + "t" + count + subcadena.substring(posicion + 2);
					}
					else if(String.valueOf(subcadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.charAt(posicion - 1) + ","+ subcadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 1) + "t" + count + subcadena.substring(posicion + 3);
					}
					else {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.charAt(posicion - 1) + ","+ subcadena.charAt(posicion + 1) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 1) + "t" + count + subcadena.substring(posicion + 2);
					}
				}
			}

			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("+") || signos.get(i).equals("-")) {
					int posicion = subcadena.indexOf(signos.get(i));
					count++;
					if(isNumeric(String.valueOf(subcadena.charAt(posicion - 1))) && String.valueOf(subcadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.substring(posicion - 2, posicion) + ","+ subcadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 2) + "t" + count + subcadena.substring(posicion + 2);
					}
					else if(isNumeric(String.valueOf(subcadena.charAt(posicion - 1)))) {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.substring(posicion - 2, posicion) + ","+ subcadena.charAt(posicion + 1) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 2) + "t" + count + subcadena.substring(posicion + 2);
					}
					else if(String.valueOf(subcadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.charAt(posicion - 1) + ","+ subcadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 1) + "t" + count + subcadena.substring(posicion + 3);
					}
					else {
						cuadruplos.add("("+ subcadena.charAt(posicion) + ","+ subcadena.charAt(posicion - 1) + ","+ subcadena.charAt(posicion + 1) + "," + "t" + count + ")");
						subcadena = subcadena.substring(0, posicion - 1) + "t" + count + subcadena.substring(posicion + 2);
					}
				}
			}
			//SIGUIENTE PARTE
			signos.clear();
			cadena = cadena.replace(subcadenaAux, "t" + count);

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
				}
			}

			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("*") || signos.get(i).equals("/")) {
					int posicion = cadena.indexOf(signos.get(i));
					count++;
					if(isNumeric(String.valueOf(cadena.charAt(posicion - 1))) && String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(isNumeric(String.valueOf(cadena.charAt(posicion - 1)))) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 3);
					}
					else {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 2);
					}
				}
			}

			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("+") || signos.get(i).equals("-")) {
					int posicion = cadena.indexOf(signos.get(i));
					count++;
					if(isNumeric(String.valueOf(cadena.charAt(posicion - 1))) && String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(isNumeric(String.valueOf(cadena.charAt(posicion - 1)))) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 3);
					}
					else {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 2);
					}
				}
			}
			if(!asignacion.isEmpty())
				cuadruplos.set(cuadruplos.size() - 1, cuadruplos.get(cuadruplos.size() - 1).replace("t"+ count, asignacion));
			return cuadruplos;
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
				}
			}

			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("*") || signos.get(i).equals("/")) {
					int posicion = cadena.indexOf(signos.get(i));
					count++;
					if(isNumeric(String.valueOf(cadena.charAt(posicion - 1))) && String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(isNumeric(String.valueOf(cadena.charAt(posicion - 1)))) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 3);
					}
					else {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 2);
					}
				}
			}

			for(int i = 0; i < signos.size(); i++) {
				if(signos.get(i).equals("+") || signos.get(i).equals("-")) {
					int posicion = cadena.indexOf(signos.get(i));
					count++;
					if(isNumeric(String.valueOf(cadena.charAt(posicion - 1))) && String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(isNumeric(String.valueOf(cadena.charAt(posicion - 1)))) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.substring(posicion - 2, posicion) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 2) + "t" + count + cadena.substring(posicion + 2);
					}
					else if(String.valueOf(cadena.charAt(posicion + 1)).equals("t")) {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.substring(posicion + 1, posicion + 3) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 3);
					}
					else {
						cuadruplos.add("("+ cadena.charAt(posicion) + ","+ cadena.charAt(posicion - 1) + ","+ cadena.charAt(posicion + 1) + "," + "t" + count + ")");
						cadena = cadena.substring(0, posicion - 1) + "t" + count + cadena.substring(posicion + 2);
					}
				}
			}
			if(!asignacion.isEmpty())
				cuadruplos.set(cuadruplos.size() - 1, cuadruplos.get(cuadruplos.size() - 1).replace("t"+ count, asignacion));
			return cuadruplos;
		}
	}
	
	public List<String> getCuadruplos() {
		return cuadruplos;
	}
	
	public boolean isNumeric(String cadena) {
		boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}
}
