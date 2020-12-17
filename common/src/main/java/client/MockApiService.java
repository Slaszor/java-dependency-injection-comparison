package client;

import client.models.ResponseDto;
import com.google.gson.reflect.TypeToken;
import io.vavr.control.Try;
import lombok.extern.log4j.Log4j2;

import java.lang.reflect.Type;
import java.util.*;

@Log4j2
public class MockApiService {

    private final HttpClientWrapper httpClientWrapper;
    private final String serverUrl;
    private final Type typeToken = new TypeToken<Map<Integer, ResponseDto>>() {}.getType();

    public MockApiService(HttpClientWrapper httpClientWrapper, String serverUrl) {
        this.httpClientWrapper = httpClientWrapper;
        this.serverUrl = serverUrl;
    }

    private List<ResponseDto> getObjects() {
        return Try.of(() -> (httpClientWrapper.<List<ResponseDto>>sendRequest(serverUrl, typeToken)))
                .getOrElseGet(this::handleConnectionException);
    }

    private List<ResponseDto> handleConnectionException(Throwable throwable) {
        log.error("Can't query Configuration Manager for a map", throwable);
        return Collections.emptyList();
    }

}
