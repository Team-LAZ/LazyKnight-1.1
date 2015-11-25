package com.laz.lazyknight.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

//https://github.com/Mrgfhci/LazyKnight-1.1/blob/master/core/src/com/laz/lazyknight/player/Knight.java

public class Knight {

    Stage stage;

    TextureAtlas taKnight;
    Image imgKnight;
    TextureRegion trCurrentFrame, trLeft[], trRight[];
    Animation aniKnight[];
    float fStateTime, fX, fY;
    int nDir, nState;

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

        trCurrentFrame = trRight[0]; //set the starting position as right

        aniKnight = new Animation[2];
        aniKnight[0] = new Animation(0.15f, trRight);
        aniKnight[1] = new Animation(0.15f, trLeft);

        fStateTime = 0f;
        fX = 0f;
        fY = Gdx.graphics.getHeight() / 2;
        nDir = 4; //character starts at rest
    }

    public void update() {
        fStateTime += Gdx.graphics.getDeltaTime();
        imgKnight.remove();

        if (nDir == 1) { //if right is pressed on dpad
            trCurrentFrame = aniKnight[0].getKeyFrame(fStateTime, true);
            nState = 1; //saves last direction
            fX += 5;
        } else if (nDir == 3) { //if left is pressed on dpad
            trCurrentFrame = aniKnight[1].getKeyFrame(fStateTime, true);
            nState = 3; //saves last direction
            fX -= 5;
        } else if (nDir == 4) { //if character isn't moving
            if (nState == 1) {
                trCurrentFrame = trRight[0]; //if last direction was right
            } else if (nState == 3) {
                trCurrentFrame = trLeft[0]; //if last direction was left
            }
        }

        imgKnight = new Image(trCurrentFrame);
        imgKnight.setPosition(fX, fY);
        stage.addActor(imgKnight);
    }

    public void attack() {
        System.out.println("ATTACK");
    }

    public void jump() {
        System.out.println("JUMP");
    }

    public void setDirection(int nDir) {
        this.nDir = nDir;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
