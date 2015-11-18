package com.laz.lazyknight.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.laz.lazyknight.LazyKnight;

public class DesktopLauncher {

    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Lazy Knight - 1.1";
        config.width = 1280;
        config.height = 720;
        new LwjglApplication(new LazyKnight(), config);
    }
}
