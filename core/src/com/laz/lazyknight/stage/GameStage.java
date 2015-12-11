package com.laz.lazyknight.stage;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.laz.lazyknight.actor.GameButtons;
import com.laz.lazyknight.actor.Knight;
import com.laz.lazyknight.util.Constants;

//https://github.com/wmora/martianrun/blob/master/core/src/com/gamestudio24/martianrun/stages/GameStage.java

public class GameStage extends Stage {

    private static final int VIEWPORT_WIDTH = Constants.APP_WIDTH;
    private static final int VIEWPORT_HEIGHT = Constants.APP_HEIGHT;

    OrthographicCamera camera;

    Knight knight;

    public GameStage() {
        super(new ScalingViewport(Scaling.stretch, VIEWPORT_WIDTH, VIEWPORT_HEIGHT, new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT)));

        initCamera();
        initButtons();
        initKnight();

        Gdx.input.setInputProcessor(this);
    }

    private void initCamera() {
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void initButtons() {
        String sID[] = {"up", "down", "left", "right", "jump", "attack", "magic"}; //button id's
        float fX[] = {55, 55, 0, 105, VIEWPORT_WIDTH - 185, VIEWPORT_WIDTH - 185, VIEWPORT_WIDTH - 100}; //button x's
        float fY[] = {100, 0, 50, 50, 115, 25, 75}; //button y's

        for (int i = 0; i < 7; i++) {
            addActor(new GameButtons(sID[i], fX[i], fY[i])); //creates all of the buttons (dpad and attack, magic, jump)
        }

        Image imgDPadOutline = new Image(new Texture("dpad_outline.png")); //outline around the dpad
        imgDPadOutline.setPosition(15, 15);
        addActor(imgDPadOutline);
    }

    private void initKnight() {
        knight = new Knight();
        addActor(knight);
    }
}