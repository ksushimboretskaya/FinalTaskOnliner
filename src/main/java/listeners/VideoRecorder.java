package listeners;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import webdriver.DriverManager;
import ws.schild.jave.*;

import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoRecorder {
    private final String RECORD_DIRECTORY = "videos\\";
    private ScreenRecorder screenRecorder;
    File newFileName = null;

    public void startRecording() {
        try {
            GraphicsConfiguration gc = GraphicsEnvironment
                    .getLocalGraphicsEnvironment().getDefaultScreenDevice()
                    .getDefaultConfiguration();
            File dir = new File(RECORD_DIRECTORY);
            org.openqa.selenium.Point point = DriverManager.getDriver().manage().window().getPosition();
            org.openqa.selenium.Dimension dimension = DriverManager.getDriver().manage().window().getSize();
            Rectangle rectangle = new Rectangle(point.x, point.y,
                    dimension.width, dimension.height);
            this.screenRecorder = new ScreenRecorder(gc, rectangle,
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey,
                            MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey,
                            ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey,
                            24, FrameRateKey, Rational.valueOf(15), QualityKey,
                            1.0f, KeyFrameIntervalKey, 15 * 60), new Format(
                    MediaTypeKey, MediaType.VIDEO, EncodingKey,
                    "black", FrameRateKey, Rational.valueOf(30)), null,
                    dir);
            this.screenRecorder.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public File stopRecording(String recordName) {
        try {
            this.screenRecorder.stop();
            if (recordName != null) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(
                        "yyyy-MM-dd HH.mm.ss");
                newFileName = new File(String.format("%s%s%s.mp4",
                        RECORD_DIRECTORY, recordName,
                        dateFormat.format(new Date())));
                this.screenRecorder.getCreatedMovieFiles().get(0)
                        .renameTo(newFileName);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return AviToMp4(newFileName);
    }

    public File AviToMp4(File file) {
        File source = new File(String.valueOf(file));
        File target = new File("videos\\mp4\\" + file);
        VideoAttributes video = new VideoAttributes();
        video.setCodec("libx264");
        video.setBitRate(3200000);
        video.setFrameRate(15);
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp4");
        attrs.setVideoAttributes(video);
        Encoder encoder = new Encoder();
        MultimediaObject multimediaObject = new MultimediaObject(source);
        try {
            encoder.encode(multimediaObject, target, attrs);
        } catch (IllegalArgumentException | EncoderException e) {
            e.printStackTrace();
        }
        return target;
    }
}