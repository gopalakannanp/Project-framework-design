package com.hcv.utilities;

import java.io.File;

public class Filepath {
	
public static final File configpath = new File("src/com/hcv/testData/Config.Properties").getAbsoluteFile();
public static final File screenshot = new File("src/com/hcv/screenshots").getAbsoluteFile();
public static final File excelpath = new File("src/com/hcv/testData/testdata.xlsx").getAbsoluteFile();

public static final String chromedriver = new File("src/com/hcv/resources/chromedriver.exe").getAbsolutePath();
public static final String iedriver = new File("src/com/hcv/resources/IEDriverServer.exe").getAbsolutePath();
public static final String geckodriver = new File("src/com/hcv/resources/geckodriver.exe").getAbsolutePath();

}
