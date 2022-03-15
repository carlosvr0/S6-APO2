package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class VallaPublicitariaLIST {
	
	static List<VallaPublicitaria> data;
	static String rutaReport = "files\\VallasPublicitarias.txt";
	static final int DANGER = 200000;

	public VallaPublicitariaLIST() {
		data = new ArrayList<VallaPublicitaria>();
	}
	
	
	public List<VallaPublicitaria> getData() {
		return data;
	}
	
	public void cargarData(String path) throws IOException { //reader
		File file = new File(path); //ruta del archivo
		FileReader fr = new FileReader(file);
		BufferedReader input = new BufferedReader(fr);
		input.readLine();
		
		while (input.ready()) {
			String line = input.readLine();
			String [] data = line.split("\\|");
			
			int ancho = Integer.parseInt(data[0]);
			int largo = Integer.parseInt(data[1]);
			String enUso = data[2];
			String marcaP = data[3];
			
			addVP(ancho, largo, enUso, marcaP);
		}

			input.close();
			fr.close();
		
	}

	public void newVP(String inputString) {
		
		String[] data = inputString.split("\\+\\+");
		
		int newAncho = Integer.parseInt(data[0]);
		int newLargo = Integer.parseInt(data[1]);
		String newEnUso = data[2];
		String newMarcaP = data[3];
		addVP(newAncho, newLargo, newEnUso, newMarcaP);
	}
	
	public void addVP(int ancho, int largo, String enUso, String marcaP) {
		data.add(new VallaPublicitaria(ancho, largo, enUso, marcaP));
	}
	
	
	public String printData()  {	
		String vallaP = "";
		for(int m = 0; m < data.size(); m++) {
			vallaP += data.get(m).getWidth() + "		" + data.get(m).getHeight() + "		" + 
					data.get(m).getInUse() + "		" + data.get(m).getMarcaPromociona() + "\n";
		}
		
		vallaP += "\n";
		vallaP += "TAMAÑO: " + data.size();
		vallaP += "\n";
		return vallaP; 
	}
		
	
	public String showHazardReport() throws IOException {
		String info = "";
		
		info += "=================================\n"; 
		info += "	DANGEROUS BILLBOARD REPORT	\n";
		info += "=================================\n";
		
		info += "The dangerous billboard are: \n";
		
		int contador = 1;
		
		if(data.isEmpty()) {
			info += "La base de datos esta vacía";
		}else {
			for(int m = 0; m < data.size(); m++) {	
				if((data.get(m).getHeight() * data.get(m).getWidth()) >= DANGER){
					info += contador + ". Billboard " + data.get(m).getMarcaPromociona() + " with area " + (data.get(m).getHeight() * data.get(m).getWidth()) + "\n";
					contador++;
				}
			}
		}
		
		return info;
	}
		
	public void makeHazardReport(String report) throws IOException {
		File file = new File(".\\files\\VP_Peligrosas.txt");
		FileWriter fw = new FileWriter(file);
		
		BufferedWriter output = new BufferedWriter(fw);
		output.write(report);
		
		output.newLine();
		output.close();
		fw.close();
	}
	
	public void serialize() throws IOException {
		
		File file = new File(rutaReport);
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
			
		oos.writeObject(getData());
			
		oos.close();
		fos.close();				
	}
	
	public void deserialize() throws IOException, ClassNotFoundException {
		File file = new File(rutaReport);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
			
		@SuppressWarnings("unchecked")
		ArrayList<VallaPublicitaria> objetosVP = (ArrayList<VallaPublicitaria>) ois.readObject();
		data.addAll(objetosVP);
		
		ois.close();
		fis.close();	
	}

	
}
