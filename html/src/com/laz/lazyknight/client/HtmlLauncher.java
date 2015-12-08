package com.laz.lazyknight.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.laz.lazyknight.LazyKnight;
import com.laz.lazyknight.util.Constants;

public class HtmlLauncher extends GwtApplication {

    @Override
    public GwtApplicationConfiguration getConfig() {
        return new GwtApplicationConfiguration(Constants.APP_WIDTH, Constants.APP_HEIGHT);
    }

    @Override
    public ApplicationListener getApplicationListener() {
        return new LazyKnight();
    }
}