package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import org.json.JSONException;
import org.json.JSONObject;

public interface WorldEngineElement {
	WorldEngineElement inheritFrom(JSONObject data)throws JSONException;
}
