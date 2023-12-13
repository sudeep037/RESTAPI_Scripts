package UtilityFiles;

import org.testng.annotations.DataProvider;

public class dataProvider {

	@DataProvider(name="Data")
	public String [][] getAllData() throws Exception
	{
		String path = System.getProperty("user.dir")+"//testData//authorData.xlsx";
		ExcelUtility utility = new ExcelUtility(path);
		
		int rowCount = utility.getRowCount("Sheet1");
		int colCount = utility.getColumnCount("Sheet1", 1);
		
		String apiData[][] = new String[rowCount][colCount];
		
		for(int i = 1; i<=rowCount; i++)
		{
			for(int j = 0; j<colCount; j++)
			{
				apiData [i-1][j] = utility.getCellData("Sheet1", i, j);
			}
		}
		return apiData;
	}
	
	@DataProvider(name="authID")
	public String [] getUserNames() throws Exception
	{
		String path = System.getProperty("user.dir")+"//testData//authorData.xlsx";
		ExcelUtility utility = new ExcelUtility(path);
		
		int rowCount = utility.getRowCount("Sheet1");
		
		String apiData[] = new String [rowCount];
		
		for(int i = 1; i<=rowCount; i++)
		{
			apiData[i-1]=utility.getCellData("Sheet1", i, 1);
		}
		return apiData;
	}
}
