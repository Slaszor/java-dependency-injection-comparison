package org.performance.dagger.configuration;

import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModules.class})
public class ApplicationComponent {

    void inject();
}
