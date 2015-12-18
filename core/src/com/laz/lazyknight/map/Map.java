package com.laz.lazyknight.map;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class Map {

    TiledMap tmTown;
    public TiledMapRenderer tmrTown;
    public TiledMapTileLayer tmtlPortal;

    public Map() {
        tmTown = new TmxMapLoader().load("maptown.tmx");

        tmrTown = new OrthogonalTiledMapRenderer(tmTown);

        tmtlPortal = (TiledMapTileLayer) tmTown.getLayers().get("Portal");
    }
}
