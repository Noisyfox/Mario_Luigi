package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.foxteam.noisyfox.FoxGaming.Core.FGDebug;
import org.foxteam.noisyfox.FoxGaming.Core.FGGameCore;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Resource {

	static HashMap<String, Bitmap> cachedResource_Bitmap = new HashMap<String, Bitmap>();

	static InputStream openResourceFile(String path) throws IOException {
		if (path == null)
			return null;

		int sp = path.indexOf('@');
		String loc = path.substring(0, sp);
		String pa = path.substring(sp + 1);

		InputStream iS = null;

		if (loc.equals("assets")) {
			iS = FGGameCore.getMainContext().getAssets().open(pa);
		} else {
			throw new IOException(
					"WorldEngine:Resource:Unknown resource location:\"" + loc
							+ "\" in \"" + path + "\"");
		}

		return iS;
	}

	static Bitmap optBitmap(String path) {
		Bitmap bitmap = null;
		if (cachedResource_Bitmap.containsKey(path)) {
			bitmap = cachedResource_Bitmap.get(path);
		} else {
			try {
				bitmap = BitmapFactory.decodeStream(openResourceFile(path));
				cachedResource_Bitmap.put(path, bitmap);
			} catch (IOException e) {
				FGDebug.error("WorldEngine:Resource:Unable to load bitmap \""
						+ path + "\".\n" + e.getMessage());
			}
		}
		return bitmap;
	}
}
