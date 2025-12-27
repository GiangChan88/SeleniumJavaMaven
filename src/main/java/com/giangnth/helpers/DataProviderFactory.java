package com.giangnth.helpers;

import org.testng.annotations.DataProvider;

public class DataProviderFactory {
    @DataProvider(name = "loginDataCRM")
    public Object[][] getLoginDataCRM() {
        return new Object[][] {
                {"admin@example.com", 123456},
                {"admin@example.com", 1234}
        };
    }
}
