package modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Municipios {

    //atributos
	private Map<String, String> municipio;
	private BufferedReader bf;
	private File file;
	
	
	
	//constructor
	public Municipios(){
		this.municipio= new HashMap<String,String>();
	}
	
	
	//seters and gtters
	public void setMunicipio(String municipio, String cod) {
		this.municipio.put(municipio, cod);
	}
	public Map<String, String> getMunicipio() {
		return this.municipio;
	}
	public File gtFile() {
		return this.file;
	}
	
	
	//metodos
	public String retornoCodigo(String muni) {
		String codigo="";
		
		String ruta3 = "recursos/files/cod_municipio.txt";
        Path rutaCodigoMunicipio=  Paths.get(ruta3);
        
        File file = new File(rutaCodigoMunicipio.toString());
		try {
			   this.bf = new BufferedReader(new FileReader(file));	   
			   String line;
			   while ((line = bf.readLine()) != null) { 
				    String[] parte=line.split(" ",2);
				    this.municipio.put(parte[1], parte[0]);
				} 
			   bf.close();
			 
			   for(String m: this.municipio.keySet()) {
				   if(m.equalsIgnoreCase(muni)) {
					   codigo = this.municipio.get(m);
				   }
			   }  
			}catch(Exception e) {
				System.out.println(e);
			}finally{
				try {
					bf.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		return codigo;
	}
	

	
	
}
