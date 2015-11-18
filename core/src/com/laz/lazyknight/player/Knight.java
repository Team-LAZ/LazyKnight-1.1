package com.laz.lazyknight.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Knight {

    TextureAtlas taKnight;
    Image imgKnight;
    TextureRegion trCurrentFrame, trLeft[], trRight[];
    Animation aniLeft, aniRight;
    public float fStateTime, x, y;
    public boolean bLeft, bRight, bStop;

    public Knight() {
        taKnight = new TextureAtlas("knight.atlas");

        imgKnight = new Image();

        trCurrentFrame = new TextureRegion();
        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taKnight.findRegion("knightleft" + (i + 1));
            trRight[i] = taKnight.findRegion("knightright" + (i + 1));
        }

        aniLeft = new Animation(0.15f, trLeft);
        aniRight = new Animation(0.15f, trRight);

        fStateTime = 0f;
        y = Gdx.graphics.getHeight() / 2;
        bRight = true;
    }

    public void update(Stage stage) {
        fStateTime += Gdx.graphics.getDeltaTime();

        x = imgKnight.getX();

        imgKnight.remove();

        if (bRight) {
            if (bStop) {
                trCurrentFrame = trRight[0];
            } else {
                trCurrentFrame = aniRight.getKeyFrame(fStateTime, true);
            }
            x += 5;
        } else if (bLeft) {
            if (bStop) {
                trCurrentFrame = trLeft[0];
            } else {
                trCurrentFrame = aniLeft.getKeyFrame(fStateTime, true);
            }
            x -= 5;
        }

        imgKnight = new Image(trCurrentFrame);
        imgKnight.setPosition(x, y);

        stage.addActor(imgKnight);
    }
}
