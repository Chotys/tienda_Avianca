package Framework;

import org.openqa.selenium.WebDriver;

import ejercicio_Sofka.Tienda.Practice;
import ejercicio_Sofka.Tienda.Avianca;

public class Cls_Cross_Browsing
{

	/**
	 * @param args
	 */
	private WebDriver Obj_Driver;
	private String Str_Ruta_Ejecutable = "";
	private String Str_Error = "";
	private String Str_Estado = "";
	private int Int_Eleccion_Navegador = 1;
	private Cls_Administrador_Evidencias Obj_Administrador_Evidencias;
	private int Int_Eleccion_Evidencias = 15;
	private String Str_URL_Website;
	Avianca regiustro = new Avianca();
	
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
	
	public String get_Str_URL_Website()
	{
		return Str_URL_Website;
	}
	
	public void set_Str_URL_Website(String Str_URL_Website)
	{
		this.Str_URL_Website = Str_URL_Website;
	}
	
	public int get_Int_Eleccion_Navegador()
	{
		return Int_Eleccion_Navegador;
	}
	
	public void set_Int_Eleccion_Navegador(int Int_Eleccion_Navegador)
	{
		this.Int_Eleccion_Navegador = Int_Eleccion_Navegador;
	}
	
	public int get_Int_Eleccion_Evidencias()
	{
		return Int_Eleccion_Evidencias;
	}
	
	public void set_Int_Eleccion_Evidencias(int Int_Eleccion_Evidencias)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		System.out.println("Informacion: Clase de llamado de Cross Browsing");
	}
	
	public boolean Abrir_Website()
	{
		try
		{
			Obj_Driver.get(Str_URL_Website);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00006): Error navegando , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	public boolean Abrir_Website(WebDriver Obj_Driver)
	{
		this.Obj_Driver = Obj_Driver;
		try
		{
			Obj_Driver.get(Str_URL_Website);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00006): Error navegando , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	public boolean Abrir_Website(String Str_URL_Website)
	{
		this.Str_URL_Website = Str_URL_Website;
		try
		{
			Obj_Driver.get(Str_URL_Website);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00006): Error navegando , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	public boolean Abrir_Website(WebDriver Obj_Driver,String Str_URL_Website)
	{
		this.Obj_Driver = Obj_Driver;
		this.Str_URL_Website = Str_URL_Website;
		try
		{
			Obj_Driver.get(Str_URL_Website);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00006): Error navegando , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	public boolean Eleccion_Browser()
	{
		if (Eleccion_Browser_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean Eleccion_Browser(int Int_Eleccion_Navegador)
	{
		this.Int_Eleccion_Navegador = Int_Eleccion_Navegador;
		if (Eleccion_Browser_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean Eleccion_Browser(int Int_Eleccion_Navegador,int Int_Eleccion_Evidencias)
	{
		this.Int_Eleccion_Navegador = Int_Eleccion_Navegador;
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		if (Eleccion_Browser_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean Eleccion_Browser(int Int_Eleccion_Navegador,String Str_Ruta_Ejecutable)
	{
		this.Int_Eleccion_Navegador = Int_Eleccion_Navegador;
		this.Str_Ruta_Ejecutable = Str_Ruta_Ejecutable;
		if (Eleccion_Browser_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean Eleccion_Browser(int Int_Eleccion_Navegador,int Int_Eleccion_Evidencias,String Str_Ruta_Ejecutable)
	{
		this.Int_Eleccion_Navegador = Int_Eleccion_Navegador;
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
		this.Str_Ruta_Ejecutable = Str_Ruta_Ejecutable;
		if (Eleccion_Browser_Logica())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	private boolean Eleccion_Browser_Logica()
	{
		try
		{
			Obj_Administrador_Evidencias = new Cls_Administrador_Evidencias();
			switch (Int_Eleccion_Navegador) 
			{
			case 1:
				Cls_Browser_Chrome Obj_Navegador_Chrome = new Cls_Browser_Chrome();
				if (Obj_Navegador_Chrome.Preparar_Navegador_32())
				{
					Obj_Driver = Obj_Navegador_Chrome.get_Obj_Driver();
					Str_Estado = Obj_Navegador_Chrome.get_Str_Estado();
				}
				else
				{
					Str_Error = Obj_Navegador_Chrome.get_Str_Error();
					Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
//					Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
					return false;
				}
				Obj_Navegador_Chrome = null;
				
				break;
				
			case 2:
				Cls_Browser_Firefox Obj_Navegador_Firefox64 = new Cls_Browser_Firefox();
				if (Obj_Navegador_Firefox64.Preparar_Navegador_64())
				{
					Obj_Driver = Obj_Navegador_Firefox64.get_Obj_Driver();
					Str_Estado = Obj_Navegador_Firefox64.get_Str_Estado();
				}
				else
				{
					Str_Error = Obj_Navegador_Firefox64.get_Str_Error();
					Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
//					Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
					return false;
				}
				Obj_Navegador_Firefox64 = null;
				break;
			case 3:
				Cls_Browser_Firefox Obj_Navegador_Firefox32 = new Cls_Browser_Firefox();
				if (Obj_Navegador_Firefox32.Preparar_Navegador_32())
				{
					Obj_Driver = Obj_Navegador_Firefox32.get_Obj_Driver();
					Str_Estado = Obj_Navegador_Firefox32.get_Str_Estado();
				}
				else
				{
					Str_Error = Obj_Navegador_Firefox32.get_Str_Error();
					Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
//					Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
					return false;
				}
				Obj_Navegador_Firefox32 = null;
				break;
			case 4:
				Cls_Browser_IE Obj_Navegador_IE32 = new Cls_Browser_IE();
				if (Obj_Navegador_IE32.Preparar_Navegador_32())
				{
					Obj_Driver = Obj_Navegador_IE32.get_Obj_Driver();
					Str_Estado = Obj_Navegador_IE32.get_Str_Estado();
				}
				else
				{
					Str_Error = Obj_Navegador_IE32.get_Str_Error();
					Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
//					Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
					return false;
				}
				Obj_Navegador_IE32 = null;
				
				break;
			case 5:
				Cls_Browser_IE Obj_Navegador_IE64 = new Cls_Browser_IE();
				if (Obj_Navegador_IE64.Preparar_Navegador_64())
				{
					Obj_Driver = Obj_Navegador_IE64.get_Obj_Driver();
					Str_Estado = Obj_Navegador_IE64.get_Str_Estado();
				}
				else
				{
					Str_Error = Obj_Navegador_IE64.get_Str_Error();
					Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
//					Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
					return false;
				}
				Obj_Navegador_IE64 = null;
				break;
			case 6:
				Cls_Browser_Edge Obj_Navegador_Edge = new Cls_Browser_Edge();
				if (Obj_Navegador_Edge.Preparar_Navegador_32())
				{
					Obj_Driver = Obj_Navegador_Edge.get_Obj_Driver();
					Str_Estado = Obj_Navegador_Edge.get_Str_Estado();
				}
				else
				{
					Str_Error = Obj_Navegador_Edge.get_Str_Error();
					Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
//					Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
					return false;
				}
				Obj_Navegador_Edge = null;
				break;
			default:
				Int_Eleccion_Navegador = 6;
				Eleccion_Browser_Logica();
				break;
			}
			Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
			Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Estado);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00005): Error en la eleccion del navegador , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
//			Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
		
	private void Destructor()
	{
		try
		{
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

