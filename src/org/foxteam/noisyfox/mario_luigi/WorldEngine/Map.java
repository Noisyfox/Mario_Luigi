package org.foxteam.noisyfox.mario_luigi.WorldEngine;

public class Map {

	int width = 0;
	int height = 0;
	float tile_width = 0f;
	float tile_height = 0f;
	MapData mapData[][];

	public Map(String id) {
		if (WordEngine.mExternalId_map.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:Map:Id:\"" + id
					+ "\" already exist!");
		}

		int iid = WordEngine.mExternalId_map.size() + 1;
		WordEngine.mExternalId_map.put(id, Integer.valueOf(id));
		WordEngine.mInternalId_map.put(iid, this);
	}

	protected class MapData {
		Environment environment;
		Objects objects;
	}
}
