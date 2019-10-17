package Framework;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Data.AdminProperties;

public class Cls_Screenshot_Ejecucion 
{

	/**
	 * @param args
	 */
	private File Obj_Archivo;
	private File Obj_Carpeta;
	private String Str_Nombre_Archivo = "ScreenShot_";
	private String Str_Fecha = "";
	private String Str_Ruta = "";
	private String Str_Error = "";
	private String Str_Ruta_ScreenShot = "";
	private SimpleDateFormat Dt_Fecha;
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
	
	public boolean Tomar_Screenshot_FullScreen()
	{
		if(!Tomar_Screenshot_FullScreen_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Tomar_Screenshot_FullScreen(String Str_Ruta)
	{
		this.Str_Ruta = Str_Ruta;
		if(!Tomar_Screenshot_FullScreen_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Tomar_Screenshot_FullScreen_Error()
	{
		if(!Tomar_Screenshot_Error())
		{
			return false;
		}
		return true;
	}
	
	public boolean Tomar_Screenshot_FullScreen_Error(String Str_Ruta)
	{
		this.Str_Ruta = Str_Ruta;
		if(!Tomar_Screenshot_Error())
		{
			return false;
		}
		return true;
	}
	
	public boolean Tomar_Screenshot_BrowserScreen()
	{
		if(!Tomar_Screenshot_BrowserScreen_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Tomar_Screenshot_BrowserScreen(WebDriver Obj_Driver)
	{
		this.Obj_Driver = Obj_Driver;
		if(!Tomar_Screenshot_BrowserScreen_Logica())
		{
			return false;
		}
		return true;
	}
	
	public boolean Tomar_Screenshot_BrowserScreen(WebDriver Obj_Driver,String Str_Ruta)
	{
		this.Obj_Driver = Obj_Driver;
		this.Str_Ruta = Str_Ruta;
		if(!Tomar_Screenshot_BrowserScreen_Logica())
		{
			return false;
		}
		return true;
	}
	
	private boolean Tomar_Screenshot_FullScreen_Logica()
	{
		if (Str_Ruta == "")
		{
			Str_Ruta = AdminProperties.IMAGE_PATH;
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
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss mmm");	
			Str_Nombre_Archivo += Dt_Fecha.format(new Date());
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
			Dimension Obj_Dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle Obj_Rectangulo = new Rectangle(Obj_Dimension);
			Robot Obj_Robot = new Robot();			
			BufferedImage Obj_Imagen = Obj_Robot.createScreenCapture(Obj_Rectangulo);
			ImageIO.write(Obj_Imagen, "jpg", new File(Str_Ruta + Str_Nombre_Archivo + "FE.jpg"));
			Str_Ruta_ScreenShot = Str_Ruta + Str_Nombre_Archivo + "FE.jpg";
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00012): Error al crear el Screenshot, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private boolean Tomar_Screenshot_Error()
	{
		if (Str_Ruta == "")
		{
			Str_Ruta = AdminProperties.IMAGE_PATH;
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
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss mmm");	
			Str_Nombre_Archivo += Dt_Fecha.format(new Date());
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
			//Dimension Obj_Dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			Rectangle Obj_dimension = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			Rectangle Obj_Rectangulo = new Rectangle(Obj_dimension);
			Robot Obj_Robot = new Robot();
			BufferedImage Obj_Imagen = Obj_Robot.createScreenCapture(Obj_Rectangulo);
			ImageIO.write(Obj_Imagen, "jpg", new File(Str_Ruta + Str_Nombre_Archivo + "FE.jpg"));
			Str_Ruta_ScreenShot = Str_Ruta + Str_Nombre_Archivo + "FE.jpg";
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00012): Error al crear el Screenshot, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}
	
	private boolean Tomar_Screenshot_BrowserScreen_Logica()
	{
		if (Str_Ruta == "")
		{
			Str_Ruta = AdminProperties.IMAGE_PATH;
		}
		if (Obj_Driver != null)
		{
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
				Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss mmm");	
				Str_Nombre_Archivo += Dt_Fecha.format(new Date());
				Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
				Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
				Obj_Archivo = new File(Str_Ruta + Str_Nombre_Archivo + ".jpg"); 
				Obj_Archivo = ((TakesScreenshot) Obj_Driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Obj_Archivo, new File (Obj_Carpeta.getAbsolutePath() + "\\" + Str_Nombre_Archivo + "BE.jpg"));
				Str_Ruta_ScreenShot = Obj_Carpeta.getAbsolutePath() + "\\" + Str_Nombre_Archivo + "BE.jpg";
			}
			catch(Exception Obj_Excepcion)
			{
				Str_Error = "Error (00012): Error al crear el Screenshot, " + Obj_Excepcion.getMessage();
				System.out.println(Str_Error);
				Destructor();
				return false;
			}
		}
		else
		{
			System.out.println("Error (00013): Error el Webdriver esta vacio");
		}
		return true;
	}
	
	private void Destructor()
	{
		try
		{
			Obj_Driver.close();
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

