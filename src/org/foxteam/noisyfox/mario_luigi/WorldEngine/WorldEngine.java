package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.SparseArray;

public class WorldEngine {

	protected static HashMap<String, Integer> mExternalId_world = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_environment = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_objects = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_trigger = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_sky = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_map = new HashMap<String, Integer>();

	protected static SparseArray<World> mInternalId_world = new SparseArray<World>();
	protected static SparseArray<Environment> mInternalId_environment = new SparseArray<Environment>();
	protected static SparseArray<Objects> mInternalId_objects = new SparseArray<Objects>();
	protected static SparseArray<Trigger> mInternalId_trigger = new SparseArray<Trigger>();
	protected static SparseArray<Sky> mInternalId_sky = new SparseArray<Sky>();
	protected static SparseArray<Map> mInternalId_map = new SparseArray<Map>();
	
	void loadGlobalData(String jsonString){
		try {
			JSONArray globalDataRoot = new JSONObject(jsonString).getJSONArray("globalData");
			int len = globalDataRoot.length();
			for(int i = 0; i < len; i++){
				JSONObject globalData = globalDataRoot.getJSONObject(i);
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
