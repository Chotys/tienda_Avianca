package Framework;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cls_Encontrar_Elemento 
{
	private WebDriver Obj_Driver;
	private RemoteWebDriver Obj_RemoteWDriver; 
	private WebElement Obj_WebElement;
	private String Str_Elemento = "";
	private String Str_Texto = "";
	private String Str_Error = "";
	private String Str_Estado = "";
	private int Int_Eleccion_Evidencias = 0;
	private int Int_Tiempo_Espera = 15;
	private Cls_Administrador_Evidencias Obj_Administrador_Evidencias = new Cls_Administrador_Evidencias();
	static int Int_Umbral=0;

	public RemoteWebDriver get_Obj_RemoteWDriver()
	{
		return Obj_RemoteWDriver;
	}

	public void set_Obj_RemoteWDriver(RemoteWebDriver Obj_RemoteWDriver)
	{
		this.Obj_RemoteWDriver = Obj_RemoteWDriver;
	}

	public WebDriver get_Obj_Driver()
	{
		return Obj_Driver;
	}

	public void set_Obj_Driver(WebDriver Obj_Driver)
	{
		this.Obj_Driver = Obj_Driver;
	}

	public WebElement get_Obj_WebElement()
	{
		return Obj_WebElement;
	}

	public void set_Obj_WebElement(WebElement Obj_WebElement)
	{
		this.Obj_WebElement = Obj_WebElement;
	}

	public String get_Str_Elemento()
	{
		return Str_Elemento;
	}

	public void set_Str_Elemento(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
	}

	public void set_Str_Texto(String Str_Texto)
	{
		this.Str_Texto = Str_Texto;
	}

	public String get_String_Str_Texto()
	{
		return Str_Texto;
	}

	public String get_String_Str_Error()
	{
		return Str_Error;
	}

	public void set_Str_Error(String Str_Error)
	{
		this.Str_Error = Str_Error;
	}

	public int get_Int_Eleccion_Evidencias()
	{
		return Int_Eleccion_Evidencias;
	}

	public void set_Int_Eleccion_Evidencias(int Int_Eleccion_Evidencias)
	{
		this.Int_Eleccion_Evidencias = Int_Eleccion_Evidencias;
	}

	public int get_Int_Tiempo_Espera()
	{
		return Int_Tiempo_Espera;
	}

	public void set_Int_Tiempo_Espera(int Int_Tiempo_Espera)
	{
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
	}

	public String get_Str_Estado()
	{
		return Str_Estado;
	}

	public void set_Str_Estado(String Str_Estado)
	{
		this.Str_Estado = Str_Estado;
	}

	// M�todos para Encontrar elementos por diferentes opciones
	public boolean Encontrar_ClassName()
	{
		//M�todo para encontrar elemento por ClassName
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.className(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Regitra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00014: Error encontrando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje en consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por ClassName");
		return true;
	}

	public boolean Encontrar_CssSelector()
	{
		// M�todo para encontrar elemento por CssSelector
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.cssSelector(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Regitra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00015: Error encontrando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje en consola indicando que el elemento se ha encontrado 
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por CssSelector");
		return true;
	}

	public boolean Encontrar_ID()
	{
		//M�todo para encontrar elemento por ID
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.id(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Regitra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00016: Error encontrando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje en consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por ID");
		return true;
	}

	public boolean Encontrar_LinkText()
	{
		// M�todo para encontrar elemento por LinkText
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.linkText(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Regitra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00017: Error encontrando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje en consola indicando que se ha encontrado el elemento 
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por LinkText");
		return true;
	}

	public boolean Encontrar_Name()
	{
		//M�todo para encontrar elemento por Name
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.name(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Regitra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00018: Error encontrando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por Name");
		return true;
	}

	public boolean Encontrar_PartialLinkText()
	{
		// M�todo para encontrar elemento por PartialLinkText
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.partialLinkText(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00019: Error encontrando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje en consola indicando que se ha encontrdo el elemento.
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por PartialLinkText");
		return true;
	}

	public boolean Encontrar_TagName()
	{
		//M�todo para encontrar elemento por TagName
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.tagName(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Regitra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00020: Error encontrando elemento "+ Str_Elemento +" por Tagname  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por Tagname");
		return true;
	}

	public boolean Encontrar_XPath_Generico()
	{
		//M�todo para encontrar elemento por Xpath
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.xpath(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00021: Error encontrando elemento "+ Str_Elemento +" por Xpath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por XPath");
		return true;
	}

	public boolean Encontrar_ClassName(String Str_Elemento)
	{
		//M�todo que recibe como p�rametro Str_Elemento y lo busca por ClassName
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.className(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00014: Error encontrando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por ClassName");
		return true;
	}

	public boolean Encontrar_CssSelector(String Str_Elemento)
	{
		// M�todo que recibe como p�rametro el elemento Str_Elemento y lo busca por CssSelector
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.cssSelector(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00015: Error encontrando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por CssSelector");
		return true;
	}

	public boolean Encontrar_ID(String Str_Elemento)
	{
		//M��todo que recibe como p�rametro Str_Elemento y lo busca por ID
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.id(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00016: Error encontrando elemento "+ Str_Elemento +" por ID  , "+ Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje por consola indicando que ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por ID");
		return true;
	}

	public boolean Encontrar_LinkText(String Str_Elemento)
	{
		//M�todo que recibe como p�ramtero Str_Elemento y lo busca por LinkText
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.linkText(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00017: Error encontrando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje por consola indicando que ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por LinkText");
		return true;
	}

	public boolean Encontrar_Name(String Str_Elemento)
	{
		//M�todo que recibe p�ramtero Str_Elemnto y lo busca por Name
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.name(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00018: Error encontrando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje por consola indicando que ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por Name");
		return true;
	}

	public boolean Encontrar_PartialLinkText(String Str_Elemento)
	{
		//M�todo que recibe como p�rametro Str_Elemento y lo busca por PartialLinkText
		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.partialLinkText(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00019: Error encontrando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por PartialLinkText");
		return true;
	}

	public boolean Encontrar_TagName(String Str_Elemento)
	{
		//M�todo que recibe p�rametro Str_Elemento y lo busca por TagName
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.tagName(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00020: Error encontrando elemento "+ Str_Elemento +" por Tagname  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		// Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por TagName");
		return true;
	}

	public boolean Encontrar_XPath_Generico(String Str_Elemento)
	{
		//M�todo que recibe como p�rametro Str_Elemento y lo busca por Xpath
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_WebElement = Obj_Driver.findElement(By.xpath(Str_Elemento));
			Resultado_Positivo("Encontrado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00021: Error encontrando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return false;
		}
		//Mensaje por consola indicando que se ha encotrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por XPath");
		return true;
	}

	// M�todos Esperar Elemento por diferentes opciones
	public boolean Esperar_ClassName()
	{
		//Espera que el elemento este disponible por ClassName
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.className(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00022: Error esperando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elmento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por ClassName");
		return true;
	}

	public boolean Esperar_CssSelector()
	{
		// Espera que el elemento este disponible por CssSelector
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00023: Error esperando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		// Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por CssSelector");
		return true;
	}

	public boolean Esperar_ID()
	{
		// Espera que el elemento se encuentre disponible por ID
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.id(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00024: Error esperando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		// Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por ID");
		return true;
	}

	public boolean Esperar_LinkText()
	{
		// Espera que el elemento se encuentre disponible por LinkText
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00025: Error esperando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		// Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por LinkText");
		return true;
	}

	public boolean Esperar_Name()
	{
		//Espera que el elemento se encuentre disponible por Name
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.name(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00026: Error esperando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por Name");
		return true;
	}

	public boolean Esperar_PartialLinkText()
	{
		//Espera que el elemento se encuentre disponible por PartialLinkText 
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.
					partialLinkText(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00027: Error esperando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		// Mensaje por consola indicando que el elemento esta disponible.
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por PartialLinkText");
		return true;
	}

	public boolean Esperar_TagName()
	{
		//Espera que el elemento se encuentre disponible por TagName
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.tagName(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00028: Error esperando elemento "+ Str_Elemento +" por Tagname  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se encuentra disponible
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por TagName");
		return true;
	}

	public boolean Esperar_XPath_Generico()
	{
		//Espera que el elemento se encuentre disponible por Xpath
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00029: Error esperando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento esta disponible
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por XPath");
		return true;
	}

	public boolean Esperar_ClassName(String Str_Elemento)
	{
		//Espera que el elemento se encuentre disponible por ClassName y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.className(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00022: Error esperando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por ClassName");
		return true;
	}

	public boolean Esperar_CssSelector(String Str_Elemento)
	{
		// Espera que el elemento este disponible por CssSelector y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00023: Error esperando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por CssSelector");
		return true;
	}

	public boolean Esperar_ID(String Str_Elemento)
	{
		//Espera que el elemento este disponible por ID y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.id(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00024: Error esperando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		// Mensaje por consola indicando que el elemento fue encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por ID");
		return true;
	}

	public boolean Esperar_LinkText(String Str_Elemento)
	{
		//Espera que el elemento este disponible por LinkText, y recibe como p�rametro el elemento Str_Elemento 
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00025: Error esperando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento fue encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por LinkText");
		return true;
	}

	public boolean Esperar_Name(String Str_Elemento)
	{
		// Espera que el elemento este disponible por Name, y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.name(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00026: Error esperando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento ha sido encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por Name");
		return true;
	}

	public boolean Esperar_PartialLinkText(String Str_Elemento)
	{
		//Espera que el elemento este disponible por PartialLinText
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.
					partialLinkText(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{			
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00027: Error esperando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento ha sido encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por PartialLinkText");
		return true;
	}



	public boolean Esperar_TagName(String Str_Elemento)
	{
		//Espera que el elemento este disponible por TagName, y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.tagName(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00028: Error esperando elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento ha sido encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por TagName");
		return true;
	}

	public boolean Esperar_XPath_Generico(String Str_Elemento)
	{
		//Espera que el elemento este disponible por Xpath, y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00029: Error esperando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento ha sido encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por XPath");
		return true;
	}

	public boolean Esperar_ClassName(String Str_Elemento, int Int_Tiempo_Espera)
	{
		//Espera que el elemento este disponible por ClassName, y recibe como p�rametro el elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.className(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00022: Error esperando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento ha sido encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por ClassName");
		return true;
	}

	public boolean Esperar_CssSelector(String Str_Elemento, int Int_Tiempo_Espera)
	{
		// Espera que el elemento este disponible por CssSelector, recibe como p�rametro el eleemnto Str_Elemento
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00023: Error esperando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento ha sido encontrado.
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por CssSelector");
		return true;
	}

	public boolean Esperar_ID(String Str_Elemento, int Int_Tiempo_Espera)
	{
		// Espera que el elemento este disponible por ID, recibe parametro del elemento Str_Elemento
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.id(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00024: Error esperando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por ID");
		return true;
	}

	public boolean Esperar_LinkText(String Str_Elemento, int Int_Tiempo_Espera)
	{
		//Espera que el elemento este disponible por LinkText, recibe como parametro el elemento y tienen tiempo de espera
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00025: Error esperando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por LinkText");
		return true;
	}

	public boolean Esperar_Name(String Str_Elemento, int Int_Tiempo_Espera)
	{
		//Espera que el elemento este disponible por LinkText, recibe como parametro el elemento y tienen tiempo de espera
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.name(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00026: Error esperando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por Name");
		return true;
	}

	public boolean Esperar_PartialLinkText(String Str_Elemento, int Int_Tiempo_Espera)
	{
		//Espera que el elemento este disponible por LinkText, recibe como parametro el elemento y tienen tiempo de espera
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.
					partialLinkText(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00027: Error esperando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por PartialLinkText");
		return true;
	}

	public boolean Esperar_TagName(String Str_Elemento, int Int_Tiempo_Espera)
	{
		//Espera que el elemento este disponible por LinkText, recibe como parametro el elemento y tienen tiempo de espera
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.tagName(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00028: Error esperando elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que se ha encontrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por TagName");
		return true;
	}

	public boolean Esperar_XPath_Generico(String Str_Elemento, int Int_Tiempo_Espera)
	{
		//Espera que el elemento este disponible por Xpath, recibe como parametro el elemento y tienen tiempo de espera
		this.Str_Elemento = Str_Elemento;
		this.Int_Tiempo_Espera = Int_Tiempo_Espera;
		try
		{
			WebElement Obj_WebElement = (new WebDriverWait(Obj_Driver, Int_Tiempo_Espera)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(Str_Elemento)));
			Resultado_Positivo("Esperado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00029: Error esperando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Esperado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha encontrado
		System.out.println("Informacion: Elemento "+ Str_Elemento + " esperando por XPath");
		return true;
	}

	// Click
	public boolean Click_ClassName()
	{
		//Encuentra el elemento por ClassName y le da click sobre el
		try
		{
			Obj_Driver.findElement(By.className(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00030: Error clickeando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensjae por consola indicando que se ha hecho click sobre el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por ClassName");
		return true;
	}

	public boolean Click_CssSelector()
	{
		// Hace click sobre el elemento encontrado por CssSelector
		try
		{
			Obj_Driver.findElement(By.cssSelector(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00031: Error clickeando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		// Mensaje por consola indicando que se ha hecho click sobre el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por CssSelector");
		return true;
	}

	public boolean Click_ID()
	{
		//Da click sobre el elemento encontrado por ID
		try
		{
			Obj_Driver.findElement(By.id(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00032: Error clickeando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho click en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por ID");
		return true;
	}

	public boolean Click_LinkText()
	{
		//Click en el elemento encontrado por LinkText
		try
		{
			Obj_Driver.findElement(By.linkText(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00033: Error clickeando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por LinkText");
		return true;
	}

	public boolean Click_Name()
	{
		//Click sobre el elemento encontrado por Name
		try
		{
			Obj_Driver.findElement(By.name(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00034: Error clickeando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que el elemento se ha hecho clic
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por Name");
		return true;
	}

	public boolean Click_PartialLinkText()
	{
		//Click sobre el elemento encontrado por PartialLinkTexto
		try
		{
			Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00035: Error clickeando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento.
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por PartialLinkText");
		return true;
	}

	public boolean Click_TagName()
	{
		//Click sobre el elemento encontrado por TagName
		try
		{
			Obj_Driver.findElement(By.tagName(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00036: Error clickeando elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por Tagname");
		return true;
	}

	public boolean Click_XPath_Generico()
	{
		//Click en el elemento encontrado por Xpath

		try
		{
			Obj_Driver.findElement(By.xpath(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00037: Error clickeando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por XPath");
		return true;
	}

	public boolean Click_ClassName(String Str_Elemento)
	{
		//Click en el elemento encontrado por ClassName
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.className(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00030: Error clickeando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho click sobre el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por ClassName");
		return true;
	}

	public boolean Click_CssSelector(String Str_Elemento)
	{
		//Click sobre el elemento encontrado por CssSelector
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.cssSelector(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00031: Error clickeando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por CssSelector");
		return true;
	}

	public boolean Click_ID(String Str_Elemento)
	{
		//CLick sobre el elemento encontrado por ID
		this.Str_Elemento = Str_Elemento;
			Obj_Driver.findElement(By.id(Str_Elemento)).click();
		return true;
	}

	public boolean Click_LinkText(String Str_Elemento)
	{
		// CLick sobre el elemento encontrado por LinkText
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.linkText(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00033: Error clickeando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho click 
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por LinkText");
		return true;
	}

	public boolean Click_Name(String Str_Elemento)
	{
		//Click en el elemento encontrado por Name
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.name(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00034: Error clickeando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha hecho click en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por Name");
		return true;
	}

	public boolean Click_PartialLinkText(String Str_Elemento)
	{
		//Click en elmenento encontrado por PartialLinkTxt 
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00035: Error clickeando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		//Mensaje por consola indicando que se ha dado clic en el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por PartialLinkText");
		return true;
	}

	public boolean Click_TagName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.tagName(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00036: Error clickeando elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por TagName");
		return true;
	}

	public boolean Click_Por_XPath(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.xpath(Str_Elemento)).click();
			Resultado_Positivo("Clickeado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00037: Error clickeando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " clickeando por XPath");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por ClassName
	public boolean Double_Click_ClassName(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.className(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00038: Error haciendo doble click al elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por ClassName");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por CssSelector
	public boolean Double_Click_CssSelector(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.cssSelector(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00039: Error haciendo doble click al elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por CssSelector");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por ID
	public boolean Double_Click_ID(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.id(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00040: Error haciendo doble click al elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por ID");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por LinkText
	public boolean Double_Click_LinkText(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.linkText(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00041: Error haciendo doble click al elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por LinkText");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por Name
	public boolean Double_Click_Name(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.name(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00042: Error haciendo doble click al elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por Name");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por PartialLinkText
	public boolean Double_Click_PartialLinkText(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.partialLinkText(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00043: Error haciendo doble click al elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por PartialLinkText");
		return true;
	}

	// Metodo que hace doble clic a un elemento, encontrandolo por Tagname
	public boolean Double_Click_Tagname(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.tagName(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00044: Error haciendo doble click al elemento "+ Str_Elemento +" por Tagname  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por Tagname");
		return true;
	}


	// Metodo que hace doble clic a un elemento, encontrandolo por Xpath
	public boolean Double_Click_XPath_Generico(String Str_Elemento)
	{
		/**	* @author Esteffany Garc�s R. */

		this.Str_Elemento = Str_Elemento;
		try
		{

			Obj_WebElement = Obj_Driver.findElement(By.xpath(Str_Elemento));

			Actions action = new Actions(Obj_Driver).doubleClick(Obj_WebElement);
			action.build().perform();

			Resultado_Positivo("Doble Click");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00045: Error haciendo doble click al elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Clikeado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " doble click por XPath");
		return true;
	}


	// M�todos para limpiar campos
	public boolean Limpiar_ClassName()
	{
		try
		{
			Obj_Driver.findElement(By.className(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00046: Error Limpiando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por ClassName");
		return true;
	}

	public boolean Limpiar_CssSelector()
	{
		try
		{
			Obj_Driver.findElement(By.cssSelector(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00047: Error Limpiando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por CssSelector");
		return true;
	}

	public boolean Limpiar_ID()
	{
		try
		{
			Obj_Driver.findElement(By.id(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00048: Error Limpiando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por ID");
		return true;
	}

	public boolean Limpiar_LinkText()
	{
		try
		{
			Obj_Driver.findElement(By.linkText(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00049: Error Limpiando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por LinkText");
		return true;
	}

	public boolean Limpiar_Name()
	{
		try
		{
			Obj_Driver.findElement(By.name(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00050: Error Limpiando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por Name");
		return true;
	}

	public boolean Limpiar_PartialLinkText()
	{
		try
		{
			Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00051: Error Limpiando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por PartialLinkText");
		return true;
	}

	public boolean Limpiar_TagName()
	{
		try
		{
			Obj_Driver.findElement(By.tagName(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00052: Error Limpiando elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por TagName");
		return true;
	}

	public boolean Limpiar_XPath_Generico()
	{
		try
		{
			Obj_Driver.findElement(By.xpath(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00053: Error Limpiando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por XPath");
		return true;
	}

	public boolean Limpiar_ClassName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.className(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00046: Error Limpiando elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por ClassName");
		return true;
	}

	public boolean Limpiar_CssSelector(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.cssSelector(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00047: Error Limpiando elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por CssSelector");
		return true;
	}

	public boolean Limpiar_ID(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.id(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00048: Error Limpiando elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por ID");
		return true;
	}

	public boolean Limpiar_LinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.linkText(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00049: Error Limpiando elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por LinkText");
		return true;
	}

	public boolean Limpiar_Name(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.name(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00050: Error Limpiando elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por Name");
		return true;
	}

	public boolean Limpiar_PartialLinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00051: Error Limpiando elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por PartialLinkText");
		return true;
	}

	public boolean Limpiar_TagName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.tagName(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00052: Error Limpiando elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por TagName");
		return true;
	}

	public boolean Limpiar_XPath_Generico(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Obj_Driver.findElement(By.xpath(Str_Elemento)).clear();
			Resultado_Positivo("Limpiado");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00053: Error Limpiando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Limpiado");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Limpiando por XPath");
		return true;
	}

	// M�todos para copiar texto en campos
	public boolean Copiar_ClassName()
	{
		try
		{
			Obj_Driver.findElement(By.className(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00054: Error Copiando en elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por ClassName");
		return true;
	}

	public boolean Copiar_CssSelector()
	{
		try
		{
			Obj_Driver.findElement(By.cssSelector(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00055: Error Copiando en elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por CssSelector");
		return true;
	}

	public boolean Copiar_ID()
	{
		try
		{
			Obj_Driver.findElement(By.id(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00056: Error Copiando en elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por ID");
		return true;
	}

	public boolean Copiar_LinkText()
	{
		try
		{
			Obj_Driver.findElement(By.linkText(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00057: Error Copiando en elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por LinkText");
		return true;
	}

	public boolean Copiar_Name()
	{
		try
		{
			Obj_Driver.findElement(By.name(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00058: Error Copiando en elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por Name");
		return true;
	}

	public boolean Copiar_PartialLinkText()
	{
		try
		{
			Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00059: Error Copiando en elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por PartialLinkText");
		return true;
	}

	public boolean Copiar_TagName()
	{
		try
		{
			Obj_Driver.findElement(By.tagName(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00060: Error Copiando en elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por TagName");
		return true;
	}

	public boolean Copiar_XPath_Generico()
	{
		try
		{
			Obj_Driver.findElement(By.xpath(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00061: Error Copiando en elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por XPath");
		return true;
	}

	public boolean Copiar_ClassName(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.className(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00054: Error Copiando en elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por ClassName");
		return true;
	}

	public boolean Copiar_CssSelector(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.cssSelector(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00055: Error Copiando en elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por CssSelector");
		return true;
	}

	public boolean Copiar_ID(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.id(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00056: Error Copiando en elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por ID");
		return true;
	}

	public boolean Copiar_LinkText(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.linkText(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00057: Error Copiando en elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por LinkText");
		return true;
	}

	public boolean Copiar_Name(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.name(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00058: Error Copiando en elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por Name");
		return true;
	}

	public boolean Copiar_PartialLinkText(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00059: Error Copiando en elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por PartialLinkText");
		return true;
	}

	public boolean Copiar_TagName(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.tagName(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00060: Error Copiando en elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por TagName");
		return true;
	}

	public boolean Copiar_XPath_Generico(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			Obj_Driver.findElement(By.xpath(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00061: Error Copiando en elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Se ha escrito sobre el");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por XPath");
		return true;
	}

	//Manipular Botones

	public boolean Manipular_Botones_ClassName()
	{
		if (!Encontrar_Elemento_ClassName())
		{
			return false;
		}
		else
		{
			if (!Click_ClassName())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_CssSelector()
	{
		if (!Encontrar_Elemento_CssSelector())
		{
			return false;
		}
		else
		{
			if (!Click_CssSelector())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_ID()
	{
		if (!Encontrar_Elemento_ID())
		{
			return false;	
		}
		else
		{
			if (!Click_ID())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_LinkText()
	{
		if (!Encontrar_Elemento_LinkText())
		{
			return false;
		}
		else
		{
			if (!Click_LinkText())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_Name()
	{
		if (!Encontrar_Elemento_Name())
		{
			return false;
		}
		else
		{
			if (!Click_Name())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_PartialLinkText()
	{
		if (!Encontrar_Elemento_PartialLinkText())
		{
			return false;
		}
		else
		{
			if (!Click_PartialLinkText())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_TagName()
	{
		if (!Encontrar_Elemento_TagName())
		{
			return false;
		}
		else
		{
			if (!Click_TagName())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_XPath()
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Click_XPath_Generico())
			{
				return false;
			}
		}
		return true;
	}



	public boolean Manipular_Botones_ClassName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_ClassName(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_ClassName(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_CssSelector(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_CssSelector(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_CssSelector(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_ID(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_ID(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_ID(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_LinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_LinkText(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_LinkText(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_Name(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_Name(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_Name(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_PartialLinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_PartialLinkText(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_PartialLinkText(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_TagName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_TagName(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Click_TagName(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_XPath(String Str_Elemento) 
	{
		this.Str_Elemento = Str_Elemento;
		if (!Encontrar_Elemento_XPath(Str_Elemento))
		{
			return false;
		}
		else
		{			

			if (!Click_Por_XPath(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	//**** M�TODO MANIPULAR BOTONES Y DAR DOBLE CLIC
	public boolean Manipular_Botones_XPath_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_XPath_Generico(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_ClassName_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_ClassName(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_CssSelector_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_CssSelector(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_ID_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_ID(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_LinkText_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_LinkText(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_Name_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_Name(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_PartialLinkText_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_PartialLinkText(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Botones_TagName_DoubleClick(String Str_Elemento)
	{
		if (!Encontrar_Elemento_XPath())
		{
			return false;
		}
		else
		{
			if (!Double_Click_Tagname(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}


	//Campos
	public boolean Manipular_Campos_ClassName()
	{
		if (!Manipular_Botones_ClassName())
		{
			return false;
		}
		else
		{
			if (!Copiar_ClassName())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_CssSelector()
	{
		if (!Manipular_Botones_CssSelector())
		{
			return false;
		}
		else
		{
			if (!Copiar_CssSelector())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_ID()
	{
		if (!Manipular_Botones_ID())
		{
			return false;
		}
		else
		{
			if (!Copiar_ID())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_LinkText()
	{
		if (!Manipular_Botones_LinkText())
		{
			return false;
		}
		else
		{
			if (!Copiar_LinkText())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_Name()
	{
		if (!Manipular_Botones_Name())
		{
			return false;
		}
		else
		{
			if (!Copiar_Name())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_PartialLinkText()
	{
		if (!Manipular_Botones_PartialLinkText())
		{
			return false;
		}
		else
		{
			if (!Copiar_PartialLinkText())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_TagName()
	{
		if (!Manipular_Botones_TagName())
		{
			return false;
		}
		else
		{
			if (!Copiar_TagName())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_XPath()
	{
		if (!Manipular_Botones_XPath())
		{
			return false;
		}
		else
		{
			if (!Copiar_XPath_Generico())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_ClassName(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_ClassName(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Copiar_ClassName(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_CssSelector(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_CssSelector(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Copiar_CssSelector(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_ID(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_ID(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Copiar_ID(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_LinkText(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_LinkText(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Copiar_LinkText(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_Name(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_Name(Str_Elemento))
		{

		}
		else
		{
			if (!Copiar_Name(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_PartialLinkText(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_PartialLinkText(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Copiar_PartialLinkText(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_TagName(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_TagName(Str_Elemento))
		{
			return false;
		}
		else
		{
			if (!Copiar_TagName(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Manipular_Campos_XPath(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (!Manipular_Botones_XPath(Str_Elemento))
		{
			return false;
		}
		else
		{
			Limpiar_XPath_Generico(Str_Elemento);
			if (!Copiar_XPath_Generico(Str_Elemento, Str_Texto))
			{
				return false;
			}
		}
		return true;
	}
	//Encontrar Elemento

	public boolean Encontrar_Elemento_ClassName()
	{
		if (!Esperar_ClassName())
		{
			return false;
		}
		else
		{
			if (!Encontrar_ClassName())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_CssSelector()
	{
		if (!Esperar_CssSelector())
		{
			return false;
		}
		else
		{
			if (!Encontrar_CssSelector())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_ID()
	{
		if (!Esperar_ID())
		{
			return false;
		}
		else
		{
			if (!Encontrar_ID())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_LinkText()
	{
		if (!Esperar_LinkText())
		{

		}
		else
		{
			if (!Encontrar_LinkText())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_Name()
	{
		if (!Esperar_Name())
		{

		}
		else
		{
			if (!Encontrar_Name())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_PartialLinkText()
	{
		if (!Esperar_PartialLinkText())
		{
			return false;
		}
		else
		{
			if (!Encontrar_PartialLinkText())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_TagName()
	{
		if (!Esperar_TagName())
		{
			return false;
		}
		else
		{
			if (!Encontrar_TagName())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_XPath()
	{
		if (!Esperar_XPath_Generico())
		{
			return false;
		}
		else
		{
			if (!Encontrar_XPath_Generico())
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_ClassName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_ClassName(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_ClassName(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_CssSelector(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_CssSelector(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_CssSelector(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_ID(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_ID(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_ID(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_LinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_LinkText(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_LinkText(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_Name(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_Name(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_Name(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_PartialLinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_PartialLinkText(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_PartialLinkText(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_TagName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_TagName(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_TagName(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}

	public boolean Encontrar_Elemento_XPath(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_XPath_Generico(Str_Elemento))
		{
			return false;

		}
		else
		{
			if (!Encontrar_XPath_Generico(Str_Elemento))
			{
				return false;
			}
		}
		return true;
	}


	public boolean Manipular_Botones_Exaustivo()
	{
		if (Manipular_Botones_ClassName())
		{


		}
		else
		{
			if (Manipular_Botones_CssSelector())
			{

			}
			else
			{
				if (Manipular_Botones_ID())
				{

				}
				else
				{
					if (Manipular_Botones_LinkText())
					{

					}
					else
					{
						if (Manipular_Botones_Name())
						{

						}
						else
						{
							if (Manipular_Botones_PartialLinkText())
							{

							}
							else
							{
								if (Manipular_Botones_TagName())
								{

								}
								else
								{
									if (Manipular_Botones_XPath())
									{

									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean Manipular_Botones_Exaustivo(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (Manipular_Botones_XPath(Str_Elemento))
		{

		}
		else
		{
			if (Manipular_Botones_CssSelector(Str_Elemento))
			{

			}
			else
			{
				if (Manipular_Botones_ID(Str_Elemento))
				{

				}
				else
				{
					if (Manipular_Botones_LinkText(Str_Elemento))
					{

					}
					else
					{
						if (Manipular_Botones_Name(Str_Elemento))
						{

						}
						else
						{
							if (Manipular_Botones_PartialLinkText(Str_Elemento))
							{

							}
							else
							{
								if (Manipular_Botones_TagName(Str_Elemento))
								{

								}
								else
								{
									if (Manipular_Botones_ClassName(Str_Elemento))
									{


									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean Manipular_Campos_Exaustivo()
	{
		if (Manipular_Campos_ClassName())
		{

		}
		else
		{
			if (Manipular_Campos_CssSelector())
			{

			}
			else
			{
				if (Manipular_Campos_ID())
				{

				}
				else
				{
					if (Manipular_Campos_LinkText())
					{

					}
					else
					{
						if (Manipular_Campos_Name())
						{

						}
						else
						{
							if (Manipular_Campos_PartialLinkText())
							{

							}
							else
							{
								if (Manipular_Campos_TagName())
								{

								}
								else
								{
									if (Manipular_Campos_XPath())
									{

									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean Manipular_Campos_Exaustivo(String Str_Elemento,String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		if (Manipular_Campos_ClassName(Str_Elemento, Str_Texto))
		{

		}
		else
		{
			if (Manipular_Campos_CssSelector(Str_Elemento, Str_Texto))
			{

			}
			else
			{
				if (Manipular_Campos_ID(Str_Elemento, Str_Texto))
				{

				}
				else
				{
					if (Manipular_Campos_LinkText(Str_Elemento, Str_Texto))
					{

					}
					else
					{
						if (Manipular_Campos_Name(Str_Elemento, Str_Texto))
						{

						}
						else
						{
							if (Manipular_Campos_PartialLinkText(Str_Elemento, Str_Texto))
							{

							}
							else
							{
								if (Manipular_Campos_TagName(Str_Elemento, Str_Texto))
								{

								}
								else
								{
									if (Manipular_Campos_XPath(Str_Elemento, Str_Texto))
									{

									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean Encontrar_Elementos_Exaustivo()
	{
		if (Encontrar_Elemento_ClassName())
		{

		}
		else
		{
			if (Encontrar_Elemento_CssSelector())
			{

			}
			else
			{
				if (Encontrar_Elemento_ID())
				{

				}
				else
				{
					if (Encontrar_Elemento_LinkText())
					{

					}
					else
					{
						if (Encontrar_Elemento_Name())
						{

						}
						else
						{
							if (Encontrar_Elemento_PartialLinkText())
							{

							}
							else
							{
								if (Encontrar_Elemento_TagName())
								{

								}
								else
								{
									if (Encontrar_Elemento_XPath())
									{

									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public boolean Encontrar_Elementos_Exaustivo(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (Encontrar_Elemento_ClassName(Str_Elemento))
		{

		}
		else
		{
			if (Encontrar_Elemento_CssSelector(Str_Elemento))
			{

			}
			else
			{
				if (Encontrar_Elemento_ID(Str_Elemento))
				{

				}
				else
				{
					if (Encontrar_Elemento_LinkText(Str_Elemento))
					{

					}
					else
					{
						if (Encontrar_Elemento_Name(Str_Elemento))
						{

						}
						else
						{
							if (Encontrar_Elemento_PartialLinkText(Str_Elemento))
							{

							}
							else
							{
								if (Encontrar_Elemento_TagName(Str_Elemento))
								{

								}
								else
								{
									if (Encontrar_Elemento_XPath(Str_Elemento))
									{

									}
									else
									{
										return false;
									}
								}
							}
						}
					}
				}
			}
		}
		return true;
	}

	public void Resultado_Positivo(String Str_Accion)
	{
		try
		{
			Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
			Str_Estado = "El elemento " + Str_Elemento + " fue " + Str_Accion +".";
			Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Estado, Str_Elemento);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00062): Error inesperado , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
		
		}
		
	}

	public boolean Resultado_Negativo(String Str_Accion)
	{
		try
		{
			Obj_Administrador_Evidencias.set_Obj_Driver(Obj_Driver);
			Str_Estado = "El elemento " + Str_Elemento + " NO fue " + Str_Accion +"!!!. " + Str_Error;
			Obj_Administrador_Evidencias.Eleccion_Evidencia(Int_Eleccion_Evidencias, Str_Estado, Str_Elemento);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00063): Error inesperado , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Destructor();
			return false;
		}
		return true;
	}

	//******* VALIDAR CAMPOS **************
	//Valor Campo
	public boolean Valor_Campo_ClassName()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.className(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00064: Error capturando el valor del elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ClassName");
		return true;
	}

	public boolean Valor_Campo_CssSelector()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00065: Error Capturando Valor elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por CssSelector");
		return true;
	}

	public boolean Valor_Campo_ID()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.id(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00066: Error Capturando Valor elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ID");
		return true;
	}

	public boolean Valor_Campo_LinkText()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.linkText(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00067: Error Capturando Valor elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por LinkText");
		return true;
	}

	public boolean Valor_Campo_Name()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.name(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00068: Error Capturando Valor elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por Name");
		return true;
	}

	public boolean Valor_Campo_PartialLinkText()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00069: Error Capturando Valor elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por PartialLinkText");
		return true;
	}

	public boolean Valor_Campo_TagName()
	{
		try
		{
			Str_Texto = Obj_Driver.findElement(By.tagName(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00070: Error Capturando Valor elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por Tagname");
		return true;
	}

	public boolean Valor_Campo_XPath_Generico()
	{

		try
		{
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_ClassName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.className(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00064: Error capturando el valor del elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ClassName");
		return true;
	}

	public boolean Valor_Campo_CssSelector(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00065: Error Capturando Valor elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por CssSelector");
		return true;
	}

	public boolean Valor_Campo_ID(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.id(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00066: Error Capturando Valor elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ID");
		return true;
	}

	public boolean Valor_Campo_LinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.linkText(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00067: Error Capturando Valor elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por LinkText");
		return true;
	}

	public boolean Valor_Campo_Name(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.name(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00068: Error Capturando Valor elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por Name");
		return true;
	}

	public boolean Valor_Campo_PartialLinkText(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00069: Error Capturando Valorelemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por PartialLinkText");
		return true;
	}

	public boolean Valor_Campo_TagName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.tagName(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00070: Error Capturando Valor elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por TagName");
		return true;
	}

	public boolean Valor_Campo_XPath_Generico(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getAttribute("value");
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	//**Captura dato de un elemento
	public String Obtiene_Valor_Campo_XPath(String Str_Elemento)
	{	
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return Str_Texto;

	}



	//** Captura dato y valida cuantos caracteres tiene
	public boolean IngresaTexto_Campo_ClassName_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_ClassName(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.className(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo contar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ClassName");
		return true;
	}

	public boolean IngresaTexto_Campo_CssSelector_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_CssSelector(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo contar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por CssSelector");
		return true;
	}

	public boolean IngresaTexto_Campo_ID_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_ID(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.id(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo cotnar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ID");
		return true;
	}

	public boolean IngresaTexto_Campo_LinkText_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_ID(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.linkText(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo cotnar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por LinkText");
		return true;
	}

	public boolean IngresaTexto_Campo_Name_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_Name(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.name(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo cotnar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por Name");
		return true;
	}

	public boolean IngresaTexto_Campo_PartialLinkText_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_PartialLinkText(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo cotnar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por PartialLinkText");
		return true;
	}

	public boolean IngresaTexto_Campo_TagName_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;			

			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_TagName(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.tagName(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo cotnar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por TagName");
		return true;
	}


	public boolean IngresaTexto_Campo_XPath_Generico_Exhaustivo(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar;	
			for (int i=1; i<=3;i++)
			{
				Manipular_Campos_XPath(Str_Elemento,Str_Texto);
				Str_Auxiliar = Obj_Driver.findElement(By.xpath(Str_Elemento)).getAttribute("value");
				if(Str_Auxiliar.length()>2) //Contar los caracteres
				{							
					i=3;	
				}	
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00083: Error No puedo contar caracteres e ingresar informaci�n al elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}


	//GetText
	public boolean Valor_Campo_XPath_Generico_Text(String Str_Elemento)
	{	
		this.Str_Elemento = Str_Elemento;
		try
		{				
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	///
	public String Valor_Campo_XPath_Text(String Str_Elemento)
	{	
		this.Str_Elemento = Str_Elemento;
		try
		{				
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return Str_Texto;
	}

	public boolean Valor_Campo_ClassName_Generico_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.className(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_CSSSelector_Generico_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_ID_Generico_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.id(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_LinkText_Generico_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.linkText(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_Name_Generico_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.name(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_PartialLinkText_Generico_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_TagName_Text(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.tagName(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	// *** Recibe como parametro el elemento y una cadena de Texto
	public boolean Valor_Campo_ClassName(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.className(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00064: Error capturando el valor del elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ClassName");
		return true;
	}

	public boolean Valor_Campo_CssSelector(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00065: Error Capturando Valor elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por CssSelector");
		return true;
	}

	public boolean Valor_Campo_ID(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.id(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00066: Error Capturando Valor elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por ID");
		return true;
	}

	public boolean Valor_Campo_LinkText(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.linkText(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00067: Error Capturando Valor elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por LinkText");
		return true;
	}

	public boolean Valor_Campo_Name(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.name(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00068: Error Capturando Valorelemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por Name");
		return true;
	}

	public boolean Valor_Campo_PartialLinkText(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00069: Error Capturando Valorelemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por PartialLinkText");
		return true;
	}

	public boolean Valor_Campo_TagName(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if (Obj_Driver.findElement(By.tagName(Str_Elemento)).getAttribute("value").equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00070: Error Capturando Valor elemento "+ Str_Elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por TagName");
		return true;
	}

	public boolean Valor_Campo_XPath_Generico(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			Encontrar_Elemento_XPath(Str_Elemento);

			String Str_Auxiliar = Obj_Driver.findElement(By.xpath(Str_Elemento)).getAttribute("value");
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Los textos son iguales: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}




		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	//Obtener el texto por GetText
	public boolean Valor_Campo_XPath_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			if(Encontrar_Elemento_XPath(Str_Elemento))
			{
				String Str_Auxiliar = Obj_Driver.findElement(By.xpath(Str_Elemento)).getText();
				if (Str_Auxiliar == null)
				{
					Str_Auxiliar = "";
				}
				if (Str_Auxiliar.equals(Str_Texto))
				{
					Resultado_Positivo("Los Textos son iguales: " + Str_Texto);
				}
				else
				{
					Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
					return false;
				}

			}

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_CSS_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_ClassName_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar = Obj_Driver.findElement(By.className(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_ID_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{				
			String Str_Auxiliar = Obj_Driver.findElement(By.id(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_LinkText_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar = Obj_Driver.findElement(By.linkText(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_Name_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar = Obj_Driver.findElement(By.name(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_PartialLinkText_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}

	public boolean Valor_Campo_Tagname_Generico_Text(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento; 
		this.Str_Texto = Str_Texto;
		try
		{
			String Str_Auxiliar = Obj_Driver.findElement(By.tagName(Str_Elemento)).getText();
			if (Str_Auxiliar == null)
			{
				Str_Auxiliar = "";
			}
			if (Str_Auxiliar.equals(Str_Texto))
			{
				Resultado_Positivo("Capturando Valor: " + Str_Texto);
			}
			else
			{
				Resultado_Negativo("Los textos son diferentes: " + Str_Texto);
				return false;
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");
			return false;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return true;
	}


	// Ubicar las coordenadas de un elemento y darle clic
	public void Ubicar_Elemento_Coordenadas_ClassName(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.className(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.className(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;

			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00087: Error Moviendo elemento "+ Str_Elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por ClassName");			

	}

	public void Ubicar_Elemento_Coordenadas_CssSelector(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.cssSelector(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;

			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00088: Error Moviendo elemento "+ Str_Elemento +" por CssSelector  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por CssSelector");					       
	}
	public void Ubicar_Elemento_Coordenadas_ID(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.id(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.id(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;

			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00089: Error Moviendo elemento "+ Str_Elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por CssSelector");					       
	}

	public void Ubicar_Elemento_Coordenadas_LinkText(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.linkText(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.linkText(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;

			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00090: Error Moviendo elemento "+ Str_Elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por LinkText");					       
	}

	public void Ubicar_Elemento_Coordenadas_Name(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.name(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.name(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;

			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00091: Error Moviendo elemento "+ Str_Elemento +" por Name  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por Name");					       
	}

	public void Ubicar_Elemento_Coordenadas_PartialLinkText(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.partialLinkText(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;



			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00092: Error Moviendo elemento "+ Str_Elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por Name");					       
	}

	public void Ubicar_Elemento_Coordenadas_Tagname(String Str_Elemento ) 
	{
		try
		{
			int xCoord = Obj_Driver.findElement(By.tagName(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.tagName(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord+50;
			int yCoord2=yCoord+140;

			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00093: Error Moviendo elemento "+ Str_Elemento +" por Tagname  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por Tagname");					       
	}

	public void Ubicar_Elemento_Coordenadas_Xpath(String Str_Elemento ) 
	{

		try
		{
			int xCoord = Obj_Driver.findElement(By.xpath(Str_Elemento)).getLocation().getX();
			int yCoord = Obj_Driver.findElement(By.xpath(Str_Elemento)).getLocation().getY();

			int xCoord2=xCoord + 50 ;
			int yCoord2=yCoord + 140 ;


			//int xCoord3 = Integer.parseInt (Obj_Driver.findElement(By.xpath("/html/body")).getAttribute("offsetX"));
			// int yCoord4 = Integer.parseInt( Obj_Driver.findElement(By.xpath("/html/body")).getAttribute("offsetY"));

			/*
			System.out.println(xCoord3);
			System.out.println(yCoord4);

			 */

			//WebElement element = driver.findElement(By.id("some_id")); int offsetTop = element.getAttribute("offsetTop");





			Robot robot = new Robot(); 
			robot.mouseMove(xCoord2, yCoord2);
			robot.delay(2000); 
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00094: Error Moviendo elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Error Moviendo elemento: ");

		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Moviendo por XPath");			

	}

	private void Destructor()
	{
		try
		{
			Obj_Administrador_Evidencias = null;
			Obj_WebElement = null;
			Obj_Driver.close();
			Obj_RemoteWDriver.close();
			Obj_RemoteWDriver.close();
			Obj_Driver.close();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (?????): " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	/////Metodo ANS
	public String  Valor_Campo_XPath_Text_ANS(String Str_Elemento)
	{	
		this.Str_Elemento = Str_Elemento;
		try
		{				
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getText();
			Resultado_Positivo("Capturando Valor: " + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00071: Error Capturando Valor elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Capturando Valor");
			return Str_Error;
		}
		System.out.println("Informacion: Elemento "+ Str_Elemento + " Capturando Valor por XPath");
		return Str_Texto;
	}

	public String Encontrar_XPath_ANS(String Str_Elemento)
	{
		//M�todo que recibe como p�rametro Str_Elemento y lo busca por Xpath
		this.Str_Elemento = Str_Elemento;
		try
		{
			Str_Texto = Obj_Driver.findElement(By.xpath(Str_Elemento)).getText();
			Resultado_Positivo("El Umbral es" + Str_Texto);
		}
		catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00021: Error encontrando elemento "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			Resultado_Negativo("Encontrado");
			return Str_Error;
		}
		//Mensaje por consola indicando que se ha encotrado el elemento
		System.out.println("Informacion: Elemento "+ Str_Elemento + " encontrado por XPath");
		return Str_Texto ;
	}

	public void Seleccionar_ListaDesplegable_ID(String Str_Elemento, String Str_opcion) throws MalformedURLException
	{
		try
		{			
			if(Esperar_ID( Str_Elemento)) // Espera el elemento
			{
				Select dropdown = new Select(Obj_Driver.findElement(By.id(Str_Elemento)));
				dropdown.selectByValue(Str_opcion);				
				//dropdown.selectByVisibleText(Str_opcion);

				System.out.println("Seleccionar Lista Desplegable");
			}						
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error Seleccionado Lista desplegable "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);

		}


	}
	
	public void Seleccionar_ListaDesplegable_Xpath_Tagname(String Str_Elemento, String Str_opcion) throws MalformedURLException
	{
		try
		{			
			if(Esperar_ID( Str_Elemento)) // Espera el elemento
			{
				Select dropdown = new Select(Obj_Driver.findElement(By.xpath(Str_Elemento)));
				dropdown.selectByVisibleText(Str_opcion);				
				//dropdown.selectByVisibleText(Str_opcion);

				System.out.println("Seleccionar Lista Desplegable");
			}						
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error="Error Seleccionado Lista desplegable "+ Str_Elemento +" por XPath  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);

		}


	}


	//M�todo encontrar elemento tipo WebElement

	public WebElement WebEle_Encontrar_Elemento_ID(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_ID(Str_Elemento))
		{


		}
		else
		{
			if (!Encontrar_ID(Str_Elemento))
			{

			}
		}
		return Obj_WebElement;

	}

	public WebElement WebEle_Encontrar_Elemento_Xpath(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_XPath_Generico(Str_Elemento))
		{


		}
		else
		{
			if (!Encontrar_XPath_Generico(Str_Elemento))
			{

			}
		}
		return Obj_WebElement;

	}

	public WebElement WebEle_Encontrar_Elemento_ClassName(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_ClassName(Str_Elemento))
		{


		}
		else
		{
			if (!Encontrar_ClassName(Str_Elemento))
			{

			}
		}
		return Obj_WebElement;

	}


	public WebElement WebEle_Encontrar_Elemento_CssSelector(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_CssSelector(Str_Elemento))
		{


		}
		else
		{
			if (!Encontrar_CssSelector(Str_Elemento))
			{

			}
		}
		return Obj_WebElement;

	}

	public WebElement WebEle_Encontrar_Elemento_PartialLink(String Str_Elemento)
	{
		this.Str_Elemento = Str_Elemento;
		if (!Esperar_PartialLinkText(Str_Elemento))
		{


		}
		else
		{
			if (!Encontrar_Elemento_PartialLinkText(Str_Elemento))
			{

			}
		}
		return Obj_WebElement;

	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

	public Object switchTo_Frame(String Str_Elemento) 
	{
		Obj_Driver.switchTo().frame(Str_Elemento);

		return null;
	}

	public Object switchTo_DefaultContent() 
	{
		Obj_Driver.switchTo().defaultContent();
		return null;
	}
	
	
	public boolean Copiar_ID2(String Str_Elemento, String Str_Texto)
	{
		this.Str_Elemento = Str_Elemento;
		this.Str_Texto = Str_Texto;
		
		Obj_Driver.findElement(By.id(Str_Elemento)).sendKeys(Str_Texto);
			Resultado_Positivo("Interactuado (Se ha escrito sobre el)");
			System.out.println("Informacion: Elemento "+ Str_Elemento + " escrito por ID");
		return true;
	}
	public void salirNavegador(){
		Obj_Driver.quit();
	}
	
	

	public void esperarSegundos(int segundos)
	{

		synchronized(Obj_Driver){
			try {
				Obj_Driver.wait(segundos * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


}
