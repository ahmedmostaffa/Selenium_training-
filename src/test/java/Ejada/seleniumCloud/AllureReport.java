package Ejada.seleniumCloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AllureReport {

	public static void generateAllureReport() throws IOException, InterruptedException {
		List<String> cmdCommands = new ArrayList<String>();
		cmdCommands.add("cmd.exe");
		cmdCommands.add("/c");
		cmdCommands.add("allure generate allure-results && allure open");
		try {
			// create the process
			ProcessBuilder processBuilder = new ProcessBuilder(cmdCommands);
			// setting up the directory
			processBuilder.directory(new File(System.getProperty("user.dir")));

			// checking the directory, on which currently
			System.out.println("directory: " + processBuilder.directory());
			// start our pipeline commands
			Process process = processBuilder.start();
			int exitCode = process.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("Program exited with code '" + exitCode + " '");
		} catch (Exception e) {
			e.fillInStackTrace();
		}

	}

}
