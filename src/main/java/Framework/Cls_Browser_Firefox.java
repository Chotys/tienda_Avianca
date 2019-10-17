package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Data.AdminProperties;

public class Cls_Browser_Firefox 
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
		System.out.println("Informacion: Clase de llamado del navegador Firefox");
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
	
	public boolean Preparar_Navegador_32(String Str_Ruta_Ejecutable)
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
		Str_Estado = "Informacion: Preparando Navegador Firefox32";
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
		// Guarda el estado "Finalizado" para indicar que termin� de preparar el navegador
		return true;
	}
	
	public boolean Preparar_Navegador_64()
	{
		if (Preparar_Navegador_64_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean Preparar_Navegador_64(String Str_Ruta_Ejecutable)
	{
		this.Str_Ruta_Ejecutable = Str_Ruta_Ejecutable;
		if (Preparar_Navegador_64_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean Preparar_Navegador_64_Logica()
	{
		Str_Estado = "Informacion: Preparando Navegador Firefox64";
		System.out.println(Str_Estado);
		if (Str_Ruta_Ejecutable=="")
		{
			Str_Ruta_Ejecutable = AdminProperties.BROWSER_PATH;
			// Ruta en la cual esta almacenado el ejecutable de Chrome 64 bits
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
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_Driver = new FirefoxDriver();
			Obj_Driver.manage().window().maximize();
			//Abre el navegador y maximiza la pantalla
			
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
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
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().firefox();
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
			//Captura las caracteristicas del navegador como la versi�n
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
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
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities();
			Obj_DC.setCapability("FirefoxDriver.DEFAULT_ENABLE_NATIVE_EVENTS", true);
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_4();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_4()
	{
		try
		{
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().firefox();
			Obj_DC.setCapability("FirefoxDriver.DEFAULT_ENABLE_NATIVE_EVENTS", true);
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_5();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_5()
	{
		try
		{
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities();
			Obj_DC.setCapability("FirefoxDriver.ASSUME_UNTRUSTED_ISSUER", true);
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_6();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_6()
	{
		try
		{
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().firefox();
			Obj_DC.setCapability("FirefoxDriver.ASSUME_UNTRUSTED_ISSUER", true);
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_7();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_7()
	{
		try
		{
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities();
			Obj_DC.setCapability("FirefoxDriver.ASSUME_UNTRUSTED_ISSUER", true);
			Obj_DC.setCapability("FirefoxDriver.DEFAULT_ENABLE_NATIVE_EVENTS", true);
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			Preparar_Navegador_Logica_8();
			return false;
		}
		return true;
	}
	
	private boolean Preparar_Navegador_Logica_8()
	{
		try
		{
			System.setProperty("webdriver.firefox.marionette", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().firefox();
			Obj_DC.setCapability("FirefoxDriver.ASSUME_UNTRUSTED_ISSUER", true);
			Obj_DC.setCapability("FirefoxDriver.DEFAULT_ENABLE_NATIVE_EVENTS", true);
			Obj_Driver = new FirefoxDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00004): Error preparando FireFox , " + Obj_Excepcion.getMessage();
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
			Obj_DC=null;
			Obj_Driver.close();
			Obj_Driver.quit();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (?????): " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}
}
