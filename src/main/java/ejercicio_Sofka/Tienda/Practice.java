package ejercicio_Sofka.Tienda;

import org.openqa.selenium.WebDriver;

import Data.AdminProperties;
import Framework.Cls_Cross_Browsing;

public class Practice {

	Cls_Cross_Browsing Obj_Cross_Browsing ;
	public static String Str_Error;	
	Actions actions;
	WebDriver Obj_Driver;

	//Variables
	String str_Btn_Women= "//div[@id='block_top_menu']/ul/li/a";
	String str_Btn_Product = "//div[@id='center_column']/ul/li/div/div/div/a/img";
	String str_Campo_Quantity = "//p[@id='quantity_wanted_p']/input";
	String str_Campo_Size = "//select[@id='group_1']";
	String str_Btn_Color = "//ul[@id='color_to_pick_list']/li[2]/a";
	String str_Add_Cart = "//div[3]/div/p/button/span";
	String str_Continue_Shopping = "//div[@id='layer_cart']/div/div[2]/div[4]/span/span";
	String str_Return_Index = "//div[@id='header_logo']/a/img";
	String str_Continue = "overridelink";


	public void cargarDriver(){
		Obj_Cross_Browsing = new Cls_Cross_Browsing();
		Obj_Cross_Browsing.Eleccion_Browser(AdminProperties.BROWSER,AdminProperties.LOG_OPTION);
		Obj_Driver = Obj_Cross_Browsing.get_Obj_Driver();
	}

	public void ingresarAplicacion(){
		try{
			Obj_Cross_Browsing.Abrir_Website(Obj_Driver, "http://automationpractice.com/index.php");			
			actions = new Actions(Obj_Cross_Browsing.get_Obj_Driver());
			actions.className = this.getClass().getSimpleName();
//			Obj_Driver.findElement(By.id(str_Continue)).click();
		}catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00007): Error inicializando el navegador , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	public void Anadir_Carrito(String str_Quantity, String str_Size){
		try{
			actions.clickByXpath(str_Btn_Women);
			actions.esperarSegundos(2);
			actions.clickByXpath(str_Btn_Product);
			actions.esperarSegundos(2);
			actions.clickByXpath(str_Campo_Quantity);
			actions.esperarSegundos(2);
			actions.TypeByXpath(str_Campo_Quantity, str_Quantity);
			actions.esperarSegundos(2);
			actions.clickByXpath(str_Campo_Size);
			actions.esperarSegundos(2);
			actions.SelectDropDownVALUEByXpath(Obj_Driver, str_Campo_Size, str_Size);
			actions.esperarSegundos(2);
			actions.clickByXpath(str_Btn_Color);
			actions.esperarSegundos(2);
			actions.clickByID(str_Continue_Shopping);
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
			Str_Error = "Error (000013): Error en cerrar pagina de bancos , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);	
		}
	}

	public void salir() throws InterruptedException{
		actions.esperarSegundos(10);
		Obj_Driver.quit();
	}
}
