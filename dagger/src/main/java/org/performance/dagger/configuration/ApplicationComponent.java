package org.performance.dagger.configuration;

import dagger.Component;
import org.performance.dagger.Service;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {
    Service buildService();
}
