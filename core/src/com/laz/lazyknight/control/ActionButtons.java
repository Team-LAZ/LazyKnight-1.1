package com.laz.lazyknight.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.laz.lazyknight.player.Fireball;
import com.laz.lazyknight.player.Knight;

public class ActionButtons {

    Stage stage;
    Knight knight;
    Fireball fireball;

    TextureAtlas taActions;
    Skin skActions;
    String sActions[];
    Drawable drwActions[];
    ImageButtonStyle ibsActions[];
    ImageButton ibtnActions[];

    public ActionButtons() {
        taActions = new TextureAtlas("button.atlas");

        skActions = new Skin();
        skActions.addRegions(taActions);

        sActions = new String[]{"attack", "magic", "jump"};
        drwActions = new Drawable[3];
        ibsActions = new ImageButtonStyle[3];
        ibtnActions = new ImageButton[3];

        for (int i = 0; i < 3; i++) {
            skActions.add("" + i, new Sprite(taActions.createSprite(sActions[i])));
            drwActions[i] = skActions.getDrawable("" + i);
            ibsActions[i] = new ImageButtonStyle();
            ibsActions[i].imageUp = drwActions[i];
            ibtnActions[i] = new ImageButton(ibsActions[i]);
        }

        ibtnActions[0].setPosition(Gdx.graphics.getWidth() - 185, 25);
        ibtnActions[1].setPosition(Gdx.graphics.getWidth() - 100, 75);
        ibtnActions[2].setPosition(Gdx.graphics.getWidth() - 185, 115);

        check();
    }

    public void init() {
        for (int i = 0; i < 3; i++) {
            stage.addActor(ibtnActions[i]);
        }
    }

    public void check() {
        ibtnActions[0].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                knight.attack();
            }
        });

        ibtnActions[1].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                fireball.makeFireball();
            }
        });

        ibtnActions[2].addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                knight.jump();
            }
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public void setFireball(Fireball fireball) {
        this.fireball = fireball;
    }
}
