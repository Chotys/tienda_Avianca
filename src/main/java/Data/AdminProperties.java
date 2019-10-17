package Data;

public class AdminProperties {

	ProjectProperties props;
	public static int BROWSER;
	public static String BROWSER_PATH;
	public static String EXCEL_PATH;
	public static int LOG_OPTION;
	public static String HTML_PATH;
	public static String TXT_PATH;
	public static String IMAGE_PATH;
	public static String[] DOCUMENT_VALUE;
	public static int WAIT_GUI;

	public AdminProperties(){
		this.props = new ProjectProperties();
	}

	public void cargaPropiedades(){
		this.props.leerArchivoPropiedades();
		BROWSER = valorPropiedadNumerico("automation.driver.browser");
		BROWSER_PATH = valorPropiedad("automation.driver.path");
		EXCEL_PATH = valorPropiedad("automation.file.excel");
		LOG_OPTION = valorPropiedadNumerico("automation.util.option");
		HTML_PATH = valorPropiedad("automation.util.html");
		TXT_PATH = valorPropiedad("automation.util.txt");
		IMAGE_PATH = valorPropiedad("automation.util.image");
		WAIT_GUI = valorPropiedadNumerico("automation.gui.wait");
		
	}
	public String valorPropiedad(String propiedad){
		return props.obtenerValorPropiedad(propiedad);
	}

	public int valorPropiedadNumerico(String propiedad){
		return Integer.parseInt(props.obtenerValorPropiedad(propiedad));
	}


}