package org.performance.dagger;

import client.HttpClientWrapper;
import client.MockApiService;

public class Main {

    public static void main(String[] args) {
        Servfice servfice = new Servfice();
        servfice.ask();
    }
}
