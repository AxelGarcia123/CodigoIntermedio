package model;

import java.util.ArrayList;
import java.util.List;

public class Posfija {
	public String posfija(String infija) {
		List<String> pila = new ArrayList<String>();
		String cadenaPosfija = "";
		if(infija.charAt(1) == '=')
			infija = infija.substring(2);
		
		for(int i = 0; i < infija.length(); i++) {
			//65 a 90 mayúsculas y 97 a 122
			if((int) infija.charAt(i) >= 65 && (int) infija.charAt(i) <= 90) {
				cadenaPosfija += infija.charAt(i);
			}
			else if((int) infija.charAt(i) >= 97 && (int) infija.charAt(i) <= 122) {
				cadenaPosfija += infija.charAt(i);
			}
			else if(isNumeric(String.valueOf(infija.charAt(i)))) {
				cadenaPosfija += infija.charAt(i);
			}
			else if(isDecimal(String.valueOf(infija.charAt(i)))) {
				cadenaPosfija += infija.charAt(i);
			}
			else {
				if(pila.isEmpty()) {
					pila.add(String.valueOf(infija.charAt(i)));
				}
				else {
					String jerarquia = "";
					switch(infija.charAt(i)) {
						case '+':
							jerarquia = jerarquia(String.valueOf(infija.charAt(i)), pila.get(pila.size() - 1));
							if(jerarquia.equals("Igual jerarquía")) {
								cadenaPosfija += pila.get(pila.size() - 1);
								pila.set(pila.size() - 1, String.valueOf(infija.charAt(i)));
							}
							else if(jerarquia.equals("Menor jerarquía")) {
								pila.add(String.valueOf(infija.charAt(i)));
								for (int j = pila.size() - 1; j > 0; j--) {
									if(pila.get(j - 1).equals("("))
										break;
									cadenaPosfija += pila.get(j - 1);
									pila.remove(j - 1);
								}
							}
							else if(jerarquia.equals("Inicio de paréntesis"))
								pila.add(String.valueOf(infija.charAt(i)));
							
							break;
						case '-':
							jerarquia = jerarquia(String.valueOf(infija.charAt(i)), pila.get(pila.size() - 1));
							if(jerarquia.equals("Igual jerarquía")) {
								cadenaPosfija += pila.get(pila.size() - 1);
								pila.set(pila.size() - 1, String.valueOf(infija.charAt(i)));
							}
							else if(jerarquia.equals("Menor jerarquía")) {
								pila.add(String.valueOf(infija.charAt(i)));
								for (int j = pila.size() - 1; j > 0; j--) {
									if(pila.get(j - 1).equals("("))
										break;
									cadenaPosfija += pila.get(j - 1);
									pila.remove(j - 1);
								}
							}
							else if(jerarquia.equals("Inicio de paréntesis"))
								pila.add(String.valueOf(infija.charAt(i)));
							
							break;
						case '*':
							jerarquia = jerarquia(String.valueOf(infija.charAt(i)), pila.get(pila.size() - 1));
							if(jerarquia.equals("Igual jerarquía")) {
								cadenaPosfija += pila.get(pila.size() - 1);
								pila.set(pila.size() - 1, String.valueOf(infija.charAt(i)));
							}
							else if(jerarquia.equals("Mayor jerarquía")) {
								pila.add(String.valueOf(infija.charAt(i)));
								continue;
							}
							else if(jerarquia.equals("Paréntesis izquierdo")) {
								pila.add(String.valueOf(infija.charAt(i)));
								continue;
							}
							else if(jerarquia.equals("Paréntesis derecho")) {
								int j = pila.size();
								while(true) {
									if(pila.get(j - 1) == "(") {
										pila.remove(j - 1);
										break;
									}
									cadenaPosfija += pila.get(j - 1);
									pila.remove(j - 1);
									j--;
								}
							}
							else if(jerarquia.equals("Inicio de paréntesis"))
								pila.add(String.valueOf(infija.charAt(i)));
							
							break;
						case '/':
							jerarquia = jerarquia(String.valueOf(infija.charAt(i)), pila.get(pila.size() - 1));
							if(jerarquia.equals("Igual jerarquía")) {
								cadenaPosfija += pila.get(pila.size() - 1);
								pila.set(pila.size() - 1, String.valueOf(infija.charAt(i)));
							}
							else if(jerarquia.equals("Mayor jerarquía")) {
								pila.add(String.valueOf(infija.charAt(i)));
								continue;
							}
							break;
						case '(':
							jerarquia = jerarquia(String.valueOf(infija.charAt(i)), pila.get(pila.size() - 1));
							if(jerarquia.equals("Paréntesis izquierdo")) {
								pila.add(String.valueOf(infija.charAt(i)));
								continue;
							}
							break;
						case ')':
							jerarquia = jerarquia(String.valueOf(infija.charAt(i)), pila.get(pila.size() - 1));
							if(jerarquia.equals("Paréntesis derecho")) {
								int j = pila.size();
								while(true) {
									if(pila.get(j - 1).equals("(")) {
										pila.remove(j - 1);
										break;
									}
									cadenaPosfija += pila.get(j - 1);
									pila.remove(j - 1);
									j--;
								}
							}
							else if(jerarquia.equals("Inicio de paréntesis"))
								pila.add(String.valueOf(infija.charAt(i)));
							
							break;
						default:
							System.out.println("Caracter incorrecto");
							break;
					}
				}
			}
		}
		if(pila.size() != 0) {
			for(int i = pila.size(); i > 0; i--) {
				cadenaPosfija += pila.get(i - 1);
				pila.remove(i - 1);
			}
		}
		return cadenaPosfija;
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

	//PARA SABER SI ES DECIMAL
	public boolean isDecimal(String cadena) {
		boolean resultado;
		try {
			Double.parseDouble(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}

		return resultado;
	}
	
	public String jerarquia(String datoAnalizar, String datoPila) {
		if(datoAnalizar.equals("("))
			return "Paréntesis izquierdo";
		
		if(datoAnalizar.equals(")"))
			return "Paréntesis derecho";
		
		if((datoAnalizar.equals("+") || datoAnalizar.equals("-")) && (datoPila.equals("+") || datoPila.equals("-")))
			return "Igual jerarquía";
		
		else if((datoAnalizar.equals("*") || datoAnalizar.equals("/")) && (datoPila.equals("*") || datoPila.equals("/")))
			return "Igual jerarquía";
		
		else if((datoAnalizar.equals("+") || datoAnalizar.equals("-")) && (datoPila.equals("*") || datoPila.equals("/")))
			return "Menor jerarquía";
		
		else if((datoAnalizar.equals("*") || datoAnalizar.equals("/")) && (datoPila.equals("+") || datoPila.equals("-")))
			return "Mayor jerarquía";
		
		else if((datoAnalizar.equals("+") || datoAnalizar.equals("-")) && (datoPila.equals("(")))
			return "Inicio de paréntesis";
		
		else if((datoAnalizar.equals("*") || datoAnalizar.equals("/")) && (datoPila.equals("(")))
			return "Inicio de paréntesis";
			
		return "";
	}
}