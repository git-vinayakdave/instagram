package com.instagram;
import org.testng.TestNG;
import java.util.ArrayList;
import java.util.List;

public class MainTestRunner {

    public static void main(String[] args) {
        // Create an instance of TestNG
        TestNG testNG = new TestNG();

        // Create a list of String to hold the paths to your testng.xml files
        List<String> suiteFiles = new ArrayList<>();
        suiteFiles.add("local_testng.xml"); // Add your local testng.xml file
        // suiteFiles.add("remote_testng.xml"); // Add your remote testng.xml file if needed

        // Set the testng.xml files to be used by TestNG
        testNG.setTestSuites(suiteFiles);

        // Run the tests
        testNG.run();
    }
}
