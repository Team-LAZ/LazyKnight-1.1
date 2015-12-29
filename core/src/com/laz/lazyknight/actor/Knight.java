package com.laz.lazyknight.actor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.laz.lazyknight.control.DPad;
import com.laz.lazyknight.map.Map;

public class Knight extends Image {

    float fX, fY, fPosX, fPosY, fDir, fWidth, fHeight, fStateTime;
    TextureAtlas taKnight;
    TextureRegion trFrame, trLeft[], trRight[];
    Animation aniKnight[];
    OrthographicCamera camera;
    Map map;
    DPad up, down, left, right;

    public Knight(float fX, float fY, float fWidth, float fHeight) {
        this.fX = fX; //x position of knight
        this.fY = fY; //y position of knight
        this.fWidth = fWidth;
        this.fHeight = fHeight;
        fStateTime = 0;
        fDir = 1; //default direction set to right, TODO read from file
        fPosX = 0; //x position of camera, TODO read from file and move to better place (camera class? / map class?)
        fPosY = 0; //y position of camera, TODO read from file and move to better place (camera class? / map class?)

        taKnight = new TextureAtlas("knight.atlas");

        trLeft = new TextureRegion[3];
        trRight = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            trLeft[i] = taKnight.findRegion("left" + (i + 1)); //load left-facing images
            trRight[i] = taKnight.findRegion("right" + (i + 1)); //load right-facing images
        }
        trFrame = new TextureRegion(trRight[0]); //set default image, TODO read from file

        aniKnight = new Animation[2];
        aniKnight[0] = new Animation(0.1f, trLeft); //load left-facing animations
        aniKnight[1] = new Animation(0.1f, trRight); //load right-facing animations
    }

    @Override
    public void act(float fDelta) {
        if (up.isPressed()) {
            System.out.println("up");
        } else if (down.isPressed()) {
            System.out.println("down");
        } else if (left.isPressed()) {
            fDir = 0;
            trFrame = aniKnight[0].getKeyFrame(fStateTime, true);
            if (fPosX > -300) {
                fPosX -= 4;
                camera.translate(-4, 0);
            }
        } else if (right.isPressed()) {
            fDir = 1;
            trFrame = aniKnight[1].getKeyFrame(fStateTime, true);
            if (fPosX < 1200) {
                fPosX += 4;
                camera.translate(4, 0);
            }
        } else {
            if (fDir == 0) trFrame = trLeft[0];
            else if (fDir == 1) trFrame = trRight[0];
        }
    }

    @Override
    public void draw(Batch batch, float fAlpha) {
        batch.draw(trFrame, fX, fY, fWidth, fHeight); //update knight
        fStateTime += Gdx.graphics.getDeltaTime(); //update state time
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setDPad(DPad up, DPad down, DPad left, DPad right) {
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }
}