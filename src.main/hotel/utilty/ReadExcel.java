package hotel.utilty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	private static final String filePath = Utilities.getPropertyValue("config\\config.properties", "TEST_DATA");	
	private FileInputStream ipStream=null;	
	private XSSFWorkbook wb = null;
	private XSSFSheet ws = null;
	
	public ReadExcel()
	{
			try {
				ipStream = new FileInputStream(filePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				wb = new XSSFWorkbook(ipStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ws = wb.getSheetAt(0);
			try {
				ipStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
	}
	
	private int getNoOfRows(String worksheet)
	{
		int sheetIndex = wb.getSheetIndex(worksheet);
		if(sheetIndex==-1)
			return 0;
		ws = wb.getSheetAt(sheetIndex);
		return ws.getLastRowNum() +1;
		
	}
	
	private int getNoOfCols(String worksheet)
	{
		int sheetIndex =  wb.getSheetIndex(worksheet);
		if(sheetIndex ==-1)
			return 0;
		ws = wb.getSheetAt(sheetIndex);
		return ws.getRow(0).getLastCellNum();
	}
	
	@SuppressWarnings("unused")
	private Object[][] getData(String worksheet)
	{
		int sheetIndex =  wb.getSheetIndex(worksheet);
		if(sheetIndex ==-1)
			return null;
		
		int noOfRows = getNoOfRows(worksheet);
		int noOfCols = getNoOfCols(worksheet);
		
		Object[][] data = new Object[noOfRows-1][noOfCols-2];
		
		for(int row =0;row<noOfRows;row++)
		{
			XSSFRow objRow = ws.getRow(row+1);
					
			for(int col=0;col<=noOfCols;col++)
			{
				if(objRow==null)
					data[row][col] = "";
				else
					{
						XSSFCell objCell = objRow.getCell(col);
						if(objCell==null)
							data[row][col] = "";
						else
							{
								data[row][col] = cellData(objCell);
							}
					}			
				
			}	
		
		}
		return data;
	}
		
	private String cellData(XSSFCell cell)
		{
			Object result;
			int type = cell.getCellType();
			switch (type)
			{
			case 1:
				result = cell.getNumericCellValue();
				break;
			case 3:
				result = cell.getStringCellValue();
				break;
			default:
				throw new RuntimeException("Unsupported Cell");					
			}
		return result.toString();
		}
	
	public String getCellData(String workSheet,String testCaseId, String colName)
	{
		//String strData;
		XSSFSheet objws = wb.getSheet(workSheet);
		int row = getRow(objws, testCaseId);
		int col = getCol(objws, colName);
		
		XSSFRow objRow = objws.getRow(row);
		XSSFCell objCell = objRow.getCell(col);
		if(objCell==null)
			return null;
		return objCell.getStringCellValue();		
		
	}

	private int getCol(XSSFSheet objWS,String colName)
	{
		int col = 0;
		XSSFRow objRow = objWS.getRow(0);
		
		for(;col<objWS.getRow(0).getLastCellNum();col++)
		{
			XSSFCell objCell = objRow.getCell(col);
			if(colName.equals(objCell.getStringCellValue().toString()))
			break;
		}
		return col;
	}
	private int getRow(XSSFSheet objWS, String testCaseId)
	{
		int row = 0;
		for(;row<objWS.getLastRowNum();row++)
		{
			XSSFRow objRow = objWS.getRow(row);
			XSSFCell objCell = objRow.getCell(0);			
			if(testCaseId.equals(objCell.getStringCellValue().toString()))
			 break;
		}
		return row;
	}
	
}
