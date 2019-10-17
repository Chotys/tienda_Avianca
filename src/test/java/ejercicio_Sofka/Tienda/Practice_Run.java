package ejercicio_Sofka.Tienda;

import Data.AdminProperties;
import Data.FuenteExcelUtil;

public class Practice_Run {

	public static String Str_Error;	
	
	FuenteExcelUtil excel;
	Object[][] datos;
	int x_l,y_l,x_c,y_c;
	AdminProperties props;
	Practice Obj_CP9;
    Actions actions;

	public void cargarDatos(){
		props = new AdminProperties();
		Obj_CP9 = new Practice();
		props.cargaPropiedades();
		System.out.println("Inicio Carga Excel");
		excel = new FuenteExcelUtil();
		excel.cargaArchivoExcel(AdminProperties.EXCEL_PATH);
		excel.dimensionExcel(0);
		datos = excel.leerArchivoExcel(0);
		x_l = excel.fila;
		y_l = excel.columna;
	}
	
	public void Ejecutar_Caso9()
	{
		try
		{
			cargarDatos();
			for(int i = 2;i<x_l;i++){
				if(!datos[i][0].toString().trim().equals("")){
					Obj_CP9.cargarDriver();
					Obj_CP9.ingresarAplicacion();
					Obj_CP9.Anadir_Carrito(datos[i][0].toString(), datos[i][1].toString());
					Obj_CP9.Cerrar_Pagina();
				}else{
					Obj_CP9.salir();
				}
			}
		}
		catch(Exception Obj_Excepcion)
		{
			Str_Error = "Error (00062): Error al ejecutar la clase Run. " + Obj_Excepcion.getMessage();
			System.out.println(Str_Error);
		}
	}
}
	
