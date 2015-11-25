package com.laz.lazyknight.player;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Fireball {

    public Image imgFireball;

    public Fireball() {
        imgFireball = new Image(new Texture("fireball.png"));
    }

    public void makeFireball() {
        System.out.println("MAGIC");
    }
}
