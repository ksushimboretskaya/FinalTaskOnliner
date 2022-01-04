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
        logger.info(String.format("Test [%s] has started", result.getName()));
        recorder.startRecording();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test [%s] has passed", testName));
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            logger.error("Unable to add file: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test [%s] has failed", testName));
        if (DriverManager.getDriver() != null) {
            saveScreenshotPNG();
        }
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            logger.error("Unable to add file: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test [%s] has skipped", testName));
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            logger.debug("Unable to add file: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test [%s] has failed but within success percentage", testName));
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            logger.error("Unable to add file: " + e.getMessage());
        }
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        String testName = result.getName();
        logger.info(String.format("Test[%s] has failed with timeout", testName));
        try {
            addFileToAllureReport();
            addVideoToAllureReport(recorder.stopRecording(testName));
        } catch (IOException e) {
            logger.error("Unable to add file: " + e.getMessage());
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