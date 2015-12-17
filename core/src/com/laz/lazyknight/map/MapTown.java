package com.laz.lazyknight.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class MapTown {

    TiledMap tmTown;
    public TiledMapRenderer tmrTown;

    public MapTown() {
        tmTown = new TmxMapLoader().load("maptown.tmx");

        tmrTown = new OrthogonalTiledMapRenderer(tmTown);
    }
}
