package modelos;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerURL {

	private Dia dia;
	
	
	public LeerURL() {
		this.dia= new Dia();
	}
	public Dia getDia() {
		return this.dia;
	}
	
	
	
public void leerDatos(String codigo) {
		String ruta = "https://www.aemet.es/xml/municipios/localidad_"+codigo+".xml";		
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			URL url = new URL(ruta);
			InputStream stream = url.openStream();
			Document doc = db.parse(stream);
			doc.getDocumentElement().normalize();
			
			
			NodeList listaNodosDias = doc.getElementsByTagName("dia");
			for (int iDias = 0; iDias < listaNodosDias.getLength(); iDias++) {
				Node nodoDia = listaNodosDias.item(iDias);
				
				if(nodoDia.getNodeType() == Node.ELEMENT_NODE) {
					Element elementoDia = (Element) nodoDia;
					String fecha = elementoDia.getAttribute("fecha");
					
					DateTimeFormatter formateador = DateTimeFormatter.ofPattern("EEEE dd' de 'MMMM' 'yyyy", new Locale("es", "ES"));
					LocalDate parseador = LocalDate.parse(fecha);	
					String diaSemana = parseador.format(formateador);
					System.out.println(diaSemana);
					String[] parte = diaSemana.split(" ");
					dia.setFecha(parte[0]+" "+fecha);
				    
					String lluvia=cargarProbabilidadLluvia(elementoDia);
					dia.setPrecipitacion(lluvia);
					
					String cielo=cargarEstadoCielo(elementoDia);
					dia.setEstado_cielo(cielo);
					
					String temperatura=cargarTemperatura(elementoDia);
					dia.setTemperatura(temperatura);
					
					String humedad=cargarHumedad(elementoDia);
					dia.setHumedad(humedad);
					
					String viento=cargarViento(elementoDia);
					dia.setViento(viento);
					
					String uva=cargarUVA(elementoDia);
					dia.setRayos_uva(uva);			
				}
			}
			
		} catch(Exception e) { 
			System.out.println("Error en la lectura de datos");
		}
	
	}
	
	
	public String cargarViento(Element e)  {
		NodeList listaViento = e.getElementsByTagName("viento");
        String cadena="";
		
		for (int viento = 0; viento < listaViento.getLength(); viento++) {
			Node nodoViento = listaViento.item(viento);

			if(nodoViento.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoViento = (Element) nodoViento;
				String periodo=elementoViento.getAttribute("periodo");	
			    String direccion=elementoViento.getElementsByTagName("direccion").item(0).getTextContent();
				String velocidad=elementoViento.getElementsByTagName("velocidad").item(0).getTextContent();
			    System.out.println("Viento: "+periodo+" "+direccion+"-"+velocidad);
			    
			    if(periodo.equals("06-12")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(6, 0);
            	    LocalTime fin = LocalTime.of(12, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 06-12");
            	    	return cadena=periodo+" "+direccion+"-"+velocidad;
            	    }
                } else if(periodo.equals("12-18")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(12, 0);
            	    LocalTime fin = LocalTime.of(18, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 12-18");
            	    	return cadena=periodo+" "+direccion+"-"+velocidad;
            	    }            	    
                } else if(periodo.equals("18-24")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(18, 0);
            	    LocalTime fin = LocalTime.of(23, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 18-24");
            	    	return cadena=periodo+" "+direccion+"-"+velocidad;	
            	    }
                } else if (periodo.isEmpty()) {
                	return cadena="00"+" "+direccion+"-"+velocidad;
                }
			    
                cadena=periodo+" "+direccion+"-"+velocidad;
			}
		}
		return cadena;
	}

	
    public String cargarEstadoCielo(Element e)  {
		NodeList listaCielo = e.getElementsByTagName("estado_cielo");
        String cadena=""; 
		
		for (int iCielo = 0; iCielo < listaCielo.getLength(); iCielo++) {
			Node nodoCielo = listaCielo.item(iCielo);

			if(nodoCielo.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoCielo = (Element) nodoCielo;
				System.out.print("\tEstado del Cielo (" + elementoCielo.getAttribute("periodo") +"): ");
				System.out.println(elementoCielo.getAttribute("descripcion"));

                String periodo=elementoCielo.getAttribute("periodo");
                String descripcion=elementoCielo.getAttribute("descripcion");
                
                if(periodo.equals("06-12")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(6, 0);
            	    LocalTime fin = LocalTime.of(12, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 06-12");
            	    	return cadena=periodo+" "+descripcion;
            	    }
                } else if(periodo.equals("12-18")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(12, 0);
            	    LocalTime fin = LocalTime.of(18, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 12-18");
            	    	return cadena=periodo+" "+descripcion;
            	    }            	    
                } else if(periodo.equals("18-24")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(18, 0);
            	    LocalTime fin = LocalTime.of(23, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 18-24");
            	    	return cadena=periodo+" "+descripcion;	
            	    }
                } else if (periodo.isEmpty()) {
                	return cadena="00"+" "+descripcion;
                }
				cadena=periodo+" "+descripcion;
			} 
		}
		return cadena;
	}
	
	
	public String cargarProbabilidadLluvia(Element e)  {
		NodeList listaLLuvia = e.getElementsByTagName("prob_precipitacion");
        String cadena ="";
		
		for (int iLluvia = 0; iLluvia < listaLLuvia.getLength(); iLluvia++) {
			Node nodoLluvia = listaLLuvia.item(iLluvia);

			if(nodoLluvia.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoLluvia = (Element) nodoLluvia;
				System.out.print("\tProbabilidad precipitación (" + elementoLluvia.getAttribute("periodo") +"): ");
				System.out.println(elementoLluvia.getTextContent());
				
				String periodo=elementoLluvia.getAttribute("periodo");
				String estado=elementoLluvia.getTextContent();
				
				if(periodo.equals("06-12")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(6, 0);
            	    LocalTime fin = LocalTime.of(12, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 06-12");
            	    	return cadena=periodo+" "+estado;
            	    }
                } else if(periodo.equals("12-18")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(12, 0);
            	    LocalTime fin = LocalTime.of(18, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 12-18");
            	    	return cadena=periodo+" "+estado;
            	    }            	    
                } else if(periodo.equals("18-24")) {
                	LocalTime hora = LocalTime.now();
                	LocalTime inicio = LocalTime.of(18, 0);
            	    LocalTime fin = LocalTime.of(23, 0);
            	    
            	    if(hora.isAfter(inicio) && hora.isBefore(fin)) {
            	    	System.out.println("se encuetra en el periodo de 18-24");
            	    	return cadena=periodo+" "+estado;	
            	    }
                } else if (periodo.isEmpty()) {
                	return cadena="00"+" "+estado;
                }
				cadena=periodo+" "+estado;
			
			}
		}
		return cadena;
	}
	
	
	public String cargarTemperatura(Element e) {
		NodeList listaTemperatura = e.getElementsByTagName("temperatura");
		String cadena="";
		
		for (int temperatura = 0; temperatura < listaTemperatura.getLength(); temperatura++) {
			Node nodoTemperatura = listaTemperatura.item(temperatura);

			if(nodoTemperatura.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoTmperatura = (Element) nodoTemperatura;

				System.out.println("temperatura maxima: " + elementoTmperatura.getElementsByTagName("maxima").item(0).getTextContent());
				System.out.println("temperatura minima: " + elementoTmperatura.getElementsByTagName("minima").item(0).getTextContent());

				String periodo=elementoTmperatura.getElementsByTagName("maxima").item(0).getTextContent();
				String estado=elementoTmperatura.getElementsByTagName("minima").item(0).getTextContent();
				cadena=periodo+" "+estado;
			}
		}
	  return cadena; 
	}
	
	
	public String cargarHumedad(Element e) {
		NodeList listaHumedad = e.getElementsByTagName("humedad_relativa");
		String cadena="";
		
		for (int humedad = 0; humedad < listaHumedad.getLength(); humedad++) {
			Node nodoHumedad = listaHumedad.item(humedad);

			if(nodoHumedad.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoHumedad = (Element) nodoHumedad;

				System.out.println("humedad maxima: " + elementoHumedad.getElementsByTagName("maxima").item(0).getTextContent());
				System.out.println("humedad minima: " + elementoHumedad.getElementsByTagName("minima").item(0).getTextContent());

				String periodo=elementoHumedad.getElementsByTagName("maxima").item(0).getTextContent();
				String estado=elementoHumedad.getElementsByTagName("minima").item(0).getTextContent();
			 cadena=periodo+" "+estado;
			}
		}
		return cadena;
	}
	
	
	public String cargarUVA(Element e) {
		NodeList listaRayosUva = e.getElementsByTagName("uv_max");
		String cadena="";
		
		for (int uva = 0; uva < listaRayosUva.getLength(); uva++) {
			Node nodoUVA = listaRayosUva.item(uva);

			if(nodoUVA.getNodeType() == Node.ELEMENT_NODE) {
				Element elementoUva = (Element) nodoUVA;
				System.out.println("Rayos UVA: " + elementoUva.getTextContent());
				
				if(elementoUva.getTextContent().isBlank()) {
					cadena="00";
				}else { cadena=elementoUva.getTextContent();}
			}
		}
		return cadena;
	}
	
	
}
