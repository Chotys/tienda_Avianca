package ejercicio_Sofka.Tienda;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.Cls_Cross_Browsing;
import Framework.Cls_Log_Ejecucion;


public class Actions {

	WebDriver driver;
	JavascriptExecutor jse;
	public SimpleDateFormat Dt_Fecha, Dt_FechaCarpeta;
	public File Obj_Archivo;
	public File Obj_Carpeta;
	public String Str_Nombre_Archivo = "";
	public String Str_Fecha = "";
	public String Str_Ruta = "";
	public String Str_Error = "";
	public String Str_Ruta_ScreenShot = "";
	public String Str_lane = "_";
	public String Str_folder = "Evidencia de Ejecucion";
	public String Str_Exitoso = "Casos_Exitosos_";
	public String Str_Fallido = "Casos_Fallidos_";
	public String Str_Elemento = "";
	public String Str_Ruta2 = "";
	public String className;
	Cls_Cross_Browsing Obj_Cross_Browsing;
	Cls_Log_Ejecucion Obj_Log_Ejecucion;

	public Actions(WebDriver driver) {
		this.driver = driver;
	}

	//	public Cls_Cross_Browsing CrossBrowsing() {
	//		this.driver = CrossBrowsing().get_Obj_Driver();
	//		return Obj_Cross_Browsing;
	//	}

	public void set_Driver(WebDriver driver)
	{
		this.driver = driver;
	}

	public void maximizarVentana() {
		driver.manage().window().maximize();
	}

	public void salirNavegador(boolean status) {
		if(status=true){
			ResultSuccess();			
		}else{
			ResultFail();	
		}
		driver.quit();
	}


	/**
	 * Carga una nueva p�gina web en la ventana actual del navegador.
	 *
	 * @param url
	 */
	public boolean abrirUrl(String url) {
		try{
			driver.navigate().to(url);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00001: Error abriendo la URL: "+ url +" en el navegador" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ url + " clickeado por XPATH");
		return true;
	}


	//Metodos para realizar Click
	public boolean clickByXpath(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.xpath(elemento)).click();
			Str_Error="Clickeado elemento por XPATH =";
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00002: Error clickeando elemento "+ elemento +" por XPATH  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		Obj_Log_Ejecucion = new Cls_Log_Ejecucion();
		Obj_Log_Ejecucion.Registrar_Log_TXT(Str_Error,elemento);
		Obj_Log_Ejecucion.Registrar_Log_HTML(Str_Error,elemento);
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por XPATH");
		return true;
	}

	public boolean clickByCSS(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.cssSelector(elemento)).click(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00003: Error clickeando elemento "+ elemento +" por CSS  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por CSS");
		return true;
	}

	public boolean clickByName(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.name(elemento)).click();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00004: Error clickeando elemento "+ elemento +" por NAME  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por NAME");
		return true;
	}

	
	public boolean clickByID(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.id(elemento)).click();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00005: Error clickeando elemento "+ elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ID");
		return true;
	}

	public boolean clickByLink(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.linkText(elemento)).click();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00006: Error clickeando elemento "+ elemento +" por LINK  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por LINK");
		return true;
	}

	public boolean clickByPartialLink(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.partialLinkText(elemento)).click();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00007: Error clickeando elemento "+ elemento +" por PartialLink  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por PartialLink");
		return true;
	}

	public boolean clickByTagName(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.tagName(elemento)).click();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00008: Error clickeando elemento "+ elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por TagName");
		return true;
	}

	public boolean clickByClassName(String elemento) {
		this.Str_Elemento = elemento;
		try{
			ResultSuccess();
			driver.findElement(By.className(elemento)).click();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00009: Error clickeando elemento "+ elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ClassName");
		return true;
	}

	//ESCRIBIR 
	public boolean TypeByXpath(String elemento, String text) {
		this.Str_Elemento = elemento;
		try{
			System.out.println("driver: "+driver);
			driver.findElement(By.xpath(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00010: Error escribiendo en el elemento "+ elemento +" por XPATH  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por XPATH");
		return true;
	}

	public boolean TypeByCSS(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.cssSelector(elemento)).sendKeys(text); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00011: Error escribiendo en el elemento "+ elemento +" por CSS  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por CSS");
		return true;
	}

	public boolean TypeByName(String elemento, String text) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.name(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00012: Error escribiendo en el elemento "+ elemento +" por NAME  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por NAME");
		return true;
	}

	public boolean TypeByID(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.id(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00013: Error escribiendo en el elemento "+ elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ID");
		return true;
	}

	public boolean TypeByLink(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.linkText(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00014: Error escribiendo en el elemento "+ elemento +" por LINK  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por LINK");
		return true;
	}

	public boolean TypeByPartialLink(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.partialLinkText(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00015: Error escribiendo en el elemento "+ elemento +" por PartialLink  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por PartialLink");
		return true;
	}

	public boolean TypeByTagName(String elemento, String text) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.tagName(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00016: Error escribiendo en el elemento "+ elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por TagName");
		return true;
	}

	public boolean TypeClassName(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.className(elemento)).sendKeys(text);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00017: Error escribiendo en el elemento "+ elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ClassName");
		return true;
	}

	public boolean TypeByXpathWithCapture(String elemento, String text) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.xpath(elemento)).sendKeys(text);
			ResultSuccess();	
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00018: Error escribiendo en el elemento "+ elemento +" por XPATH  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por XPATH");
		return true;
	}
	public boolean TypeByCSSWithCapture(String elemento, String text) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.cssSelector(elemento)).sendKeys(text); 
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00019: Error escribiendo en el elemento "+ elemento +" por CSS  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por CSS");
		return true;
	}

	public boolean TypeByNameWithCapture(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.name(elemento)).sendKeys(text);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00020: Error escribiendo en el elemento "+ elemento +" por NAME  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por NAME");
		return true;
	}

	public boolean TypeByIDWithCapture(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.id(elemento)).sendKeys(text);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00021: Error escribiendo en el elemento "+ elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ID");
		return true;
	}

	public boolean TypeByLinkWithCapture(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.linkText(elemento)).sendKeys(text);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00022: Error escribiendo en el elemento "+ elemento +" por LINK  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por LINK");
		return true;
	}

	public boolean TypeByPartialLinkWithCapture(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.partialLinkText(elemento)).sendKeys(text);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00023: Error escribiendo en el elemento "+ elemento +" por PartialLink  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por PartialLink");
		return true;
	}

	public boolean TypeByTagNameWithCapture(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.tagName(elemento)).sendKeys(text);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00024: Error escribiendo en el elemento "+ elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por TagName");
		return true;
	}

	public boolean TypeClassNameWithCapture(String elemento, String text)  {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.className(elemento)).sendKeys(text);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00025: Error escribiendo en el elemento "+ elemento +" por ClassName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ClassName");
		return true;
	}

	//ESPERAR POR ...

	public void esperarSegundos(int segundos)
	{
		synchronized(driver){
			try {
				driver.wait(segundos * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String EsperarPorElementoNoSeaVisible(WebDriver driver, String XPath) {
		if ((driver == null) || (XPath == null) || XPath.isEmpty()) {

			return "Mal uso de la sentencia WaitforElementNotVisible()";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.invisibilityOfElementLocated(By
					.xpath(XPath)));
			return null;
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento.";
		}
	}
	public String EsperarPorElementoNoSeaVisibleTagName(WebDriver driver, String TagName) {
		if ((driver == null) || (TagName == null) || TagName.isEmpty()) {

			return "Mal uso de la sentencia WaitforElementNotVisible()";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.invisibilityOfElementLocated(By
					.tagName(TagName)));
			return null;
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento.";
		}
	}

	public String EsperarPorElementoSeaClickeableXpath(WebDriver driver, String XPath) {
		if ((driver == null) || (XPath == null) || XPath.isEmpty()) {

			return "Mal uso de la sentencia WaitforElementToBeClickeable";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));

			return null;
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento a clickear";
		}
	}

	public String EsperarPorElementoSeaClickeableTagName(WebDriver driver, String TagName) {
		if ((driver == null) || (TagName == null) || TagName.isEmpty()) {

			return "Mal uso de la sentencia WaitforElementToBeClickeable";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.elementToBeClickable(By.tagName(TagName)));

			return null;
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento a clickear";
		}
	}


	public String EsperarPorElementoVisible(WebDriver driver, String XPath) {
		if ((driver == null) || (XPath == null) || XPath.isEmpty()) {

			return "Mal uso de la sentencia WaitforElementVisible()";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath))); 
			return null;
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento.";
		}
	}

	public String EsperarPorElementoVisibleTagName(WebDriver driver, String TagName) {
		if ((driver == null) || (TagName == null) || TagName.isEmpty()) {

			return "Mal uso de la sentencia WaitforElementVisible()";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName(TagName))); 
			return null;
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento.";
		}
	}

	//Javascript
	public void ForzarClickJavascript(WebDriver driver, String Xpath){
		WebElement element = driver.findElement(By.xpath(Xpath));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public void ForzarTypeJavascript(WebDriver driver,String Xpath, String value) throws Exception{
		
	try {
		WebElement element = driver.findElement(By.xpath(Xpath));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='"+value+"'" , element);
		
	}catch(Exception Obj_Excepcion)
	{
		ResultFail();
		Str_Error = "Error 00090: Error Elemento: "+Xpath+" escribiendo Javascript" + Obj_Excepcion.getMessage();
		System.out.println(Str_Error);
		
	}
	//Mensaje por consola indicando que se ha escrito en el elemento
	System.out.println("Informacion: Elemento "+ Xpath + " clicleado por XPATH");
	
	}


	//Capturas de pantalla
	public static void GenerarCaptura(WebDriver webdriver,String fileWithPath) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File(fileWithPath);

		FileUtils.copyFile(SrcFile, DestFile);

	}

	public boolean ResultSuccess(){	
		try{		
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy");
			Dt_FechaCarpeta = new SimpleDateFormat("h:mm a");
			Str_Ruta = Dt_Fecha.format(new Date()) +"\\";
			Str_Ruta = Str_Ruta.replaceAll("-", "_");
			Str_Ruta2 = Str_Exitoso+className;
			Obj_Carpeta = new File(Str_folder, Str_Ruta+Str_Ruta2);
			if (!Obj_Carpeta.isDirectory())
			{
				Obj_Carpeta.mkdirs();
			}
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss mmm");	
			Str_Nombre_Archivo = className + Str_lane + Dt_Fecha.format(new Date());
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
			FileUtils.copyFile(srcFile, new File (Obj_Carpeta, Str_Nombre_Archivo + ".jpg"));
			Str_Nombre_Archivo = "";
		}
		catch(IOException e){
			e.printStackTrace();
			CloseCapture();
			return false;
		}
		return false;
	}

	public boolean ResultFail(){

		try{		
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy");
			Str_Ruta = Dt_Fecha.format(new Date()) +"\\";
			Str_Ruta = Str_Ruta.replaceAll("-", "_");
			Str_Ruta2 = Str_Fallido+className;
			Obj_Carpeta = new File(Str_folder, Str_Ruta+Str_Ruta2);
			if (!Obj_Carpeta.isDirectory())
			{
				Obj_Carpeta.mkdirs();
			}
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			Dt_Fecha = new SimpleDateFormat("dd-M-yyyy hh:mm:ss mmm");	
			Str_Nombre_Archivo = className + Str_lane + Dt_Fecha.format(new Date());
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll(":", "_");
			Str_Nombre_Archivo = Str_Nombre_Archivo.replaceAll("-", "_");
			FileUtils.copyFile(srcFile, new File (Obj_Carpeta, Str_Nombre_Archivo + ".jpg"));
			Str_Nombre_Archivo = "";
		}
		catch(IOException e){
			e.printStackTrace();
			CloseCapture();
			return false;
		}
		return false;
	}

	public void TakeScreenshot(WebDriver webdriver) throws Exception{
		try{
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			ResultFail();
			Str_Error = "Error 00068: No se pudo tomar la captura de pantalla" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	//Salir driver
	private void CloseCapture()
	{
		try
		{
			driver.close();
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (?????): " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}

	//SCROLLING
	public boolean ScrollingWebsiteByXpath(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.xpath(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00026: El elemento: "+ elemento +"por XPATH no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por XPATH");
		return true;
	}
	public boolean ScrollingWebsiteByClassName(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.className(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00027: El elemento: "+ elemento +"por CLASSNAME no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por CLASSNAME");
		return true;
	}
	public boolean ScrollingWebsiteByCSS(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.cssSelector(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00028: El elemento: "+ elemento +"por CSS no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por CSS");
		return true;
	}
	public boolean ScrollingWebsiteByID(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.id(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00029: El elemento: "+ elemento +"por ID no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por ID");
		return true;
	}
	public boolean ScrollingWebsiteByLinkText(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.linkText(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00030: El elemento: "+ elemento +"por LinkText no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por LinkText");
		return true;
	}
	public boolean ScrollingWebsiteByName(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.name(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00031: El elemento: "+ elemento +"por Name no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por Name");
		return true;
	}
	public boolean ScrollingWebsiteByPartialLinkText(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.partialLinkText(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00032: El elemento: "+ elemento +"por PartialLinkText no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por PartialLinkText");
		return true;
	}
	public boolean ScrollingWebsiteByTagName(WebDriver driver, String elemento)  {
		this.Str_Elemento = elemento;
		try{
			esperarSegundos(1);
			WebElement URL_demo = driver.findElement(By.tagName(elemento));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", URL_demo);
			ResultSuccess();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00033: El elemento: "+ elemento +"por TagName no se pudo identificar para hacer scroll" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Scroll de: "+ elemento + " realizado correctamente por TagName");
		return true;
	}

	//DROPDOWN
	public boolean SelectDropDownVALUEByXpath(WebDriver driver, String xpathElemento, String SeleccionarElementoDropdown )  {

		try{
			Select selection = new Select(driver.findElement(By.xpath(xpathElemento)));
			selection.selectByValue(SeleccionarElementoDropdown);

		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00034: No se pudo seleccionar el elemento del dropdown" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento seleccionado correctamente");
		return true;
	}

	public boolean SelectDropDownINDEXByXpath(WebDriver driver, String xpathElemento, int SeleccionarElementoDropdown )  {

		try{
			Select selection = new Select(driver.findElement(By.xpath(xpathElemento)));
			selection.selectByIndex(SeleccionarElementoDropdown);

		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00035: No se pudo seleccionar el elemento del dropdown" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento seleccionado correctamente");
		return true;
	}

	public boolean SelectDropDownTEXTByXpath(WebDriver driver, String xpathElemento, String SeleccionarElementoDropdown )  {

		try{
			Select selection = new Select(driver.findElement(By.xpath(xpathElemento)));
			selection.selectByVisibleText(SeleccionarElementoDropdown);

		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00036: No se pudo seleccionar el elemento del dropdown" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento seleccionado correctamente");
		return true;
	}

	public boolean SelectDropDownVALUEByID(WebDriver driver, String idElemento, String SeleccionarElementoDropdown )  {

		try{
			Select selection = new Select(driver.findElement(By.id(idElemento)));
			selection.selectByValue(SeleccionarElementoDropdown);

		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00037: No se pudo seleccionar el elemento del dropdown" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento seleccionado correctamente");
		return true;
	}

	public boolean SelectDropDownINDEXByID(WebDriver driver, String idElemento, int SeleccionarElementoDropdown )  {

		try{
			Select selection = new Select(driver.findElement(By.id(idElemento)));
			selection.selectByIndex(SeleccionarElementoDropdown);

		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00038: No se pudo seleccionar el elemento del dropdown" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento seleccionado correctamente");
		return true;
	}

	//Este metodo es para elementos con id NAME
	public boolean SelectDropDownTEXTByID(WebDriver driver, String idElemento, String SeleccionarElementoDropdown )  {

		try{
			Select selection = new Select(driver.findElement(By.id(idElemento)));
			selection.selectByVisibleText(SeleccionarElementoDropdown);

		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00039: No se pudo seleccionar el elemento del dropdown" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento seleccionado correctamente");
		return true;
	}


	//ENVIAR KEYS 
	public boolean TypeKeysByXpath(WebDriver driver, String Elemento, Keys KeysTosend )  {

		try{
			driver.findElement(By.xpath(Elemento)).sendKeys(KeysTosend);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00040: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}

	public boolean TypeKeysByXpath(WebDriver driver, String Elemento, Keys KeysTosend,String texto )  {

		try{
			driver.findElement(By.xpath(Elemento)).sendKeys(KeysTosend+texto);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00040: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByXpath(WebDriver driver, String Elemento, Keys KeysTosend, Keys KeysTosend2 )  {

		try{
			driver.findElement(By.xpath(Elemento)).sendKeys(KeysTosend,KeysTosend2);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00041: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByXpath(WebDriver driver, String Elemento, Keys KeysTosend, Keys KeysTosend2, Keys KeysTosend3 )  {

		try{
			driver.findElement(By.xpath(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00042: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByXpath(WebDriver driver, String Elemento, Keys KeysTosend,Keys KeysTosend2, Keys KeysTosend3, Keys KeysTosend4 )  {

		try{
			driver.findElement(By.xpath(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3,KeysTosend4);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00043: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByXpath(WebDriver driver, String Elemento, Keys KeysTosend,Keys KeysTosend2, Keys KeysTosend3, Keys KeysTosend4, Keys KeysTosend5 )  {

		try{
			driver.findElement(By.xpath(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3,KeysTosend4,KeysTosend5);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00044: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}

	public boolean TypeKeysByID(WebDriver driver, String Elemento, Keys KeysTosend )  {

		try{
			driver.findElement(By.id(Elemento)).sendKeys(KeysTosend);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00045: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByID(WebDriver driver, String Elemento, Keys KeysTosend, Keys KeysTosend2 )  {

		try{
			driver.findElement(By.id(Elemento)).sendKeys(KeysTosend,KeysTosend2);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00046: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByID(WebDriver driver, String Elemento, Keys KeysTosend, Keys KeysTosend2, Keys KeysTosend3 )  {

		try{
			driver.findElement(By.id(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00047: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByID(WebDriver driver, String Elemento, Keys KeysTosend,Keys KeysTosend2, Keys KeysTosend3, Keys KeysTosend4 )  {

		try{
			driver.findElement(By.id(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3,KeysTosend4);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00048: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByID(WebDriver driver, String Elemento, Keys KeysTosend,Keys KeysTosend2, Keys KeysTosend3, Keys KeysTosend4, Keys KeysTosend5 )  {

		try{
			driver.findElement(By.id(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3,KeysTosend4,KeysTosend5);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00049: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByCSS(WebDriver driver, String Elemento, Keys KeysTosend )  {

		try{
			driver.findElement(By.cssSelector(Elemento)).sendKeys(KeysTosend);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00050: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByCSS(WebDriver driver, String Elemento, Keys KeysTosend, Keys KeysTosend2 )  {

		try{
			driver.findElement(By.cssSelector(Elemento)).sendKeys(KeysTosend,KeysTosend2);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00051: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByCSS(WebDriver driver, String Elemento, Keys KeysTosend, Keys KeysTosend2, Keys KeysTosend3 )  {

		try{
			driver.findElement(By.cssSelector(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00052: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByCSS(WebDriver driver, String Elemento, Keys KeysTosend,Keys KeysTosend2, Keys KeysTosend3, Keys KeysTosend4 )  {

		try{
			driver.findElement(By.cssSelector(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3,KeysTosend4);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00053: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}
	public boolean TypeKeysByCSS(WebDriver driver, String Elemento, Keys KeysTosend,Keys KeysTosend2, Keys KeysTosend3, Keys KeysTosend4, Keys KeysTosend5 )  {

		try{
			driver.findElement(By.cssSelector(Elemento)).sendKeys(KeysTosend,KeysTosend2,KeysTosend3,KeysTosend4,KeysTosend5);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00054: No se pudo enviar la(s) tecla(s) seleccionada(s)" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento encontrado correctamente");
		return true;
	}

	public boolean Frame(WebDriver driver, String elemento)  {

		try{
			driver.switchTo().frame(elemento);
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00055: No se pudo identificar el Frame" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Frame encontrado correctamente");
		return true;
	}
	public boolean DefaultFrame(WebDriver driver)  {

		try{
			driver.switchTo().defaultContent();
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00056: No se pudo retornar al DefaultFrame" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: DefaultFrame retornado correctamente");
		return true;
	}


	/**
	 * Este metodo retorna un valor tipo String por lo cual se deberá crear una variable tipo String si se quiere usar en estructuras condicionales
	 * Ejemplo: String Example = actions.GetTextByXpath(value1, value2);
	 * if(Example == AnotherOne){}
	 * @param
	 */
	public String GetTextByXpath(WebDriver driver, String elemento)  {
		String ElementoTomado="";
		try{	
			WebElement mensajeWE = driver.findElement(By.xpath(elemento));
			System.out.println(mensajeWE);
			ElementoTomado = String.valueOf(mensajeWE.getText());
			System.out.println(ElementoTomado);

		}catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00057: No se tomar el texto por XPATH" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
		System.out.println("Informacion: GetText realizado correctamente");
		return ElementoTomado;
	}
	
	public String GetTextByXpathFirstElement(WebDriver driver, String elemento)  {
		String ElementoTomado="";
		try{	
			 Select comboBox = new Select(driver.findElement(By.xpath(elemento)));
					 ElementoTomado = comboBox.getFirstSelectedOption().getText();

		}catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00057: No se tomar el texto por XPATH" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
		System.out.println("Informacion: GetText realizado correctamente");
		return ElementoTomado;
	}
	
	public void WindowsMinimize(WebDriver driver)  {

		try{	
			driver.manage().window().setPosition(new Point(0, -1000));

		}catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00058: No se pudo minimizar el browser" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
		System.out.println("Informacion: Browser minimizado correctamente");

	}

	public void RefreshBrowser(WebDriver driver)  {

		try{	
			driver.navigate().refresh();			
		}catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00059: refrescar el browser" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
		System.out.println("Informacion: Browser actualizado correctamente");

	}

	public void WaitForTextByXpath2(WebDriver driver, String Elemento, String Texto){

		try{	
			WebDriverWait wait = new WebDriverWait(driver, 300);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(Elemento), Texto));	
		}catch(Exception Obj_Excepcion)
		{
			Str_Error="Error 00061: No se pudo encontrar el texto a identificar" + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
		System.out.println("Informacion: Texto encontrado correctamente");
	}
	public String WaitForTextByXpath(WebDriver driver, String Elemento, String label){

		if ((driver == null) || (Elemento == null) || Elemento.isEmpty()) {

			return "Mal uso de la sentencia WaitForTextIsPresent";
		}
		try {
			(new WebDriverWait(driver, 600)).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(Elemento),label));
		} catch (TimeoutException e) {
			return "Error al esperar por el elemento.";
		}
		return label;

	}

	//ESPERAR POR FRAME

	public String WaitAndJoinToFrame(WebDriver driver, String iFrame){
		if ((driver == null) || (iFrame == null) || iFrame.isEmpty()) {

			return "Mal uso de la sentencia frameToBeAvailableAndSwitchToIt";
		}
		try {
			(new WebDriverWait(driver, 300)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrame));
			return null;
		} catch (TimeoutException e) {
			return "Error entrando al iFrame.";
		}

	}

	//LIMPIAR CAMPOS
	public boolean ClearFieldsByXpath(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.xpath(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00061: Error clickeando elemento "+ elemento +" por XPATH  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por XPATH");
		return true;
	}

	public boolean ClearFieldsByClassname(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.className(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00062: Error clickeando elemento "+ elemento +" por Classname  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por Classname");
		return true;
	}

	public boolean ClearFieldsByCSS(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.cssSelector(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00063: Error clickeando elemento "+ elemento +" por CSS  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por CSS");
		return true;
	}

	public boolean ClearFieldsByID(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.id(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00064: Error clickeando elemento "+ elemento +" por ID  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por ID");
		return true;
	}

	public boolean ClearFieldsByLinktext(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.linkText(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00065: Error clickeando elemento "+ elemento +" por LinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por LinkText");
		return true;
	}

	public boolean ClearFieldsByName(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.name(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00066: Error clickeando elemento "+ elemento +" por NAME  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por NAME");
		return true;
	}

	public boolean ClearFieldsByPartialLinktext(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.partialLinkText(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00067: Error clickeando elemento "+ elemento +" por PartialLinkText  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por PartialLinkText");
		return true;
	}

	public boolean ClearFieldsByTagName(String elemento) {
		this.Str_Elemento = elemento;
		try{
			driver.findElement(By.tagName(elemento)).clear(); 
		}catch(Exception Obj_Excepcion)
		{
			// Registra en LOG el error generado al encontrar el elemento definido en la variable Str_Elemento
			Str_Error="Error 00068: Error clickeando elemento "+ elemento +" por TagName  , " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
			ResultFail();
			return false;
		}
		//Mensaje por consola indicando que se ha hecho clic en el elemento
		System.out.println("Informacion: Elemento "+ elemento + " clickeado por TagName");
		return true;
	}
}



