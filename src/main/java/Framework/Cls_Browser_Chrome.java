package Framework;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Data.AdminProperties;

public class Cls_Browser_Chrome 
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
		System.out.println("Informacion: Clase de llamado del navegador Chrome");
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

        Str_Estado = "Informacion: Preparando Navegador Chrome";
		System.out.println(Str_Estado);
		if (Str_Ruta_Ejecutable=="")
		{
			Str_Ruta_Ejecutable = AdminProperties.BROWSER_PATH;
			// Ruta en la cual esta almacenado el ejecutable de Chrome 32 bits
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
			
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			Obj_Driver = new ChromeDriver();
			Obj_Driver.manage().window().maximize();
			// Abre el navegador en la ruta indicada y maximiza la pantalla 
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00003): Error preparando Chrome , " + Obj_Excepcion.getMessage();
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
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			Obj_DC = new DesiredCapabilities().chrome();
			Obj_Driver = new ChromeDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
			
			// Captura las caracterisitcas del navegador como versi�n
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00003): Error preparando Chrome , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_3();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_3()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
			Obj_DC = new DesiredCapabilities().chrome();
			Obj_Driver = new ChromeDriver(Obj_DC);
			Obj_Driver = new RemoteWebDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00003): Error preparando Chrome , " + Obj_Excepcion.getMessage();
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
