//package listeners;
//
//public class VideoRecorderManager {
//    private static final ThreadLocal<VideoRecorder> threadLocalVideoRecorder = new ThreadLocal<>();
//
//    public static VideoRecorder getVideoRecorder() {
//        if (threadLocalVideoRecorder.get() == null) {
//            threadLocalVideoRecorder.set(new VideoRecorder());
//        }
//        return threadLocalVideoRecorder.get();
//    }
//
//    public static void setVideoRecorder(VideoRecorder videoRecorder) {
//        threadLocalVideoRecorder.set(videoRecorder);
//    }
//}