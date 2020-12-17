package org.performance.dagger;

import client.HttpClientWrapper;
import client.MockApiService;

public class Servfice {

    public String ask(){
        MockApiService api = new MockApiService(new HttpClientWrapper(),
                "https://run.mocky.io/v3/bace37ce-aec7-45a3-b243-0a706383bd97");
        api.getObjects()
                .forEach(System.out::println);
    }
}
