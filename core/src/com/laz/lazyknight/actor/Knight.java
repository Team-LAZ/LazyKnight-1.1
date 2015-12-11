package com.laz.lazyknight.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.laz.lazyknight.util.Constants;

public class Knight extends Image {

    TextureAtlas taKnight;
    TextureRegion trFrame, trLeft[], trRight[];
    Animation aniKnight[];

    String sAction;
    float fX, fY, fWidth, fHeight, fStateTime;

    public Knight() {
        taKnight = new TextureAtlas("knight.atlas");

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taKnight.findRegion("left" + (i + 1));
            trRight[i] = taKnight.findRegion("right" + (i + 1));
        }
        trFrame = new TextureRegion(trRight[0]);

        aniKnight = new Animation[2];
        aniKnight[0] = new Animation(0.1f, trLeft);
        aniKnight[1] = new Animation(0.1f, trRight);

        fX = 100;
        fY = Constants.APP_HEIGHT / 2;
        fWidth = 90;
        fHeight = 90;
        fStateTime = 0f;
        sAction = "stop";
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        fStateTime += Gdx.graphics.getDeltaTime();

        if (sAction.equals("up")) {

        } else if (sAction.equals("down")) {

        } else if (sAction.equals("left")) {
            trFrame = aniKnight[0].getKeyFrame(fStateTime, true);
            fX -= 5;
        } else if (sAction.equals("right")) {
            trFrame = aniKnight[1].getKeyFrame(fStateTime, true);
            fX += 5;
        } else if (sAction.equals("stop")) {

        }
        batch.draw(trFrame, fX, fY, fWidth, fHeight);
    }
}