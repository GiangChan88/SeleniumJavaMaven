package com.giangnth.data;

import com.giangnth.helpers.ExcelHelper;
import com.giangnth.models.LeadDTO;
import com.giangnth.models.LoginDTO;

public class LoginDataFactory {
    //Get 1 dòng data trong file excel được chỉ định
    public static LoginDTO getLoginDataFromExcel(int rowIndex) {

        ExcelHelper excel = new ExcelHelper();
        excel.setExcelFile("src/test/resources/testdata/DataCRM.xlsx", "Login");

        LoginDTO login = new LoginDTO();
        login.setEmail(excel.getCellData("Email", rowIndex));
        login.setPassword(excel.getCellData("Password", rowIndex));

        return login;
    }
}
