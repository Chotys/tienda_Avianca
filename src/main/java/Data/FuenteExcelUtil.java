package Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FuenteExcelUtil extends FuenteExcel{

	FileInputStream fis;
	File file;
	XSSFWorkbook libro_xlsx;
	XSSFSheet carga_hoja_xlsx;
	XSSFRow rowx;
	HSSFWorkbook libro_xls;
	HSSFSheet carga_hoja_xls;
	HSSFRow row;
	DataFormatter df;
	FormulaEvaluator formula;
	public int fila;
	public int columna;


	public void cargaArchivoExcel(String ruta){
		cargaConfiguracionExcel(ruta);
		cargaFileInput();
	}

	private void cargaFileInput(){
		try {
			file = new File(getRutaExcel());
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.out.println("Error [" + e.getMessage() + "]");
		}
	}

	private XSSFSheet leerArchivoExcelXlsx(int hoja){

		try {
			if(libro_xlsx == null){
				System.out.println("Cargando Libro xlsx...");
				libro_xlsx = new XSSFWorkbook(fis);
				System.out.println("Termino Libro xlsx...");
			}
			carga_hoja_xlsx = libro_xlsx.getSheetAt(hoja);
		} catch (IOException e) {
			System.out.println("Error [" + e.getMessage() + "]");
		}
		return carga_hoja_xlsx;

	}
	private HSSFSheet leerArchivoExcelXls (int hoja){
		try {
			if(libro_xls == null){
				System.out.println("Cargando Libro xls...");
				libro_xls = new HSSFWorkbook(fis);
				System.out.println("Termino Libro xls...");
			}
			carga_hoja_xls = libro_xls.getSheetAt(hoja);
		} catch (IOException e) {
			System.out.println("Error [" + e.getMessage() + "]");
		}
		return carga_hoja_xls;
	}

	private Object leerXlsPosicion(int x, int y){
		row = carga_hoja_xls.getRow(x);
		df = new DataFormatter();
		formula = libro_xls.getCreationHelper().createFormulaEvaluator();
		return df.formatCellValue(row.getCell(y),formula);
	}

	private Object leerXlsxPosicion(int x, int y){
		rowx = carga_hoja_xlsx.getRow(x);
		df = new DataFormatter();
		return df.formatCellValue(rowx.getCell(y));
	}

	public Object leerCeldaExcel(int hoja,int x,int y){
		Object objeto = null;

		if(getExtExcel().toLowerCase().equals("xlsx")){
			leerArchivoExcelXlsx(hoja);
			objeto = leerXlsxPosicion(x,y);
		}else if(getExtExcel().toLowerCase().equals("xls")){
			leerArchivoExcelXls(hoja);
			objeto = leerXlsPosicion(x,y);
		}else{
			System.out.println("No es un archivo excel");
		}

		return objeto;
	}

	public Object[][] leerArchivoExcel(int hoja,int x,int y){
		Object[][] objeto = new Object[x][y];
		for(int i = 1; i<x;i++){
			for(int j = 1; j<y;j++){
				objeto[i][j] = leerCeldaExcel(hoja,i, j);
			}
		}
		return objeto;
	}

	public Object[][] leerArchivoExcel(int hoja){
		Object[][] objeto = new Object[fila][columna];
		for(int i = 1; i<fila;i++){
			for(int j = 0; j<columna;j++){
				objeto[i][j] = leerCeldaExcel(hoja,i, j);
//				System.out.println("Objeto: "+objeto[i][j]);

			}
		}
		return objeto;
	}

	public void dimensionExcel(int hoja){
		if(getExtExcel().toLowerCase().equals("xlsx")){
			carga_hoja_xlsx = leerArchivoExcelXlsx(hoja);
			fila = carga_hoja_xlsx.getLastRowNum() + 1;
			columna = carga_hoja_xlsx.getRow(1).getLastCellNum();
		}else if(getExtExcel().toLowerCase().equals("xls")){
			HSSFSheet carga_hoja_xls = leerArchivoExcelXls(hoja);
			fila = carga_hoja_xls.getLastRowNum() + 1;
			columna = carga_hoja_xls.getRow(1).getLastCellNum();
		}else{
			System.out.println("No es un archivo excel");
		}
	}
}
