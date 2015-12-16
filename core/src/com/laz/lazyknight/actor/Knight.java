package com.laz.lazyknight.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Knight extends Image {

    TextureAtlas taKnight;
    TextureRegion trFrame, trKnight[];
    Animation aniKnight[];
    String sAction;
    float fX, fY, fWidth, fHeight, fStateTime;

    public Knight(float fX, float fY, float fWidth, float fHeight) {
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;

        taKnight = new TextureAtlas("knight.atlas");

        trKnight = new TextureRegion[6];
        for (int i = 0; i < 3; i++) {
            trKnight[i] = taKnight.findRegion("left" + (i + 1));
            trKnight[i] = taKnight.findRegion("right" + (i + 1));
        }
        trFrame = new TextureRegion(trKnight[1]);

        aniKnight = new Animation[2];
        aniKnight[0] = new Animation(0.1f, trKnight[0], trKnight[2], trKnight[4]);
        aniKnight[1] = new Animation(0.1f, trKnight[1], trKnight[3], trKnight[5]);

        fStateTime = 0;
        sAction = "stop";
    }

    @Override
    public void act(float fDelta) {
        super.act(fDelta);
        //System.out.println(sAction);
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        super.draw(batch, fAlpha);
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

    public void setAction(String sAction) {
        this.sAction = sAction;
    }
}