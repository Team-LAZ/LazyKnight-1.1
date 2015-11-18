package com.laz.lazyknight.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.laz.lazyknight.control.ActionButtons;
import com.laz.lazyknight.control.DPad;
import com.laz.lazyknight.player.Knight;

public class GameScreen extends Stage implements Screen {

    Game game;
    DPad dpad;
    Knight knight;
    ActionButtons buttons;

    OrthographicCamera camera;

    public GameScreen(Game game) {
        this.game = game;
        dpad = new DPad();
        knight = new Knight();
        buttons = new ActionButtons();

        camera = new OrthographicCamera();

        dpad.init(this);
        buttons.init(this);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        knight.update(this);
        dpad.update(knight);

        this.act(Gdx.graphics.getDeltaTime());
        this.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        this.dispose();
    }
}