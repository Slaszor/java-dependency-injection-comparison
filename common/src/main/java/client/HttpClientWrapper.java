package client;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.lang.reflect.Type;

public class HttpClientWrapper {

    private final OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
            .followRedirects(true)
            .build();

    private final Gson gson = new Gson();

    public <T> T sendRequest(String url, Type typeToken) throws IOException, NullPointerException {
        Response responseOK = okHttpClient.newCall(getRequestConfiguration(url)).execute();
        return gson.fromJson(responseOK.body().string(), typeToken);
    }

    private Request getRequestConfiguration(String url) {
        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }
}
