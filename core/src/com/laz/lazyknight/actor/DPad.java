package com.laz.lazyknight.actor;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class DPad extends Button {

    public static Image imgOutline;
    TextureAtlas taDPad;
    Skin skDPad;
    ButtonStyle bsDPad;

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
        if (isPressed()) {
            System.out.println(getName());
        }
    }
}
