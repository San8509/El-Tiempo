package controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import application.ElTiempo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import modelos.Dia;
import modelos.LeerURL;
import modelos.Municipios;
import modelos.SetImage;

public class WheatherFXController implements Initializable {

	

    @FXML
    private Label DireccionVelocidadViento_1;

    @FXML
    private Label DireccionVelocidadViento_2;

    @FXML
    private Label DireccionVelocidadViento_3;

    @FXML
    private Label DireccionVelocidadViento_4;

    @FXML
    private Label DireccionVelocidadViento_5;

    @FXML
    private Label DireccionVelocidadViento_6;

    @FXML
    private Label DireccionVelocidadViento_7;
    
    
   

    @FXML
    private Label HumedadMaxDia_1;

    @FXML
    private Label HumedadMaxDia_2;

    @FXML
    private Label HumedadMaxDia_3;

    @FXML
    private Label HumedadMaxDia_4;

    @FXML
    private Label HumedadMaxDia_5;

    @FXML
    private Label HumedadMaxDia_6;

    @FXML
    private Label HumedadMaxDia_7;

    @FXML
    private Label HumedadMinDia_1;

    @FXML
    private Label HumedadMinDia_2;

    @FXML
    private Label HumedadMinDia_3;

    @FXML
    private Label HumedadMinDia_4;

    @FXML
    private Label HumedadMinDia_5;

    @FXML
    private Label HumedadMinDia_6;

    @FXML
    private Label HumedadMinDia_7;
    
    
    

    @FXML
    private Label cieloDia_1;

    @FXML
    private Label cieloDia_2;

    @FXML
    private Label cieloDia_3;

    @FXML
    private Label cieloDia_4;

    @FXML
    private Label cieloDia_5;

    @FXML
    private Label cieloDia_6;

    @FXML
    private Label cieloDia_7;
    
    
    

    @FXML
    private ImageView cielo_1;

    @FXML
    private ImageView cielo_2;

    @FXML
    private ImageView cielo_3;

    @FXML
    private ImageView cielo_4;

    @FXML
    private ImageView cielo_5;

    @FXML
    private ImageView cielo_6;

    @FXML
    private ImageView cielo_7;
    
    
    

    @FXML
    private Label dia_1;

    @FXML
    private Label dia_2;

    @FXML
    private Label dia_3;

    @FXML
    private Label dia_4;

    @FXML
    private Label dia_5;

    @FXML
    private Label dia_6;

    @FXML
    private Label dia_7;
    
    

    
    @FXML
    private Label fecha_1;

    @FXML
    private Label fecha_2;

    @FXML
    private Label fecha_3;

    @FXML
    private Label fecha_4;

    @FXML
    private Label fecha_5;

    @FXML
    private Label fecha_6;

    @FXML
    private Label fecha_7;
    
    

    @FXML
    private Label lluviaDia_1;

    @FXML
    private Label lluviaDia_2;

    @FXML
    private Label lluviaDia_3;

    @FXML
    private Label lluviaDia_4;

    @FXML
    private Label lluviaDia_5;

    @FXML
    private Label lluviaDia_6;

    @FXML
    private Label lluviaDia_7;
    
    

    @FXML
    private Label tempMaxDia_1;

    @FXML
    private Label tempMaxDia_2;

    @FXML
    private Label tempMaxDia_3;

    @FXML
    private Label tempMaxDia_4;

    @FXML
    private Label tempMaxDia_5;

    @FXML
    private Label tempMaxDia_6;

    @FXML
    private Label tempMaxDia_7;

    @FXML
    private Label tempMinDia_1;

    @FXML
    private Label tempMinDia_2;

    @FXML
    private Label tempMinDia_3;

    @FXML
    private Label tempMinDia_4;

    @FXML
    private Label tempMinDia_5;

    @FXML
    private Label tempMinDia_6;

    @FXML
    private Label tempMinDia_7;
    
    
    

    @FXML
    private Label uvaDia_1;

    @FXML
    private Label uvaDia_2;

    @FXML
    private Label uvaDia_3;

    @FXML
    private Label uvaDia_4;

    @FXML
    private Label uvaDia_5;

    @FXML
    private Label uvaDia_6;

    @FXML
    private Label uvaDia_7;
    
    
    @FXML
    private ComboBox<String> Comunidad;
    @FXML
    private ComboBox<String> Provincia;
    @FXML
    private ComboBox<String> Municipio;

    
    @FXML
    private Label precipitacion1;

    @FXML
    private Label precipitacion2;

    @FXML
    private Label precipitacion3;

    @FXML
    private Label precipitacion4;

    @FXML
    private Label precipitacion5;

    @FXML
    private Label precipitacion6;

    @FXML
    private Label precipitacion7;

    
    
    @FXML
    private Label municipio1;

    @FXML
    private Label municpio2;

    @FXML
    private Label provincia;
    
    @FXML
    private Label idioma;
    
    @FXML
    private Label comunidad;

    @FXML
    private TextField EntradaMunicipio;
    
    @FXML
    private Button btnSearch;
    
    @FXML
    private Button english;

    @FXML
    private Button espanyol;
    
    
    @FXML
    void btnEnglish(ActionEvent event) {
    	ElTiempo.setLocale(new Locale("en", "UK"));
        ResourceBundle bundle = ElTiempo.getBundle();
            
        /**
         * cambio de idioma a ingles...
         * @author Santiago 
         * 
         * por algo que se me escapa no logro poner la traduccion de cada dia de la semana en su dia correspondiente
         */
        this.comunidad.setText(bundle.getString("comunidad"));
        this.provincia.setText(bundle.getString("provincia"));
        this.municpio2.setText(bundle.getString("municpio2"));
        this.municipio1.setText(bundle.getString("municipio1"));
        this.idioma.setText(bundle.getString("idioma"));
        this.btnSearch.setText(bundle.getString("btnSearch"));

    	
        this.cieloDia_1.setText(bundle.getString("cieloDia_1"));
        this.cieloDia_2.setText(bundle.getString("cieloDia_2"));
        this.cieloDia_3.setText(bundle.getString("cieloDia_3"));
        this.cieloDia_4.setText(bundle.getString("cieloDia_4"));
        this.cieloDia_5.setText(bundle.getString("cieloDia_5"));
        this.cieloDia_6.setText(bundle.getString("cieloDia_6"));
        this.cieloDia_7.setText(bundle.getString("cieloDia_7"));
        
        this.precipitacion1.setText(bundle.getString("precipitacion1"));
        this.precipitacion2.setText(bundle.getString("precipitacion2"));
        this.precipitacion3.setText(bundle.getString("precipitacion3"));
        this.precipitacion4.setText(bundle.getString("precipitacion4"));
        this.precipitacion5.setText(bundle.getString("precipitacion5"));
        this.precipitacion6.setText(bundle.getString("precipitacion6"));
        this.precipitacion7.setText(bundle.getString("precipitacion7")); 
        
        
        LocalDate hoy = LocalDate.now();
		DateTimeFormatter formateador = DateTimeFormatter.ofPattern("EEEE dd' de 'MMMM' 'yyyy", new Locale("es", "ES"));
	
		espanyol.setText(bundle.getString("button.espanyol").toLowerCase());
        english.setText(bundle.getString("button.english").toLowerCase()); 
    }
    

    @FXML
    void btnEspañol(ActionEvent event) {
    	ElTiempo.setLocale(new Locale("es", "ES"));
        ResourceBundle bundle = ElTiempo.getBundle();
    
        this.cieloDia_1.setText(bundle.getString("cieloDia_1").toLowerCase());
        this.cieloDia_2.setText(bundle.getString("cieloDia_2").toLowerCase());
        this.cieloDia_3.setText(bundle.getString("cieloDia_3").toLowerCase());
        this.cieloDia_4.setText(bundle.getString("cieloDia_4").toLowerCase());
        this.cieloDia_5.setText(bundle.getString("cieloDia_5").toLowerCase());
        this.cieloDia_6.setText(bundle.getString("cieloDia_6").toLowerCase());
        this.cieloDia_7.setText(bundle.getString("cieloDia_7").toLowerCase());
        
        this.comunidad.setText(bundle.getString("comunidad").toLowerCase());
        this.provincia.setText(bundle.getString("provincia").toLowerCase());
        this.municpio2.setText(bundle.getString("municpio2").toLowerCase());
        this.municipio1.setText(bundle.getString("municipio1").toLowerCase());
        this.idioma.setText(bundle.getString("idioma").toLowerCase());
        this.btnSearch.setText(bundle.getString("btnSearch").toLowerCase()); 
        
        this.precipitacion1.setText(bundle.getString("precipitacion1"));
        this.precipitacion2.setText(bundle.getString("precipitacion2"));
        this.precipitacion3.setText(bundle.getString("precipitacion3"));
        this.precipitacion4.setText(bundle.getString("precipitacion4"));
        this.precipitacion5.setText(bundle.getString("precipitacion5"));
        this.precipitacion6.setText(bundle.getString("precipitacion6"));
        this.precipitacion7.setText(bundle.getString("precipitacion7"));
          
        espanyol.setText(bundle.getString("button.espanyol").toLowerCase());
        english.setText(bundle.getString("button.english").toLowerCase());   
    }
    
    
    @FXML
    void BTNbuscarMunicipio(ActionEvent event) {
        String code = EntradaMunicipio.getText();  
		try {
			Municipios municipio = new Municipios();
			LeerURL info = new LeerURL(); 
			info.leerDatos(municipio.retornoCodigo(code));
			Dia dia=info.getDia();
			
			listarDias(dia.getFecha());
			listarLluvia(dia.getPrecipitacion());
			listarCielo(dia.getEstado_cielo());
			listarTemperatura(dia.getTemperatura());
			listarHumedad(dia.getHumedad());
			listarViento(dia.getViento());
			listarUVA(dia.getRayos_uva());      
		} catch (Exception e) {
			System.out.println(e);
		}
    }

    @FXML
    void selectorComunidad(ActionEvent event) {
    	 String comunidad = Comunidad.getSelectionModel().getSelectedItem().toString();
    }
    @FXML
    void selectorMunicipio(ActionEvent event) {
    	String buscar = Municipio.getSelectionModel().getSelectedItem().toString();
        EntradaMunicipio.setText(buscar);
    }
    @FXML
    void selectorProvincia(ActionEvent event) {
    	 String provincia = Provincia.getSelectionModel().getSelectedItem().toString();
    }
    
           
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			/*SELECTOR DE COMUNIDADES*/
			String ruta = "recursos/files/Comunidades";
			Path rutaComunidades =  Paths.get(ruta);
	     
	        ObservableList<String> listComunidades = FXCollections.observableArrayList();
	        try (BufferedReader reader = new BufferedReader(new FileReader(rutaComunidades.toString()))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	listComunidades.add(line);
	            } 
	            Comunidad.setItems(listComunidades);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
			/*SELECTOR DE PROVINCIAS*/
	        String ruta1 = "recursos/files/provincias";
            Path rutaProvincias =  Paths.get(ruta1);
	        
	        ObservableList<String> listProvincias = FXCollections.observableArrayList();
	        try (BufferedReader reader = new BufferedReader(new FileReader(rutaProvincias.toString()))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	listProvincias.add(line);
	            } 
	            Provincia.setItems(listProvincias);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
	        /*SELECTOR DE MUNICIPIOS*/
	        ObservableList<String> listMunicipios = FXCollections.observableArrayList();
	        try{
	        	String ruta3 = "recursos/files/cod_municipio.txt";
	            Path rutaMunicipios=  Paths.get(ruta3); // Obtiene la ruta relativa
	        	BufferedReader reader = new BufferedReader(new FileReader(rutaMunicipios.toString()));
	        	
	            String line;
	            while ((line = reader.readLine()) != null) {
	            	String[] parte = line.split(" ",2);
	            	listMunicipios.add(parte[1]);
	            } 
	            Municipio.setItems(listMunicipios);
	        } catch (IOException e) {
	            System.out.println(e);
	        }
	        
				
		}
		
		public void listarUVA(List<String> uva) {
			//UVA
			   for(int i=0; i<uva.size(); i++) {
				   if(i==0) {
						  this.uvaDia_1.setText(uva.get(i));
					   } else if(i==1) {
						   this.uvaDia_2.setText(uva.get(i));
					   } else if(i==2) {
						   this.uvaDia_3.setText(uva.get(i));
					   } else if(i==3) {
						   this.uvaDia_3.setText(uva.get(i));
					   } else if(i==4) {
						   this.uvaDia_4.setText(uva.get(i));
					   } else if(i==5) {
						   this.uvaDia_6.setText(uva.get(i));
					   } else if(i==6) {
						   this.uvaDia_7.setText(uva.get(i));
					   } 
			   }
		}
		
		public void listarViento(List<String> viento) {
			//VIENTO
			   for(int i=0; i<viento.size(); i++) {
				   
				   if(i==0) {
						  this.DireccionVelocidadViento_1.setText(viento.get(i)+"km/h");
					   } else if(i==1) {
						   this.DireccionVelocidadViento_2.setText(viento.get(i)+"km/h");
					   } else if(i==2) {
						   this.DireccionVelocidadViento_3.setText(viento.get(i)+"km/h");
					   } else if(i==3) {
						   this.DireccionVelocidadViento_4.setText(viento.get(i)+"km/h");
					   } else if(i==4) {
						   this.DireccionVelocidadViento_5.setText(viento.get(i)+"km/h");
					   } else if(i==5) {
						   this.DireccionVelocidadViento_6.setText(viento.get(i)+"km/h");
					   } else if(i==6) {
						   this.DireccionVelocidadViento_7.setText(viento.get(i)+"km/h");
					   } 
			   }
			    
		}
		
		public void listarHumedad(List<String> humedad) {
			//HUMEDAD
			   for(int i=0; i<humedad.size(); i++) {
				   String st = humedad.get(i);
				   String[] partes = st.split(" ", 2);
				   
				   if(i==0) {
						  this.HumedadMaxDia_1.setText(partes[0]+"%");
						  this.HumedadMinDia_1.setText(partes[1]+"%");
					   } else if(i==1) {
							  this.HumedadMaxDia_2.setText(partes[0]+"%");
							  this.HumedadMinDia_2.setText(partes[1]+"%");
					   } else if(i==2) {
							  this.HumedadMaxDia_3.setText(partes[0]+"%");
							  this.HumedadMinDia_3.setText(partes[1]+"%");
					   } else if(i==3) {
							  this.HumedadMaxDia_4.setText(partes[0]+"%");
							  this.HumedadMinDia_4.setText(partes[1]+"%");
					   } else if(i==4) {
							  this.HumedadMaxDia_5.setText(partes[0]+"%");
							  this.HumedadMinDia_5.setText(partes[1]+"%");
					   } else if(i==5) {
							  this.HumedadMaxDia_6.setText(partes[0]+"%");
							  this.HumedadMinDia_6.setText(partes[1]+"%");
					   } else if(i==6) {
							  this.HumedadMaxDia_7.setText(partes[0]+"%");
							  this.HumedadMinDia_7.setText(partes[1]+"%");
					   } 
			   }
			   
		}
		
		public void listarTemperatura(List<String> temperatura) {
			 //TEMPERATURA
			   for(int i=0; i<temperatura.size(); i++) {
				   String st = temperatura.get(i);
				   String[] partes = st.split(" ", 2);
				   
				   if(i==0) {
						  this.tempMaxDia_1.setText(partes[0]+"°");
						  this.tempMinDia_1.setText(partes[1]+"°");
					   } else if(i==1) {
							  this.tempMaxDia_2.setText(partes[0]+"°");
							  this.tempMinDia_2.setText(partes[1]+"°");
					   } else if(i==2) {
							  this.tempMaxDia_3.setText(partes[0]+"°");
							  this.tempMinDia_3.setText(partes[1]+"°");
					   } else if(i==3) {
							  this.tempMaxDia_4.setText(partes[0]+"°");
							  this.tempMinDia_4.setText(partes[1]+"°");
					   } else if(i==4) {
							  this.tempMaxDia_5.setText(partes[0]+"°");
							  this.tempMinDia_5.setText(partes[1]+"°");
					   } else if(i==5) {
							  this.tempMaxDia_6.setText(partes[0]+"°");
							  this.tempMinDia_6.setText(partes[1]+"°");
					   } else if(i==6) {
							  this.tempMaxDia_7.setText(partes[0]+"°");
							  this.tempMinDia_7.setText(partes[1]+"°");
					   }
				   
			   }
				
		}
	
		public void listarCielo(List<String> cielo) {
			//ESTADO DEL CIELO	
			
			   for(int i=0; i<cielo.size(); i++) {
				   String st = cielo.get(i);
				   String[] partes = st.split(" ", 2);
				   SetImage img = new SetImage();
				   
				   if(i==0) {
					  this.cielo_1.setImage(img.setImage(partes[1]));
				   } else if(i==1) {
					   this.cielo_2.setImage(img.setImage(partes[1]));
				   } else if(i==2) {
					   this.cielo_3.setImage(img.setImage(partes[1]));
				   } else if(i==3) {
					   this.cielo_4.setImage(img.setImage(partes[1]));
				   } else if(i==4) {
					   this.cielo_5.setImage(img.setImage(partes[1]));
				   } else if(i==5) {
					   this.cielo_6.setImage(img.setImage(partes[1]));
				   } else if(i==6) {
					   this.cielo_7.setImage(img.setImage(partes[1]));
				   }
			   }
		}
		
		public void listarDias(List<String> fecha) {
			
			 //FECHA	
			   for(int i=0; i<fecha.size(); i++){
				   String st = fecha.get(i);
				   String[] partes = st.split(" ", 2);
				   
				   if(i==0) {
					  this.dia_1.setText(partes[0]);
					  this.fecha_1.setText(partes[1]);
				   } else if(i==1) {
						  this.dia_2.setText(partes[0]);
						  this.fecha_2.setText(partes[1]);
				   } else if(i==2) {
						  this.dia_3.setText(partes[0]);
						  this.fecha_3.setText(partes[1]);
				   } else if(i==3) {
						  this.dia_4.setText(partes[0]);
						  this.fecha_4.setText(partes[1]);
				   } else if(i==4) {
						  this.dia_5.setText(partes[0]);
						  this.fecha_5.setText(partes[1]);
				   } else if(i==5) {
						  this.dia_6.setText(partes[0]);
						  this.fecha_6.setText(partes[1]);
				   } else if(i==6) {
						  this.dia_7.setText(partes[0]);
						  this.fecha_7.setText(partes[1]);
				   }
			   }
			
			
		}
		
		public void listarLluvia(List<String> lluvia) {
			   //LLUVIA
			   for(int i=0; i<lluvia.size(); i++) {
				   String st = lluvia.get(i);
				   String[] partes = st.split(" ", 2);
				   
				   if(i==0) {
					  this.lluviaDia_1.setText(partes[1]+"%");
				   } else if(i==1) {
					   this.lluviaDia_2.setText(partes[1]+"%");
				   } else if(i==2) {
					   this.lluviaDia_3.setText(partes[1]+"%");
				   } else if(i==3) {
					   this.lluviaDia_4.setText(partes[1]+"%");
				   } else if(i==4) {
					   this.lluviaDia_5.setText(partes[1]+"%");
				   } else if(i==5) {
					   this.lluviaDia_6.setText(partes[1]+"%");
				   } else if(i==6) {
					   this.lluviaDia_7.setText(partes[1]+"%");
				   }
			   }
		}

}



