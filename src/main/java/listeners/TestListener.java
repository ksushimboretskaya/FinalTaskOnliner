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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestListener implements ITestListener {

    private static final String LOGFILE_NAME = "logfile.log";
    private static final Logger logger = Logger.getLogger("Test listener logger");
    private final VideoRecorder recorder = new VideoRecorder();
    private String testName;

    @Attachment(value = "logfile", type = "text/plain")
    public static byte[] addFileToAllureReport() throws IOException {
        return Files.readAllBytes(Paths.get(LOGFILE_NAME));
    }

    @Attachment(value = "video", type = "video/mp4")
    public static byte[] addVideoToAllureReport(File file) throws IOException {
        return Files.readAllBytes(Paths.get(String.valueOf(file)));
    }

    @Override
    public void onTestStart(ITestResult result) {
        testName = result.getName();
        logger.info("Test [" + testName + "] has started");
        recorder.startRecording();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testName = result.getName();
        logger.info("Test [" + testName + "] has passed");
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testName = result.getName();
        logger.info("Test [" + testName + "] has failed");
        if (DriverManager.getDriver() != null) {
            saveScreenshotPNG();
        }
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testName = result.getName();
        logger.info("Test [" + testName + "] has skipped");
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        testName = result.getName();
        logger.info("Test [" + testName + "] has failed but within success percentage");
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        testName = result.getName();
        logger.info("Test[" + testName + "] has failed with timeout");
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}