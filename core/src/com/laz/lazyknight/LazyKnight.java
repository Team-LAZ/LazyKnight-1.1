package com.laz.lazyknight;

import com.badlogic.gdx.Game;
import com.laz.lazyknight.screen.GameScreen;

public class LazyKnight extends Game {

    GameScreen gameScreen;

    @Override
    public void create() {
        gameScreen = new GameScreen(this);

        setScreen(gameScreen);
    }

    @Override
    public void render() {
        super.render();
    }
}
