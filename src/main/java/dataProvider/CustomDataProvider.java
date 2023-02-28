package dataProvider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	@DataProvider(name="LoginDetails")
	public static Object[][] getData()
	{
		Object[][] arr=ExcelReader.getDataFromSheet("Login");
		return arr;
	}

}
