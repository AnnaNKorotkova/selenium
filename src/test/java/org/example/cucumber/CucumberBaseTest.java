package org.example.cucumber;

import io.cucumber.java8.En;
import org.example.applicationtest.app.Application;

public class CucumberBaseTest implements En {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

    public CucumberBaseTest() {
        Before(1, () -> {
            if (tlApp.get() != null) {
                app = tlApp.get();
                return;
            }

            app = new Application();
            tlApp.set(app);

            Runtime.getRuntime().addShutdownHook(
                    new Thread(() -> {
                        app.quit();
                        app = null;
                    }));
        });

    }
}
