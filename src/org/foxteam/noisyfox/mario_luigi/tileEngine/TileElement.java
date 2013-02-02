package org.foxteam.noisyfox.mario_luigi.tileEngine;

import org.foxteam.noisyfox.FoxGaming.Core.FGPerformer;
import org.foxteam.noisyfox.FoxGaming.G2D.FGSprite;

import android.graphics.Canvas;

public class TileElement extends FGPerformer {

	protected int tile_x, tile_y, tile_width, tile_height;
	protected TileWorld bindedWorld;

	public final void setElementSize(int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}

		tile_width = width;
		tile_height = height;
	}

	@Override
	protected void onDraw() {
		if (viewing())
			super.onDraw();
	}

	/**
	 * 判断当前element是否可见,默认函数只考虑是否处于当前viewport中
	 * 
	 * @return
	 */
	protected boolean viewing() {
		if (bindedWorld == null || bindedWorld.tileSize_width <= 0
				|| bindedWorld.tileSize_height <= 0)
			return false;

		final int vport_x_min = bindedWorld.viewPort_x
				/ bindedWorld.tileSize_width;
		final int vport_y_min = bindedWorld.viewPort_y
				/ bindedWorld.tileSize_height;
		final int vport_x_max = (bindedWorld.viewPort_x + bindedWorld.viewPort_width)
				/ bindedWorld.tileSize_width;
		final int vport_y_max = (bindedWorld.viewPort_y + bindedWorld.viewPort_height)
				/ bindedWorld.tileSize_height;

		final int minx = Math.max(vport_x_min, tile_x);
		final int miny = Math.max(vport_y_min, tile_y);
		final int maxx = Math.min(vport_x_max, tile_x + tile_width - 1);
		final int maxy = Math.min(vport_y_max, tile_y + tile_height - 1);

		return minx <= maxx && miny <= maxy;

	}

	/**
	 * 绘制到缓存画布
	 * 
	 * @param c
	 */
	protected final void drawToCacheBitmap(Canvas c) {
		if (bindedWorld == null || c == null)
			return;

		FGSprite sprite = this.getSprite();
		if (sprite == null || sprite.getFrameCount() <= 0)
			return;

		c.drawBitmap(sprite.getFrames().getFrame(0), tile_x
				* bindedWorld.tileSize_width, tile_y
				* bindedWorld.tileSize_height, null);
	}

	/**
	 * 判断两个element有没有重叠的部分
	 * 
	 * @param e1
	 * @param e2
	 * @return
	 */
	public final static boolean element_crossTest(TileElement e1, TileElement e2) {
		if (e1.bindedWorld == null || e2.bindedWorld == null
				|| e1.bindedWorld != e2.bindedWorld)
			return false;// 如果两个element处于不同world则必然不能重叠

		final int minx = Math.max(e1.tile_x, e2.tile_x);
		final int miny = Math.max(e1.tile_y, e2.tile_y);
		final int maxx = Math.min(e1.tile_x + e1.tile_width - 1, e2.tile_x
				+ e2.tile_width - 1);
		final int maxy = Math.min(e1.tile_y + e1.tile_height - 1, e2.tile_y
				+ e2.tile_height - 1);

		return minx <= maxx && miny <= maxy;
	}
}
