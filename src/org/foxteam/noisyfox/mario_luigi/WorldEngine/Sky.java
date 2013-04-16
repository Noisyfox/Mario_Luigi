package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import java.util.ArrayList;
import java.util.List;

import org.foxteam.noisyfox.FoxGaming.Core.FGDebug;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;

public class Sky {
	private enum ScaleType {
		repeat, scale
	}

	List<Tiles> mTiles = new ArrayList<Tiles>();

	public Sky(String id) {
		if (WorldEngine.mExternalId_sky.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:Sky:Id:\"" + id
					+ "\" already exist!");
		}

		int iid = WorldEngine.mExternalId_sky.size() + 1;
		WorldEngine.mExternalId_sky.put(id, Integer.valueOf(id));
		WorldEngine.mInternalId_sky.put(iid, this);
	}

	protected void preDraw(Canvas c) {
		if (c == null)
			return;

		float cWidth = c.getWidth();
		float cHeight = c.getHeight();
		RectF drawRegion = new RectF();
		for (Tiles t : mTiles) {
			if (t.bitmap != null) {
				c.save();

				drawRegion.set(cWidth * Math.min(t.mapCoord[0], t.mapCoord[2]),
						cHeight * Math.min(t.mapCoord[1], t.mapCoord[3]),
						cWidth * Math.max(t.mapCoord[0], t.mapCoord[2]),
						cHeight * Math.max(t.mapCoord[1], t.mapCoord[3]));
				c.clipRect(drawRegion);
				float tHeight = 0;
				float tWidth = 0;
				switch (t.scaeType_x) {
				case repeat:
					tWidth = t.bitmap.getWidth();
					break;
				case scale:
					tWidth = drawRegion.width();
					break;
				}
				switch (t.scaeType_y) {
				case repeat:
					tHeight = t.bitmap.getHeight();
					break;
				case scale:
					tHeight = drawRegion.height();
					break;
				}

				RectF drawTarget = new RectF();
				drawTarget.set(0, 0, tWidth, tHeight);
				Rect resRect = new Rect(0, 0, t.bitmap.getWidth(),
						t.bitmap.getHeight());

				for (float x = drawRegion.left; x < drawRegion.right; x += tWidth) {
					for (float y = drawRegion.top; y < drawRegion.bottom; y += tHeight) {
						drawTarget.offsetTo(x, y);
						c.drawBitmap(t.bitmap, resRect, drawTarget, null);
					}
				}

				c.restore();
			}
		}
	}

	protected class Tiles {
		Bitmap bitmap = null;
		float mapCoord[] = { 0f, 0f, 0f, 0f };// x0,y0,x1,y1
		ScaleType scaeType_x = ScaleType.repeat;
		ScaleType scaeType_y = ScaleType.repeat;
	}

	/***********************************************************************************/
	protected static void loadJSONData(JSONArray dataArray)
			throws JSONException {
		if (dataArray == null || dataArray.length() == 0)
			return;

		int len = dataArray.length();
		for (int i = 0; i < len; i++) {
			JSONObject js_sky_def = dataArray.getJSONObject(i);
			String sky_id = js_sky_def.optString("id");
			if (sky_id.isEmpty()) {
				FGDebug.debug("Load sky fail: missing id.");
				continue;
			}
			Sky sky = new Sky(sky_id);

			JSONArray js_sky_tiles = js_sky_def.optJSONArray("tiles");
			if (js_sky_tiles == null)
				continue;

			int tiles_len = js_sky_tiles.length();
			if (tiles_len == 0)
				continue;
			for (int j = 0; j < tiles_len; j++) {
				JSONObject js_sky_tile = js_sky_tiles.getJSONObject(j);
				Tiles tile = sky.new Tiles();
				tile.mapCoord[0] = (float) js_sky_tile.optDouble("map_x0", 0);
				tile.mapCoord[1] = (float) js_sky_tile.optDouble("map_y0", 0);
				tile.mapCoord[2] = (float) js_sky_tile.optDouble("map_x1", 0);
				tile.mapCoord[3] = (float) js_sky_tile.optDouble("map_y1", 0);

				tile.scaeType_x = js_sky_tile.optString("scale_x", "repeat")
						.equals("repeat") ? ScaleType.repeat : ScaleType.scale;
				tile.scaeType_y = js_sky_tile.optString("scale_y", "scale")
						.equals("repeat") ? ScaleType.repeat : ScaleType.scale;
				// ¼ÓÔØbitmap
				String bitmapPath = js_sky_tile.optString("path");
				tile.bitmap = Resource.optBitmap(bitmapPath);

				sky.mTiles.add(tile);
			}
		}
	}
}
