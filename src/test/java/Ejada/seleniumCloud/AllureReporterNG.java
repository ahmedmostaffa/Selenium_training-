package Ejada.seleniumCloud;


import com.google.common.collect.ImmutableMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class AllureReporterNG implements IReporter {
	private static Logger log=LogManager.getLogger();
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		try {
			generateAllureReport();
			log.info("generate allure report successfully");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("generate allure report has been failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
			log.error("generate allure report has been failed");
		}
	}

	 
	public static void generateAllureReport() throws IOException, InterruptedException {
		
		List<String> cmdCommands = new ArrayList<String>();
		cmdCommands.add("cmd.exe");
		cmdCommands.add("/c");
		cmdCommands.add("allure generate allure-results --clean -o allure-report && allure open");
		
		try {
			
			// create the process
			ProcessBuilder processBuilder = new ProcessBuilder(cmdCommands);
			// setting up the directory
			processBuilder.directory(new File(System.getProperty("user.dir")));
			// start our pipeline commands
			Process process = processBuilder.start();
			int exitCode=process.exitValue();
			log.info("allure report has been successfully generated with exit code"+ exitCode);
	
		} catch (Exception e) {
			e.fillInStackTrace();
		}

	}

}
