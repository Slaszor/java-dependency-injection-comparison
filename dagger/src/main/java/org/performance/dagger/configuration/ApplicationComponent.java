package org.performance.dagger.configuration;

import dagger.Component;
import org.performance.dagger.Service;

import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModules.class})
public interface ApplicationComponent {

    void inject();
}
