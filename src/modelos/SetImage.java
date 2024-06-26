package modelos;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;

public class SetImage {

	/**
	 * @author Santiago lectura de los estados del tiempo arrojando la imagn correspondiente
	 * @param estado
	 * @return
	 */
	public Image setImage(String estado) {
		Map<String, Image> lista = new HashMap<String, Image>();
		Image image=null;
		
		String ruta3 = "recursos/files/estados_del_cielo";
        Path rutaCodigoMunicipio=  Paths.get(ruta3);
        
		try {		
		BufferedReader br = new BufferedReader(new FileReader(rutaCodigoMunicipio.toString()));
		String line;
		int indice=1;		
		    while((line=br.readLine()) !=null) {
		    	
		    	String imagen = "src/image/"+indice+".png";
		        Path rutaImage =  Paths.get(imagen);
		    	
		       FileInputStream inputstream = new FileInputStream(rutaImage.toString()); 		 
		         lista.put(line, new Image(inputstream));   
		     indice++;
			}
		    
		    for(String st: lista.keySet()) {
		    	if(st.equals(estado)) {
		    		return image= lista.get(st);
		    	}
		    }
		    
		    br.close();	    
			} catch (FileNotFoundException e) {
				System.out.println(e);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println(e);
				e.printStackTrace();
			} finally {
				System.out.println("seguido el estado");
			}
		
	return image;
	}

}
