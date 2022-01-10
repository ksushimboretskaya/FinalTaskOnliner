package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;

public class JsonUtils {

    private static final Gson gson = new GsonBuilder().setLenient().create();

    public static <T> T readJsonSingleObject(String filepath, Class<T> className) {
        T obj;
        obj = gson.fromJson(new InputStreamReader(JsonUtils.class.getResourceAsStream(filepath)), className);
        return obj;
    }
}
