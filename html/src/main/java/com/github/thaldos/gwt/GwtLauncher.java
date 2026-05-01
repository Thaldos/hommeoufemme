package com.github.thaldos.gwt;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.github.thaldos.Main;

/** Launches the GWT application. */
public class GwtLauncher extends GwtApplication {
        @Override
        public GwtApplicationConfiguration getConfig () {
            // Resizable application, uses available space in browser with no padding:
            GwtApplicationConfiguration config = new GwtApplicationConfiguration(true);
            config.padVertical = 0;
            config.padHorizontal = 0;
            config.antialiasing = true;
            return config;
        }
        @Override
        public ApplicationListener createApplicationListener () {
            return new Main();
        }
}