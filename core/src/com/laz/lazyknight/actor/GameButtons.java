package com.laz.lazyknight.actor;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameButtons extends Button {

    TextureAtlas taGB;
    Skin skGB;
    ButtonStyle bsGB;

    public GameButtons(String sID, float x, float y) {
        setName(sID); //set id of each button
        setBounds(x, y, 75, 75); //x, y, width, height of buttons

        taGB = new TextureAtlas("buttons.atlas");

        skGB = new Skin();
        skGB.addRegions(taGB);

        bsGB = new ButtonStyle();
        bsGB.up = skGB.getDrawable(sID);
        setStyle(bsGB);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isPressed()) {
            System.out.println(getName());
        }
    }
}