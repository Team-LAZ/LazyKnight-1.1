package com.laz.lazyknight.actor;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameButtons extends Button {

    Rectangle recBounds;
    String sID;
    TextureAtlas taGB;
    Skin skGB;
    ButtonStyle bsGB;

    public GameButtons(Rectangle recBounds, String sID) {
        this.recBounds = recBounds;
        this.sID = sID;

        setWidth(recBounds.width);
        setHeight(recBounds.height);
        setBounds(recBounds.x, recBounds.y, recBounds.width, recBounds.height);

        taGB = new TextureAtlas("buttons.atlas");

        skGB = new Skin();
        skGB.addRegions(taGB);

        bsGB = new ButtonStyle();
        bsGB.up = skGB.getDrawable(sID);
        setStyle(bsGB);
    }
}