package com.laz.lazyknight.control;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameButtons extends Button {

    TextureAtlas taGB;
    Skin skGB;
    ButtonStyle bsGB;

    public GameButtons(String sID, float fX, float fY) {
        setBounds(fX, fY, 80, 80); //x, y, width, height of buttons

        taGB = new TextureAtlas("buttons.atlas");

        skGB = new Skin();
        skGB.addRegions(taGB);

        bsGB = new ButtonStyle();
        bsGB.up = skGB.getDrawable(sID);
        setStyle(bsGB);
    }
}