package LearnUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig() {
		File src = new File("./Configurations/config2.properties");
	
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e) {
			System.out.println("Exception is " +e.getMessage());
		}
		
	}
	public String getApplicationURL() {
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getUserName() {
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getPassword() {
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getChromePath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getIEPath() {
		String ie = pro.getProperty("chromepath");
		return ie;
	}
	
	public String getFireFoxPath() {
		String fire = pro.getProperty("chromepath");
		return fire;
	}
	
}
