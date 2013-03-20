package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import java.util.ArrayList;
import java.util.List;

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
			throw new IllegalArgumentException("WorldEngine:Objects:Id:\"" + id
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
}
