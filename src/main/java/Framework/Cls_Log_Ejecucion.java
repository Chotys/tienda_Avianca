package Framework;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import Data.AdminProperties;

public class Cls_Log_Ejecucion 
{

	/**
	 * @param args
	 */
	private File Obj_Archivo;
	private File Obj_Carpeta;
	private String Str_Elemento = "";
	private String Str_Estado = "";
	private String Str_Nombre_Archivo = "Log_Ejecucion_";
	private String Str_Fecha = "";
	private String Str_Ruta = "";
	private String Str_Error = "";
	private String Str_Ruta_ScreenShot = "";
	private SimpleDateFormat Dt_Fecha;
	private FileWriter Obj_Escribir;
	private PrintWriter Obj_Escribir_Linea;
	
	// Get/Set de elementos
	
	public File get_Obj_Archivo()
	{
		return Obj_Archivo;
	}
	
	public void set_Obj_Archivo(File Obj_Archivo)
	{
		this.Obj_Archivo = Obj_Archivo;
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
	
	public String get_Str_Fecha()
	{
		return Str_Fecha;
	}
	
	public void set_Str_Fecha(String Str_Fecha)
	{
		this.Str_Fecha = Str_Fecha;
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
	
	public SimpleDateFormat get_Dt_Fecha()
	{
		return Dt_Fecha;
	}
	
	public void set_Dt_Fecha(SimpleDateFormat Dt_Fecha)
	{
		this.Dt_Fecha = Dt_Fecha;
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
	
	public boolean Registrar_Log_TXT()
	{
		if (CrearArchivo_TXT())
		{
			if (!Escribir_Log_TXT())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_TXT(String Str_Estado)
	{
		this.Str_Estado = Str_Estado;

		if (CrearArchivo_TXT())
		{
			if (!Escribir_Log_TXT())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_TXT(String Str_Estado,String Str_Elemento)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		if (CrearArchivo_TXT())
		{
			if (!Escribir_Log_TXT())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_TXT(String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		if (CrearArchivo_TXT())
		{
			if (!Escribir_Log_TXT())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_TXT(String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot,String Str_Nombre_Archivo)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
		if (CrearArchivo_TXT())
		{
			if (!Escribir_Log_TXT())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_TXT(String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot,String Str_Nombre_Archivo,String Str_Ruta)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
		this.Str_Ruta = Str_Ruta;
		if (CrearArchivo_TXT())
		{
			if (!Escribir_Log_TXT())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_HTML()
	{
		if (CrearArchivo_HTML())
		{
			if (!Escribir_Log_HTML())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_HTML(String Str_Estado)
	{
		this.Str_Estado = Str_Estado;
		if (CrearArchivo_HTML())
		{
			if (!Escribir_Log_HTML())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_HTML(String Str_Estado,String Str_Elemento)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		
		
		if (CrearArchivo_HTML())
		{
			if (!Escribir_Log_HTML())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_HTML(String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		if (CrearArchivo_HTML())
		{
			if (!Escribir_Log_HTML())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_HTML(String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot,String Str_Nombre_Archivo)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
		if (CrearArchivo_HTML())
		{
			if (!Escribir_Log_HTML())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	public boolean Registrar_Log_HTML(String Str_Estado,String Str_Elemento,String Str_Ruta_ScreenShot,String Str_Nombre_Archivo,String Str_Ruta)
	{
		this.Str_Estado = Str_Estado;
		this.Str_Elemento = Str_Elemento;
		this.Str_Ruta_ScreenShot = Str_Ruta_ScreenShot;
		this.Str_Nombre_Archivo = Str_Nombre_Archivo;
		this.Str_Ruta = Str_Ruta;
		if (CrearArchivo_HTML())
		{
			if (!Escribir_Log_HTML())
			{
				return false;
			}
		}
		else
		{
			return false;
		}
		return true;
	}
	
	private boolean CrearArchivo_TXT()
	{
		if (Str_Ruta == "")
		{
			Str_Ruta = AdminProperties.TXT_PATH;
		}
		try
		{
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy");
			Str_Ruta += Dt_Fecha.format(new Date()) + "\\";
			Str_Ruta = Str_Ruta.replaceAll("-", "_");
			Obj_Carpeta = new File(Str_Ruta);
			if (!Obj_Carpeta.isDirectory())
			{
				Obj_Carpeta.mkdirs();
			}
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh");	
			Str_Nombre_Archivo += Dt_Fecha.format(new Date());
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
			Obj_Archivo = new File(Str_Ruta + Str_Nombre_Archivo + ".txt"); 
			if (!Obj_Archivo.exists())
			{
				String Str_Cabezote = "************************************************************************************************************";
				Obj_Archivo.createNewFile();
				Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				Str_Fecha = Dt_Fecha.format(new Date());
				Obj_Escribir = new FileWriter(Obj_Archivo,true);
				Obj_Escribir_Linea = new PrintWriter(Obj_Escribir);
				Obj_Escribir_Linea.println(Str_Cabezote);
				Obj_Escribir_Linea.println(Str_Cabezote);
				Obj_Escribir_Linea.println("Fecha			-	Estado							-	Elemento	");
				Obj_Escribir_Linea.println(Str_Cabezote);
				Obj_Escribir_Linea.close();
				Obj_Escribir.close();
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00008): Error al crear el archivo TXT, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private boolean CrearArchivo_HTML()
	{
		if (Str_Ruta == "")
		{
			Str_Ruta = AdminProperties.HTML_PATH;
		}
		try
		{
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy");
			Str_Ruta += Dt_Fecha.format(new Date()) + "\\";
			Str_Ruta = Str_Ruta.replaceAll("-", "_");
			Obj_Carpeta = new File(Str_Ruta);
			if (!Obj_Carpeta.isDirectory())
			{
				Obj_Carpeta.mkdirs();
			}
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh");	
			Str_Nombre_Archivo += Dt_Fecha.format(new Date());
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
			Obj_Archivo = new File(Str_Ruta + Str_Nombre_Archivo + ".html"); 
			if (!Obj_Archivo.exists())
			{
				String Str_Cabezote = "<html>" + '\n' + "<head>"  + '\n' + "<title>Logs de Resultados</title></head>" + '\n' + "<body>" + '\n' + "<table border='1' align='center'>";
				String Str_HTML_Registro_Inicio = "<tr>" + '\n' + "  <td align='center'>";
				String Str_HTML_Registro_Fin = "</td>" + '\n' + "</tr>";
				String Str_HTML_Registro_Separador = "</td><td align='center'>";
				Obj_Archivo.createNewFile();
				Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
				Str_Fecha = Dt_Fecha.format(new Date());
				Obj_Escribir = new FileWriter(Obj_Archivo,true);
				Obj_Escribir_Linea = new PrintWriter(Obj_Escribir);
				Obj_Escribir_Linea.println(Str_Cabezote);
				Obj_Escribir_Linea.println(Str_HTML_Registro_Inicio + "Fecha" + Str_HTML_Registro_Separador + "Estado" + Str_HTML_Registro_Separador + "Elemento" + Str_HTML_Registro_Separador + "Screenshot" + Str_HTML_Registro_Fin);
				Obj_Escribir_Linea.close();
				Obj_Escribir.close();
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00009): Error al crear el archivo HTML, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private boolean Escribir_Log_TXT()
	{
		try
		{
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			Str_Fecha = Dt_Fecha.format(new Date());
			Obj_Escribir = new FileWriter(Obj_Archivo,true);
			Obj_Escribir_Linea = new PrintWriter(Obj_Escribir);
			if (Str_Estado.contains("Preparando Navegador"))
			{ 
				Obj_Escribir_Linea.println("******************************************* Nueva Ejecucion *************************************************"); 
			}
			
			Obj_Escribir_Linea.println(Str_Fecha + "	-	" + Str_Estado + "	-	" +  Str_Elemento ); 
			Obj_Escribir_Linea.close();
			Obj_Escribir.close();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (000010): Error escribiendo el archivo en TXT, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private boolean Escribir_Log_HTML()
	{
		try
		{
			String Str_HTML_Registro_Inicio = "<tr>" + '\n' + "  <td align='center'>";
			String Str_HTML_Registro_Fin = "</td>" + '\n' + "</tr>";
			String Str_HTML_Registro_Separador = "</td><td>";
			String Str_HTML_Registro_ahref_Inicio = "<A HREF='";
			String Str_HTML_Registro_ahref_Fin = "' TARGET='_new'>Ver Imagen</A>";
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			Str_Fecha = Dt_Fecha.format(new Date());
			Obj_Escribir = new FileWriter(Obj_Archivo,true);
			Obj_Escribir_Linea = new PrintWriter(Obj_Escribir);
			System.out.println();
		
			if (Str_Estado.contains("Preparando Navegador"))
			{
				String Str_HTML_Registro_Inicio_2 = "<tr>" + '\n' + "  <td align='center' colspan='4'>";
				Obj_Escribir_Linea.println(Str_HTML_Registro_Inicio_2 + "Nueva Ejecucion" + Str_HTML_Registro_Fin);
			}
			Obj_Escribir_Linea.println(Str_HTML_Registro_Inicio + Str_Fecha + Str_HTML_Registro_Separador + Str_Estado + Str_HTML_Registro_Separador + Str_Elemento 
					+ Str_HTML_Registro_Separador + Str_HTML_Registro_ahref_Inicio + Str_Ruta_ScreenShot + Str_HTML_Registro_ahref_Fin + Str_HTML_Registro_Fin); 
			Obj_Escribir_Linea.close();
			Obj_Escribir.close();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00011): Error escribiendo el archivo en HTML , " + Obj_Excepcion.getMessage();
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
			Obj_Escribir.close();
			Obj_Escribir_Linea.close();
			Obj_Archivo = null;
			Dt_Fecha = null;
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (?????): " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}
}

