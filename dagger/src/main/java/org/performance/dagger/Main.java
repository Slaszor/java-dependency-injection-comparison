package org.performance.dagger;

import client.HttpClientWrapper;
import client.MockApiService;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        service.ask();

    }
}
