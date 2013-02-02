package org.foxteam.noisyfox.mario_luigi.tileEngine;

public final class TileWorld {

	protected TileMap currentMap;
	protected TileElement cachedElements[][];

	protected int worldSize_height, worldSize_width;

	protected int viewPort_x, viewPort_y, viewPort_width, viewPort_height;

	protected int tileSize_width, tileSize_height;

	protected long clockTicks = 0;

	public final void setTileSize(int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}
		tileSize_width = width;
		tileSize_height = height;
	}

	public final long getSyncClockTick() {
		return clockTicks;
	}

	public final void setViewPort(int x, int y, int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException();
		}

		viewPort_x = x;
		viewPort_y = y;
		viewPort_width = width;
		viewPort_height = height;
	}

	/**
	 * 计算viewPort，冻结不需要的element，碰撞检测
	 */
	public final void update() {

	}

}
