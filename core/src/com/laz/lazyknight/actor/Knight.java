package com.laz.lazyknight.actor;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Knight extends Image {

    TextureAtlas taKnight;
    TextureRegion trFrame, trLeft[], trRight[];
    Animation aniKnight[];
    float fX, fY, fWidth, fHeight, fStateTime;
    int nDir, nState;
    public int nBoundsX;

    public Knight(float fX, float fY, float fWidth, float fHeight) {
        this.fX = fX;
        this.fY = fY;
        this.fWidth = fWidth;
        this.fHeight = fHeight;

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

        fStateTime = 0;
        nDir = 1; //set default direction to right, TODO save / load from external file
        //nState = 1;
        nBoundsX = 0;
    }

    @Override
    public void act(float fDelta) {
        super.act(fDelta);
        fStateTime += fDelta;

        if (nDir == 0) {
            trFrame = aniKnight[0].getKeyFrame(fStateTime, true);
            nState = 0;
        } else if (nDir == 1) {
            trFrame = aniKnight[1].getKeyFrame(fStateTime, true);
            nState = 1;
        } else {
            if (nState == 0) {
                trFrame = trLeft[0];
            } else if (nState == 1) {
                trFrame = trRight[0];
            }
        }
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        super.draw(batch, fAlpha);
        batch.draw(trFrame, fX, fY, fWidth, fHeight);
    }

    public void setDirection(int nDir) {
        this.nDir = nDir;
    }
}