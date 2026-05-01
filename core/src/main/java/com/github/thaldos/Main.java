package com.github.thaldos;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.ScreenUtils;

public class Main extends Game {
    private Preferences preferences;
    public static final String PROJECT_NAME = "homme-ou-femme";

    @Override
    public void create() {
        Gdx.app.setLogLevel(Application.LOG_DEBUG);
        Gdx.app.log(PROJECT_NAME, "Ceci est un test de log");

        preferences = Gdx.app.getPreferences(PROJECT_NAME + "-settings");
        preferences.putString("test", "test valeur");
        preferences.flush();

        setScreen(new MainScreen());
    }

    @Override
    public void render() {
        // Reset screen colors :
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        // Run render() function of game screen :
        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (screen != null) {
            screen.dispose();
        }
    }
}
