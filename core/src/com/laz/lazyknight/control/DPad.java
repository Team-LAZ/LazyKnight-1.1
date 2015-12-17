package com.laz.lazyknight.control;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.laz.lazyknight.actor.Knight;

public class DPad extends Button {

    public static Image imgOutline;
    TextureAtlas taDPad;
    Skin skDPad;
    ButtonStyle bsDPad;

    Knight knight;
    OrthographicCamera camera;

    public DPad(String sID, float fX, float fY) {
        setName(sID); //set id of each directional arrow
        setBounds(fX, fY, 75, 75); //x, y, width, height of directional arrows

        taDPad = new TextureAtlas("dpad.atlas");

        skDPad = new Skin();
        skDPad.addRegions(taDPad);

        bsDPad = new Button.ButtonStyle();
        bsDPad.up = skDPad.getDrawable(sID);
        setStyle(bsDPad);

        imgOutline = new Image(taDPad.findRegion("outline"));
        imgOutline.setPosition(15, 15);
    }

    @Override
    public void act(float fDelta) {
        if (isPressed() && getName().equals("left")) {
            knight.setDirection(0);
            if (knight.nBoundsX > -75) {
                camera.translate(-4, 0);
                knight.nBoundsX -= 1;
            }
        }

        if (isPressed() && getName().equals("right")) {
            knight.setDirection(1);
            if (knight.nBoundsX < 300) {
                camera.translate(4, 0);
                knight.nBoundsX += 1;
            }
        }
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public void setCamera(OrthographicCamera camera) {
        this.camera = camera;
    }
}
