package org.performance.dagger;

import org.performance.dagger.configuration.ApplicationComponent;

public class Main {

    public static void main(String[] args) {
        ApplicationComponent component = ApplicationComponent.create();
        Service service = component.buildService();
        service.ask();
    }

}
