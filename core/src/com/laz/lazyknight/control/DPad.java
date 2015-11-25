package com.laz.lazyknight.control;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.laz.lazyknight.player.Knight;

public class DPad {

    Stage stage;
    Knight knight;

    TextureAtlas taDpad;
    Skin skDpad;
    Image imgOutline;
    String sDirections[];
    Drawable drwDpad[];
    ImageButtonStyle ibsDpad[];
    ImageButton ibtnDpad[];

    public DPad() {
        taDpad = new TextureAtlas("dpad.atlas");

        skDpad = new Skin();
        skDpad.addRegions(taDpad);

        imgOutline = new Image(new Sprite(taDpad.createSprite("outline")));
        imgOutline.setPosition(15, 15);

        sDirections = new String[]{"up", "right", "down", "left"};
        drwDpad = new Drawable[4];
        ibsDpad = new ImageButtonStyle[4];
        ibtnDpad = new ImageButton[4];

        for (int i = 0; i < 4; i++) {
            skDpad.add("" + i, new Sprite(taDpad.createSprite(sDirections[i])));
            drwDpad[i] = skDpad.getDrawable("" + i);
            ibsDpad[i] = new ImageButtonStyle();
            ibsDpad[i].imageUp = drwDpad[i];
            ibtnDpad[i] = new ImageButton(ibsDpad[i]);
        }

        ibtnDpad[0].setPosition(55, 100);
        ibtnDpad[1].setPosition(105, 50);
        ibtnDpad[2].setPosition(55, 0);
        ibtnDpad[3].setPosition(0, 50);
    }

    public void init() {
        stage.addActor(imgOutline);
        for (int i = 0; i < 4; i++) {
            stage.addActor(ibtnDpad[i]);
        }
    }

    public void update() {
        if (ibtnDpad[1].isPressed()) { //if right is pressed
            knight.setDirection(1);
        } else if (ibtnDpad[3].isPressed()) { //if left is pressed
            knight.setDirection(3);
        } else { //if nothing is pressed
            knight.setDirection(4);
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }
}
