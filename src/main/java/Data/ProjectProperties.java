package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProjectProperties {

	Properties props;
	
	public ProjectProperties(){
		
		this.props = new Properties();
		
	}
	
	public void leerArchivoPropiedades(){
		try{
			FileInputStream fis = new FileInputStream("automation.properties");
			props.load(fis);
		}catch(IOException ex){
			System.out.println("Error [" + ex.getMessage() + "]");
		}
	}
	
	public String obtenerValorPropiedad(String nombre){
		return props.getProperty(nombre);
	}
	
}
