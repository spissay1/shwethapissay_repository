package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    Properties prop;

     public ConfigFileReader(){
        String configFileName = "testdata.properties";
        FileInputStream inputFileStream = null;
         this.prop = new Properties();
        String configFilePath = System.getProperty("user.dir")+ "/" + "src/main/resources/config" + "/" + configFileName;

        try{
            inputFileStream = new FileInputStream(configFilePath);
            prop.load(inputFileStream);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }

     }
      public String getProperty(String propertyName)  {
         return this.prop.getProperty(propertyName);

      }
}
