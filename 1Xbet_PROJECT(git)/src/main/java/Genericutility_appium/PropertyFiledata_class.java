package Genericutility_appium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFiledata_class {
public String getdatafromPF(String key) throws IOException
{
	FileInputStream fis=new FileInputStream("./src/main/resources/Coomondata_appium.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String data = pobj.getProperty(key);
	return data;

}

}
