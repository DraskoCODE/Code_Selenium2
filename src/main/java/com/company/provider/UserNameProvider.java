package com.company.provider;

import org.testng.annotations.DataProvider;

public class UserNameProvider {

    @DataProvider(name = "UserNameProvider")
    public static Object[][] getDataFromDataprovider(){
        return new Object[][] {
                { "standard_user"},
                { "problem_user" },
                { "performance_glitch_user" }
        };
    }

}
