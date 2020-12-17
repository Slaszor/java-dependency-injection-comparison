package client;

import client.models.ResponseDto;
import com.google.gson.reflect.TypeToken;
import io.vavr.control.Try;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


public class MockApiService {

    private final HttpClientWrapper httpClientWrapper;
    private final String serverUrl;
    private final Type typeToken = new TypeToken<List<ResponseDto>>() {}.getType();

    public MockApiService(HttpClientWrapper httpClientWrapper, String serverUrl) {
        this.httpClientWrapper = httpClientWrapper;
        this.serverUrl = serverUrl;
    }

    public List<ResponseDto> getObjects() {
        return Try.of(() -> (httpClientWrapper.<List<ResponseDto>>sendRequest(serverUrl, typeToken)))
                .getOrElseGet(this::handleConnectionException);
    }

    private List<ResponseDto> handleConnectionException(Throwable throwable) {
        System.out.println("Can't query Configuration Manager for a map");
        return Collections.emptyList();
    }

}
