package com.company.provider;

import org.testng.annotations.DataProvider;

public class InvalidUserName {

    @DataProvider(name = "NonValidUserNameProvider")
    public static Object[][] getNonValidUserNameDataprovider(){
        return new Object[][] {
                { "stefan"}
                //{ "andrijana" },
                //{ "sanja" }
        };
    }

}
