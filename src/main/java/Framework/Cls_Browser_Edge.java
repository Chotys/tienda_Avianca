package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Data.AdminProperties;

public class Cls_Browser_Edge 
{

	/**
	 * @param args
	 */
	private WebDriver Obj_Driver;
	private String Str_Ruta_Ejecutable = "";
	private String Str_Error = "";
	private String Str_Estado = "";
	private DesiredCapabilities Obj_DC;
	
	// Get/Set de elementos
	
	public WebDriver get_Obj_Driver()
	{
		return Obj_Driver;
	}
	
	public void set_Obj_Driver(WebDriver Obj_Driver)
	{
		this.Obj_Driver = Obj_Driver;
	}
	
	public String get_Str_Ruta_Ejecutable()
	{
		return Str_Ruta_Ejecutable;
		// Devuelve la rutra donde se encuentra almacenado el ejecutable
	}
	
	public void set_Str_Ruta_Ejecutable(String Str_Ruta_Ejecutable)
	{
		this.Str_Ruta_Ejecutable = Str_Ruta_Ejecutable;
	}
	
	public String get_Str_Error()
	{
		return Str_Error;
	}
	
	public void set_Str_Error(String Str_Error)
	{
		this.Str_Error = Str_Error;
	}
	
	public String get_Str_Estado()
	{
		return Str_Estado;
	}
	
	public void set_Str_Estado(String Str_Estado)
	{
		this.Str_Estado = Str_Estado;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Informacion: Clase de llamado del navegador Edge");
	}
	
	public  boolean Preparar_Navegador_32()
	{
		if (Preparar_Navegador_32_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public  boolean Preparar_Navegador_32(String Str_Ruta_Ejecutable)
	{
		this.Str_Ruta_Ejecutable = Str_Ruta_Ejecutable;
		if (Preparar_Navegador_32_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean Preparar_Navegador_32_Logica()
	{
		Str_Estado = "Informacion: Preparando Navegador Edge";
		System.out.println(Str_Estado);
		if (Str_Ruta_Ejecutable=="")
		{
			Str_Ruta_Ejecutable = AdminProperties.BROWSER_PATH;
			// Ruta donde se encuentra almacenado el ejecutable del navegador
		}
		if (!Preparar_Navegador_Logica_1())
		{
			return false;
		}
		Str_Estado = Str_Estado + " - Finalizado";
		System.out.println(Str_Estado);
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_1()
	{
		try
		{
			System.setProperty("webdriver.edge.driver", Str_Ruta_Ejecutable);
			Obj_Driver = new EdgeDriver();
			Obj_Driver.manage().window().maximize();
			// Abre el navegador de la ruta definida y maxima la pantalla
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00002): Error preparando Edge , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_2();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_2()
	{
		try
		{
			System.setProperty("webdriver.edge.driver", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().edge();
			Obj_Driver = new EdgeDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
			
			//Captura las caracteristicas del navegador como versi�n
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00002): Error preparando Edge , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private void Destructor()
	{
		try
		{
			//M�todo que destruye los objetos utilizados en esta clase 
			Obj_DC=null;
			Obj_Driver.quit();
			Obj_Driver.close();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (?????): " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}
}
