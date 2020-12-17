package org.performance.dagger;

import client.MockApiService;

import javax.inject.Inject;

public class Service {

    @Inject
    MockApiService mockApiService;

    public void ask(){
        mockApiService.getObjects()
                .forEach(System.out::println);
    }
}
