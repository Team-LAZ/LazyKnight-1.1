package com.laz.lazyknight.control;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameButtons extends Button {

    TextureAtlas taGB;
    Skin skGB;
    ButtonStyle bsGB;

    public GameButtons(String sID, float fX, float fY) {
        setName(sID); //set id of each button
        setBounds(fX, fY, 80, 80); //x, y, width, height of buttons

        taGB = new TextureAtlas("buttons.atlas");

        skGB = new Skin();
        skGB.addRegions(taGB);

        bsGB = new ButtonStyle();
        bsGB.up = skGB.getDrawable(sID);
        setStyle(bsGB);

        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                System.out.println(getName());
            }
        });
    }
}