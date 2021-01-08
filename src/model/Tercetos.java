package model;

import java.util.ArrayList;
import java.util.List;

public class Tercetos {
	public List<String> tercetos(List<String> cuadruplos) {
		List<String> tercetos = new ArrayList<String>();
		for(int i = 0; i < cuadruplos.size(); i++) {
			String terceto = "";
			String triplo = cuadruplos.get(i);
			int j = triplo.length();
			while(true) {
				if(triplo.charAt(j - 1) == ',') {
					terceto = triplo.substring(j, triplo.length() - 1);
					break;
				}
				j--;
			}
			terceto += " = ";
			int d = triplo.substring(3).indexOf(",") + 3;
			terceto += String.valueOf(triplo.substring(3, triplo.substring(3).indexOf(",") + 3));
			terceto += " "+ String.valueOf(triplo.charAt(1)) +" ";
			j = triplo.substring(3).indexOf(",") + 3;
			while(true) {
				if(triplo.charAt(j) == ',') {
					terceto += triplo.substring(j + 1, triplo.substring(j + 1).indexOf(",") + j + 1);
					break;
				}
				j++;
			}
			tercetos.add(terceto);
		}
		return tercetos;
	}
}