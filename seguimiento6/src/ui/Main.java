package ui;

import java.io.IOException;
import java.util.Scanner;

import model.VallaPublicitariaLIST;

public class Main {
	 public static Scanner LECTOR  = new Scanner(System.in);; 
	 static VallaPublicitariaLIST vp = new VallaPublicitariaLIST();
	 
	 public static void main(String[] args) throws IOException, ClassNotFoundException {
		 
		 vp.deserialize();
		 
		 System.out.println("***************************");
	     System.out.println("*                         *");
	     System.out.println("*      SEGUIMIENTO 6      *");
	     System.out.println("*                         *");
	     System.out.println("***************************");
	     System.out.println("");
	     
	     String chosenOptionMenu = "";
	     
	     do {
	    	 System.out.println("Chose one of the options");
		     System.out.println("  1) Importar datos CVS");
		     System.out.println("  2) Agregar valla publicictaria");
		     System.out.println("  3) Mostrar valla publicictaria");	
		     System.out.println("  4) Exportar reporte de peligrosidad");
		     System.out.println("  5) EXIT");
		     chosenOptionMenu = LECTOR.nextLine();
		     
		     switch (chosenOptionMenu) {
		     	case "1":
		     		System.out.println("Ingrese la ruta del documento");
		     		String path = LECTOR.nextLine();
		     		vp.cargarData(path);
		     		break;
		     	case "2":
					System.out.println("Escriba los datos (separados por ++)");
					String newVP = LECTOR.nextLine();
					vp.newVP(newVP);
					break;
		     	case "3":
		     		System.out.println(vp.printData()); 
					break;
		     	case "4":
					System.out.println(vp.showHazardReport());
					vp.makeHazardReport(vp.showHazardReport());
					break;
		     	case "5":
					vp.serialize();
					break;
			}
	     }while(!(chosenOptionMenu.equals("5")));
	     
	}
}
