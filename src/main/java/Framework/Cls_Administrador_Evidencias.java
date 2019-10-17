package Framework;

import org.openqa.selenium.WebDriver;


public class Cls_Administrador_Evidencias 
{

	/**
	 * @param args
	 */
	private String Str_Elemento = "";
	private String Str_Estado = "";
	private String Str_Nombre_Archivo = "";
	private String Str_Ruta = "";
	private String Str_Error = "";
	private String Str_Ruta_ScreenShot = "";
	private int Int_Eleccion_Evidencias = 8;
	private Cls_Log_Ejecucion Obj_Log_Ejecucion;
	private Cls_Screenshot_Ejecucion Obj_Screenshot;
	private WebDriver Obj_Driver;

	
	// Get/Set de elementos
		
	public WebDriver get_Obj_Driver()
	{
		return Obj_Driver;
	}
	
	public void set_Obj_Driver(WebDriver Obj_Driver)
	{
		this.Obj_Driver = Obj_Driver;
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
	
	public String get_Str_Elemento()
	{
		return Str_Elemento;
	}
	
	public void set_Str_Elemento(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
	}

	public String get_Str_Ruta()
	{
		return Str_Ruta;
	}
	
	public void set_Str_Ruta(String Str_Ruta)
	{
		this.Str_Ruta = Str_Ruta;
	}
	
	public String get_Str_Nombre_Archivo()
	{
		return Str_Nombre_Archivo;
	}
	
	public void set_Str_Nombre_Archivo(String Str_Nombre_Archivo)
	{
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
	}
	
	public int get_Int_Eleccion_Evidencias()
	{
		return Int_Eleccion_Evidencias;
	}
	
	public void set_Int_Eleccion_Evidencias(int Int_Eleccion_Evidencias)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
	}
	
	public String get_Str_Ruta_ScreenShot()
	{
		return Str_Ruta_ScreenShot;
	}
	
	public void set_Str_Ruta_ScreenShot(String Str_Ruta_ScreenShot)
	{
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Informacion: Clase de Log Ejecucion");
	}
	
	public boolean Eleccion_Evidencia()
	{
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Evidencia(int Int_Eleccion_Evidencias)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Evidencia(int Int_Eleccion_Evidencias,String Str_Estado)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		this.Str_Estado = Str_Estado;
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Evidencia(int Int_Eleccion_Evidencias,String Str_Estado,String Str_Elemento)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Evidencia(int Int_Eleccion_Evidencias,String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot)
	{
		//Inicializa los objetos con el valor de los parametros enviados
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Evidencia(int Int_Eleccion_Evidencias,String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot,String Str_Nombre_Archivo)
	{
		//Inicializa los objetos con el valor de los parametros enviados
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Evidencia(int Int_Eleccion_Evidencias,String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot,String Str_Nombre_Archivo,String Str_Ruta)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
		this.Str_Ruta = Str_Ruta;
		if(!Eleccion_Evidencia_Logica())
		{
			return false;
		}
		return true;
	}
	
	private boolean Eleccion_Evidencia_Logica()
	{
		try
		{
			Obj_Log_Ejecucion = new Cls_Log_Ejecucion(); //Llama a la clase de registro de Log
			Obj_Screenshot = new Cls_Screenshot_Ejecucion(); //Llama a la clase de toma de evidencia
			Obj_Log_Ejecucion.set_Str_Estado(Str_Estado); // Registra el estado de las diferentes transaciones realizadas en el LOG
			Obj_Log_Ejecucion.set_Str_Elemento(Str_Elemento); // Registra el nomnbre del elemento (con cada transacci�n) con el que se este interactuando.
			Obj_Log_Ejecucion.set_Str_Ruta_ScreenShot(Str_Ruta_ScreenShot); //Registra la informaci�n en la ruta definida para Str_Ruta_ScreenShot
			switch (Int_Eleccion_Evidencias) {
			case 1:
				// Registro LOG en Html
				Obj_Log_Ejecucion.Registrar_Log_HTML();
				break;
			case 2:
				// Registro LOG en TXT
				Obj_Log_Ejecucion.Registrar_Log_TXT();
				break;
			case 3:
				//Registra LOG en formato Html y TXT (SIN EVIDENCIAS)
				Int_Eleccion_Evidencias = 1; // Asigna valor de 1 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 1
				// Eleccion_Evidencia_Logica();
				Int_Eleccion_Evidencias = 2; // Asigna valor de 2 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 2
				// Eleccion_Evidencia_Logica();
				break;
			case 4:
				Obj_Screenshot.Tomar_Screenshot_FullScreen(); // Llama el m�todo  de toma de evidencia FullScreen
				Str_Ruta_ScreenShot = Obj_Screenshot.get_Str_Ruta_ScreenShot(); //Almacena la evidencia en la ruta definida en la variable  Str_Ruta_ScreenShot
				break;
			case 5:
				Obj_Screenshot.Tomar_Screenshot_BrowserScreen(Obj_Driver); // Llama el m�todo  de toma de evidencia BrowserScreen
				Str_Ruta_ScreenShot = Obj_Screenshot.get_Str_Ruta_ScreenShot(); //Almacena la evidencia en la ruta definida en la variable  Str_Ruta_ScreenShot
				break;
			case 6:
				// Toma solo evidencias FullScreen y BrowserScreen (SIN LOG) 
				Int_Eleccion_Evidencias = 4; // Asigna valor de 4 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 4
				// Eleccion_Evidencia_Logica();
				Int_Eleccion_Evidencias = 5; // Asigna valor de 5 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 5
				// Eleccion_Evidencia_Logica();
				break;
			case 7:
				//Registra LOG en formato Html y toma evidencia FullScreen
				Int_Eleccion_Evidencias = 4; // Asigna valor de 4 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 4
				// Eleccion_Evidencia_Logica();
				Obj_Log_Ejecucion.Registrar_Log_HTML(); // Registra LOG en formato HTML
				break;
			case 8:
				//Registra LOG en formato TXT y toma evidencia FullScreen
				Int_Eleccion_Evidencias = 4; // Asigna valor de 4 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 4
				// Eleccion_Evidencia_Logica();
				Obj_Log_Ejecucion.Registrar_Log_TXT(); // Registra log en formato TXT
				break;
			case 9:
				Int_Eleccion_Evidencias = 4; // Asigna valor de 4 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 4
				// Eleccion_Evidencia_Logica();
				Int_Eleccion_Evidencias = 3; // Asigna valor de 3 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 3
				// Eleccion_Evidencia_Logica(); // Registra LOG en formato Html y TXT
				break;
			case 10:
				Int_Eleccion_Evidencias = 5; // Asigna valor de 5 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 5
//				// Eleccion_Evidencia_Logica();
				Obj_Log_Ejecucion.Registrar_Log_HTML(); // Registra LOG en formato HTML
				break;
			case 11:
				Int_Eleccion_Evidencias = 5; //Asigna valor de 5 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 5
				// Eleccion_Evidencia_Logica();
				Obj_Log_Ejecucion.Registrar_Log_TXT(); //Registra LOG en formato TXT
				break;
			case 12:
				// Toma evidencias BrowserScreen y registra LOG en HTML y 
				Int_Eleccion_Evidencias = 5; // Asigna valor de 5 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 5
				// Eleccion_Evidencia_Logica();
				Int_Eleccion_Evidencias = 3; // Asigna valor de 3 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 3
				// Eleccion_Evidencia_Logica();
				break;
			case 13:
				// Toma ambas evidencias FullScreen y BrowserScreen
				Int_Eleccion_Evidencias = 6; // Asigna valor de 6 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 6
				// Eleccion_Evidencia_Logica();
				Obj_Log_Ejecucion.Registrar_Log_HTML(); // Registra el LOG en formato HTML
				break;
			case 14:
				// Toma ambas evidencias FullScreen y BrowserScreen
				Int_Eleccion_Evidencias = 6; // Asigna valor de 6 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 6
				// Eleccion_Evidencia_Logica();
				Obj_Log_Ejecucion.Registrar_Log_TXT(); //Registra LOG en formato TXT
				break;
			case 15:
				// Toma ambas evidencias Full Screen y Browser Screen
				Int_Eleccion_Evidencias = 6; // Asigna valor de 6 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 6
				// Eleccion_Evidencia_Logica();
				// Registra LOG en abmos formatos HTML y TXT
				Int_Eleccion_Evidencias = 3; // Asigna valor de 3 a la variable Int_Eleccion_Evidencias y llama el m�todo Eleccion_Evidencia_Logica() (Se llama a si mismo). Llama el Case 3
				// Eleccion_Evidencia_Logica();
				break;
			default:
				System.out.println("Informacion: Se ha seleccionado no registrar evidencias");
				break;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00008): Error seleccionando la evidencia , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private void Destructor()
	{
		//M�todo que destruye todos los objetos utilizados en la clase.
		try
		{
			Obj_Driver.close();
			Obj_Screenshot = null;
			Obj_Log_Ejecucion = null;
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (?????): " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}
}
