package dev.danodic.rushbeat.composing.example;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import dev.danodic.rushbeat.compositing.example.Example;

/**
 *
 * @author danodic
 */
public class Main {

    public static void main(String[] args) {
        new LwjglApplication(new Example(), getConfig());
    }

    private static LwjglApplicationConfiguration getConfig() {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1600;
        config.height = 900;
        return config;
    }
}
