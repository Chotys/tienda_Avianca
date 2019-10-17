package Data;

	
public class FuenteExcel

	{

		private String ruta_excel;
		private String ext_excel;
		
		public FuenteExcel(){}
		
		public void cargaConfiguracionExcel(String ruta){
			ruta_excel = ruta;
			String [] tmp_ext_excel = ruta_excel.split("\\.");
			ext_excel = tmp_ext_excel[tmp_ext_excel.length-1];
		}
		
		public String getRutaExcel(){
			return this.ruta_excel;
		}
		
		public String getExtExcel(){
			return this.ext_excel;
		}
		

	}


