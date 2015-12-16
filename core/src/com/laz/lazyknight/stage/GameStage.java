package com.laz.lazyknight.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.actor.DPad;
import com.laz.lazyknight.actor.GameButtons;
import com.laz.lazyknight.actor.Knight;
import com.laz.lazyknight.util.Constants;

//https://github.com/wmora/martianrun/blob/master/core/src/com/gamestudio24/martianrun/stages/GameStage.java

public class GameStage extends Stage {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    OrthographicCamera camera;
    Knight knight;
    DPad dpad[];
    GameButtons gameButtons[];

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        initCamera();
        initKnight();
        initDPad();
        initButtons();

        Gdx.input.setInputProcessor(this);
    }

    private void initCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void initKnight() {
        knight = new Knight(100, VIEWPORT_HEIGHT / 2, 90, 90);
        addActor(knight);
    }

    public void initDPad() {
        dpad = new DPad[4];

        dpad[0] = new DPad("up", 55, 100);
        dpad[1] = new DPad("down", 55, 0);
        dpad[2] = new DPad("left", 0, 50);
        dpad[3] = new DPad("right", 105, 50);

        addActor(DPad.imgOutline);
        addActor(dpad[0]);
        addActor(dpad[1]);
        addActor(dpad[2]);
        addActor(dpad[3]);
    }

    private void initButtons() {
        gameButtons = new GameButtons[3];

        gameButtons[0] = new GameButtons("attack", VIEWPORT_WIDTH - 185, 25);
        gameButtons[1] = new GameButtons("magic", VIEWPORT_WIDTH - 100, 75);
        gameButtons[2] = new GameButtons("jump", VIEWPORT_WIDTH - 185, 115);

        addActor(gameButtons[0]);
        addActor(gameButtons[1]);
        addActor(gameButtons[2]);
    }
}