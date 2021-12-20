package listeners;

import io.qameta.allure.Attachment;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import webdriver.DriverManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OnlinerTestListener implements ITestListener {
    public static final String LOGFILE_NAME = "logfile.log";
    private static final Logger logger = Logger.getLogger(OnlinerTestListener.class);
    private final VideoRecorder recorder = new VideoRecorder();

    @Attachment(value = "logfile", type = "text/plain")
    public static byte[] addFileToAllureReport() throws IOException {
        return Files.readAllBytes(Paths.get(LOGFILE_NAME));
    }

    @Attachment(value = "video", type = "video/mp4")
    public static byte[] addVideoToAllureReport(File file) throws IOException {
        return Files.readAllBytes(Paths.get(String.valueOf(file)));
    }

    public static void clearTheFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, false);
        PrintWriter printWriter = new PrintWriter(fileWriter, false);
        printWriter.flush();
        printWriter.close();
        printWriter.close();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " test case started");
        recorder.startRecording();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("The name of the testcase passed is :" + result.getName());
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("The name of the testcase failed is :" + result.getName());
        if (DriverManager.getDriver() != null) {
            System.out.println("Screenshot captured for test case:" + result.getName());
            saveScreenshotPNG();
        }
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.info("The name of the testcase skipped is :" + result.getName());
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("The name of the testcase failed but within success percentage is :" + result.getName());
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        logger.info("The name of the test failed with timeout is :" + result.getName());
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(result.getName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {
        try {
            clearTheFile(new File(LOGFILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}