package com.giangnth.data_provider;

import com.giangnth.helpers.ExcelHelper;
import com.giangnth.helpers.SystemHelper;
import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "loginDataCRM")
    public Object[][] getLoginDataCRM() {
        return new Object[][] {
                {"admin@example.com", 123456},
                {"admin@example.com", 1234}
        };
    }

    //Đọc data lấy khoảng dòng dữ liệu trong sheet từ Excel file
    @DataProvider(name = "data_provider_login_excel_hashtable")
    public Object[][] dataLoginHRMFromExcelHashtable() {
        ExcelHelper excelHelper = new ExcelHelper();
        Object[][] data = excelHelper.getDataHashTable(SystemHelper.getCurrentDir() + "src/test/resources/testdata/DataCRM.xlsx", "Login", 1, 2);
        System.out.println("Login Data from Excel: " + data);
        return data;
    }

//    @Test(priority = 1, dataProvider = "data_provider_login_excel_hashtable", dataProviderClass = DataProviderFactory.class)
//    public void testLoginFromDataProviderExcelHashtable(Hashtable < String, String > data) {
//        loginPage.logIn(data.get("username"), data.get("password"));
//    }

}
