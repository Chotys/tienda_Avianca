package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import Data.AdminProperties;

public class Cls_Browser_IE 
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
		System.out.println("Informacion: Clase de llamado del navegador IE");
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
		Str_Estado = "Informacion: Preparando Navegador IE32";
		System.out.println(Str_Estado);


		if (Str_Ruta_Ejecutable=="")
		{
			Str_Ruta_Ejecutable = AdminProperties.BROWSER_PATH;
			//Ruta donde se encuentra el ejecutable del navegador
		}
		if (!Preparar_Navegador_Logica_1())
		{
			return false;
		}
		Str_Estado = Str_Estado + " - Finalizado";
		System.out.println(Str_Estado);
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
		Str_Estado = "Informacion: Preparando Navegador IE64";
		System.out.println(Str_Estado);
		if (Str_Ruta_Ejecutable=="")
		{
			Str_Ruta_Ejecutable = AdminProperties.BROWSER_PATH;
			// Ruta donde se encuentra el ejecutable del navegador a 64 bits
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
			System.setProperty("webdriver.ie.driver", Str_Ruta_Ejecutable);
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		    capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		    capabilities.setCapability("ignoreZoomSetting", true);
		    capabilities.setJavascriptEnabled(true);
		    Obj_Driver = new InternetExplorerDriver(capabilities);
		    
//			System.setProperty("webdriver.ie.driver", Str_Ruta_Ejecutable);
//			System.out.println("Ruta: " + Str_Ruta_Ejecutable);
//			Obj_Driver = new InternetExplorerDriver();
			Obj_Driver.manage().window().maximize();
			// Abre el navegador y maximiza la pantalla
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00001): Error preparando Internet Explorer , " + Obj_Excepcion.getMessage();
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
			System.setProperty("webdriver.ie.driver", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().internetExplorer();
			Obj_Driver = new InternetExplorerDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();			
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00001): Error preparando Internet Explorer , " + Obj_Excepcion.getMessage();
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
			System.setProperty("webdriver.ie.driver", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities();
			Obj_DC.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			Obj_Driver = new InternetExplorerDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00001): Error preparando Internet Explorer , " + Obj_Excepcion.getMessage();
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
			System.setProperty("webdriver.ie.driver", Str_Ruta_Ejecutable);
			Obj_DC = new DesiredCapabilities().internetExplorer();
			Obj_DC.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			Obj_Driver = new InternetExplorerDriver(Obj_DC);
			Obj_Driver.manage().window().maximize();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00001): Error preparando Internet Explorer , " + Obj_Excepcion.getMessage();
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

