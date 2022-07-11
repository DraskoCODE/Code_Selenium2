package com.company.provider;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;

public class ProductNameProvider {

    @DataProvider(name = "ProductNameProvider")
    public static Object[][] getProductNameProvider(){
        return new Object[][] {
                { "Samsung galaxy s6"},
                { "Sony xperia z5" }

        };
    }

    @DataProvider(name = "ProductNamesProvider")
    public static Object[][] getProductNamesProvider(){
        return new Object[][] {
                { "Samsung galaxy s6,Sony xperia z5,Nexus 6"}


        };
    }
}
