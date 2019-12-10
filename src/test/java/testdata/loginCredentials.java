package testdata;

import org.testng.annotations.DataProvider;

public class loginCredentials {

    @DataProvider(name= "loginCredentials")
    public static Object[][] loginData(){
        return new Object[][]{
                {"shwethapissay@gmail.com", "pass123"}
        };
    }

}
