package ejercicio_Sofka.Tienda;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Data.AdminProperties;
import Framework.Cls_Cross_Browsing;
import Framework.Cls_Log_Ejecucion;

public class Avianca {

	Cls_Cross_Browsing Obj_Cross_Browsing ;
	Cls_Log_Ejecucion Obj_Log_Ejecucion;
	public static String Str_Error;	
	Actions actions;
	WebDriver Obj_Driver;

	//Variables
	String str_Campo_Desde = "//fieldset/div/div/div/label/div/input";
	String str_Campo_Hacia = "//div[2]/label/div/input";
	String str_Campo_FechaIda = "//div[2]/fieldset/div/div/div/label/div/input";
	String str_Campo_FechaRegreso = "//fieldset/div/div[2]/div/label/div/input";
	String str_Btn_Buscar = "//button[contains(.,'Buscar vuelos')]";
	String str_Continue = "overridelink";


	public void cargarDriver(){
		Obj_Cross_Browsing = new Cls_Cross_Browsing();
		Obj_Cross_Browsing.Eleccion_Browser(AdminProperties.BROWSER,AdminProperties.LOG_OPTION);
		Obj_Driver = Obj_Cross_Browsing.get_Obj_Driver();
	}

	public void ingresarAplicacion(){
		try{
			Obj_Cross_Browsing.Abrir_Website(Obj_Driver, "https://www.avianca.com/co/es/?gclid=Cj0KCQjwho7rBRDxARIsAJ5nhFoVKAK0HUbs3voWF8-LVgGkHJeLyEPyHdctGtZ8rPZh03oNugN2vLcaAs3eEALw_wcB&gclsrc=aw.ds");			
			actions = new Actions(Obj_Cross_Browsing.get_Obj_Driver());
			actions.className = this.getClass().getSimpleName();
//			Obj_Driver.findElement(By.id(str_Continue)).click();
		}catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00007): Error inicializando el navegador , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	public void Pedir_Vuelo(String str_Campo_Desde1, String str_Campo_Hacia1, String str_Campo_FechaIda1, String str_Campo_FechaRegreso1 ){
		try{
			
		
		
		actions.clickByXpath(str_Campo_Desde);
		actions.ForzarTypeJavascript(Obj_Driver, str_Campo_Desde, str_Campo_Desde1);
		
		actions.ClearFieldsByXpath(str_Campo_Hacia);
		actions.ForzarTypeJavascript(Obj_Driver, str_Campo_Hacia, str_Campo_Hacia1);
		
		actions.ClearFieldsByXpath(str_Campo_FechaIda);
		actions.ForzarTypeJavascript(Obj_Driver, str_Campo_FechaIda, str_Campo_FechaIda1);
		
		actions.ClearFieldsByXpath(str_Campo_FechaRegreso);
		actions.ForzarTypeJavascript(Obj_Driver, str_Campo_FechaRegreso, str_Campo_FechaRegreso1);
		
		actions.clickByXpath(str_Btn_Buscar);
		
		//Obj_Log_Ejecucion = new Cls_Log_Ejecucion();
		//Obj_Log_Ejecucion.Registrar_Log_TXT("Prueba", str_Campo_Desde, "C:\\Automatizacion\\Ejecucion\\Evidencias\\ScreenShot\\01_10_2019");
		//Obj_Log_Ejecucion.Registrar_Log_HTML("Prueba", str_Campo_Hacia, "prueba");
		
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00008): Error en el inicio de sesion , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	
	public void Cerrar_Pagina (){
		try{
			Obj_Driver.quit();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (000013): Error en cerrar pagina, " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	public void salir() throws InterruptedException{
		actions.esperarSegundos(10);
		Obj_Driver.quit();
	}
	
}
