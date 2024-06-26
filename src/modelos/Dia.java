package modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dia {

	//atributos
	private List<String> fecha;

	private List<String> precipitacion;//periodo - valor
	private List<String> estado_cielo; //periodo - descripcion
	private List<String> viento; //periodo direccion-velocidad
	private List<String> temperatura;//maxima - minima
	private List<String> humedad;//maxima - minima
	private List<String> rayos_uva;//valor
	
	
	//constructor
	public Dia() {
		this.fecha=new ArrayList<String>();
		this.precipitacion= new ArrayList<String>();
		this.estado_cielo= new ArrayList<String>();
		this.viento= new ArrayList<String>();
		this.temperatura= new ArrayList<String>();
		this.humedad= new ArrayList<String>();
		this.rayos_uva= new ArrayList<String>();
	}
	
	
	//setters
	public void setFecha(String fecha) {
		this.fecha.add(fecha);
	}
	public void setPrecipitacion(String txt) {
		this.precipitacion.add(txt);
	}
	public void setEstado_cielo(String txt) {
		this.estado_cielo.add(txt);
	}
	public void setViento(String txt) {
		this.viento.add(txt);
	}
	public void setTemperatura(String txt) {
		this.temperatura.add(txt);
	}
	public void setHumedad(String txt) {
		this.humedad.add(txt);
	}
	public void setRayos_uva(String uva) {
		this.rayos_uva.add(uva);
	}
	
	
	//getters
	public List<String> getFecha(){
		return this.fecha;
	}
	public List<String> getPrecipitacion(){
		return this.precipitacion;
	}
	
	public List<String> getEstado_cielo(){
		return this.estado_cielo;
	}
	public List<String> getViento(){
		return this.viento;
	}
	public List<String> getTemperatura(){
		return this.temperatura;
	}
	public List<String> getHumedad(){
		return this.humedad;
	}
	public List<String> getRayos_uva() {
		return this.rayos_uva;
	}
	
}
