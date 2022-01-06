//package listeners;
//
//import exceptions.VideoRecordException;
//import org.monte.media.Format;
//import org.monte.media.math.Rational;
//import org.monte.screenrecorder.ScreenRecorder;
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.Point;
//import webdriver.DriverManager;
//import ws.schild.jave.*;
//
//import java.awt.*;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import static org.monte.media.FormatKeys.*;
//import static org.monte.media.VideoFormatKeys.*;
//
//public class VideoRecorder {
//
//    private final String RECORD_DIRECTORY = "videos\\";
//    private static final Integer MOUSE_FRAME_RATE = 30;
//    private static final Float QUALITY_VALUE = 1.0f;
//    private static final Integer FRAME_INTERVAL_VALUE = 15 * 60;
//    private static final Integer SCREEN_FRAME_RATE = 15;
//    private static final Integer SCREEN_DEPTH_VALUE = 24;
//    private static final String MOUSE_COLOR = "black";
//
//    private ScreenRecorder screenRecorder;
//
//    public void startRecording() {
//        try {
//            GraphicsConfiguration graphicsConfiguration = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                    .getDefaultScreenDevice().getDefaultConfiguration();
//            File file = new File(RECORD_DIRECTORY);
//            Point point = DriverManager.getDriver().manage().window().getPosition();
//            Dimension dimension = DriverManager.getDriver().manage().window().getSize();
//            Rectangle rectangle = new Rectangle(point.x, point.y, dimension.width, dimension.height);
//            this.screenRecorder = new ScreenRecorder(graphicsConfiguration, rectangle,
//                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
//                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
//                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey, SCREEN_DEPTH_VALUE, FrameRateKey,
//                            Rational.valueOf(SCREEN_FRAME_RATE), QualityKey, QUALITY_VALUE, KeyFrameIntervalKey, FRAME_INTERVAL_VALUE),
//                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, MOUSE_COLOR, FrameRateKey, Rational.valueOf(MOUSE_FRAME_RATE)),
//                    null, file);
//            this.screenRecorder.start();
//        } catch (IOException | AWTException e) {
//            throw new VideoRecordException(e.getMessage());
//        }
//    }
//
//    public File stopRecording(String recordName) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss");
//        File convertedFile;
//        try {
//            this.screenRecorder.stop();
//            convertedFile = new File(String.format("%s%s%s.mp4", RECORD_DIRECTORY, recordName, dateFormat.format(new Date())));
//            this.screenRecorder.getCreatedMovieFiles().get(0).renameTo(convertedFile);
//        } catch (IOException e) {
//            throw new VideoRecordException("Unable to stop screen recorder: " + e.getMessage());
//        }
//        return AviToMp4(convertedFile);
//    }
//
//    public File AviToMp4(File file) {
//        File source = new File(String.valueOf(file));
//        File target = new File("videos\\mp4\\" + file);
//        VideoAttributes video = new VideoAttributes();
//        video.setCodec("libx264");
//        video.setBitRate(3200000);
//        video.setFrameRate(15);
//        EncodingAttributes attrs = new EncodingAttributes();
//        attrs.setFormat("mp4");
//        attrs.setVideoAttributes(video);
//        Encoder encoder = new Encoder();
//        MultimediaObject multimediaObject = new MultimediaObject(source);
//        try {
//            encoder.encode(multimediaObject, target, attrs);
//        } catch (EncoderException e) {
//            throw new VideoRecordException("Unable to encode file: " + e.getMessage());
//        }
//        return target;
//    }
//}