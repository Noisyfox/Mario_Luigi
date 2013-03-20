package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class World implements WorldEngineElement {
	public World(String id) {
		if (WorldEngine.mExternalId_world.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:World:Id:\"" + id
					+ "\" already exist!");
		}

		int iid = WorldEngine.mExternalId_world.size() + 1;
		WorldEngine.mExternalId_world.put(id, Integer.valueOf(id));
		WorldEngine.mInternalId_world.put(iid, this);
	}

	protected enum ScaleMode {
		adaptive, stretch
	}

	protected class View {
		float width = 0f;
		float height = 0f;
		ScaleMode scaleMode = ScaleMode.adaptive;
	}
	
	/***********************************************************************************/
	protected static void loadJSONData(JSONArray worldArray)throws JSONException{
		
	}

	@Override
	public WorldEngineElement inheritFrom(JSONObject data) throws JSONException {
		return null;
	}
	
	
}
