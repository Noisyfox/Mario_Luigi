package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import org.foxteam.noisyfox.FoxGaming.Core.FGDebug;
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
	protected static void loadJSONData(JSONArray dataArray)throws JSONException{
		if (dataArray == null || dataArray.length() == 0)
			return;
		
		int len = dataArray.length();
		for (int i = 0; i < len; i++) {
			JSONObject js_world_def = dataArray.getJSONObject(i);
			String world_id = js_world_def.optString("id");
			if (world_id.isEmpty()) {
				FGDebug.debug("Load world fail: missing id.");
				continue;
			}
			World world = new World(world_id);
		}
	}

	@Override
	public WorldEngineElement inheritFrom(JSONObject data) throws JSONException {
		return null;
	}
	
}
