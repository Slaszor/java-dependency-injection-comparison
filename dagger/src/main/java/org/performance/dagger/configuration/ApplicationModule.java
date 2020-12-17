package org.performance.dagger.configuration;

import client.HttpClientWrapper;
import client.MockApiService;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    public HttpClientWrapper provideHttpClientWrapper(){
        return new HttpClientWrapper();
    }

    @Provides
    @Singleton
    public String provideServerUrl(){
        return "https://run.mocky.io/v3/bace37ce-aec7-45a3-b243-0a706383bd97";
    }

    @Provides
    @Singleton
    public MockApiService provideMockApiService(HttpClientWrapper httpClientWrapper, String serverUrl){
        return new MockApiService(httpClientWrapper, serverUrl);
    }

}
