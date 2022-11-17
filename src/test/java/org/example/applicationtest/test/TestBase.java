package org.example.applicationtest.test;

import org.example.applicationtest.app.Application;
import org.junit.jupiter.api.BeforeAll;


public class TestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public static Application app;

    @BeforeAll
    public static void start() {
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
    }

}
