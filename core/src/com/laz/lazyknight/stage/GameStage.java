package com.laz.lazyknight.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.actor.Knight;
import com.laz.lazyknight.control.DPad;
import com.laz.lazyknight.control.GameButtons;
import com.laz.lazyknight.map.Map;
import com.laz.lazyknight.util.Constants;

//https://github.com/wmora/martianrun/blob/master/core/src/com/gamestudio24/martianrun/stages/GameStage.java

public class GameStage extends Stage {

    OrthographicCamera camera;
    Map map;
    DPad dpad[];
    GameButtons gameButtons[];
    Knight knight;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, Constants.APP_WIDTH, Constants.APP_HEIGHT, new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT)));

        initCamera();
        initMap();
        initDPad();
        initButtons();
        initKnight();

        Gdx.input.setInputProcessor(this);
    }

    public void initCamera() {
        camera = new OrthographicCamera(Constants.APP_WIDTH, Constants.APP_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
    }

    public void initMap() {
        map = new Map();
    }

    public void initDPad() {
        dpad = new DPad[4];

        dpad[0] = new DPad("up", 55, 100);
        dpad[1] = new DPad("down", 55, 0);
        dpad[2] = new DPad("left", 0, 50);
        dpad[3] = new DPad("right", 105, 50);

        addActor(DPad.imgOutline);
        for (int i = 0; i < 4; i++) {
            addActor(dpad[i]);
        }
    }

    public void initButtons() {
        gameButtons = new GameButtons[3];

        gameButtons[0] = new GameButtons("attack", Constants.APP_WIDTH - 185, 25);
        gameButtons[1] = new GameButtons("magic", Constants.APP_WIDTH - 100, 75);
        gameButtons[2] = new GameButtons("jump", Constants.APP_WIDTH - 185, 115);

        addActor(gameButtons[0]);
        addActor(gameButtons[1]);
        addActor(gameButtons[2]);
    }

    public void initKnight() {
        knight = new Knight(Constants.APP_WIDTH / 2 - 90, Constants.APP_HEIGHT / 2 - 150, 90, 90);
        knight.setCamera(camera);
        knight.setMap(map);
        knight.setDPad(dpad[0], dpad[1], dpad[2], dpad[3]);
        addActor(knight);
    }

    public void updateMap() {
        camera.update();

        map.tmrTown.setView(camera);
        map.tmrTown.render();
    }
}