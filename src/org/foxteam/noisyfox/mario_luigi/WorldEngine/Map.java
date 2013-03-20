package org.foxteam.noisyfox.mario_luigi.WorldEngine;

public class Map {

	int width = 0;
	int height = 0;
	float tile_width = 0f;
	float tile_height = 0f;
	MapData mapData[][];

	public Map(String id) {
		if (WorldEngine.mExternalId_map.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:Map:Id:\"" + id
					+ "\" already exist!");
		}

		int iid = WorldEngine.mExternalId_map.size() + 1;
		WorldEngine.mExternalId_map.put(id, Integer.valueOf(id));
		WorldEngine.mInternalId_map.put(iid, this);
	}

	protected class MapData {
		Environment environment;
		Objects objects;
	}
}
