package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import android.os.Bundle;

public class Objects {

	protected int trigger_id = -1;

	public Objects(String id) {
		if (WordEngine.mExternalId_objects.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:Objects:Id:\"" + id
					+ "\" already exist!");
		}

		int iid = WordEngine.mExternalId_objects.size() + 1;
		WordEngine.mExternalId_objects.put(id, Integer.valueOf(id));
		WordEngine.mInternalId_objects.put(iid, this);
	}

	/**
	 * 核心函数，负责接受触发器传递的碰撞事件
	 * 
	 * @param trigger
	 * @param trigger_x
	 * @param trigger_y
	 * @param actor
	 * @param direction
	 *            碰撞的方向，1右2上3左4下
	 * @param strength
	 *            碰撞的力度，1弱(踩踏)2强(撞击)
	 * @param world
	 *            当前世界
	 * @param x
	 *            单位坐标x
	 * @param y
	 *            单位坐标y
	 * @param userDefinedArguments
	 *            用户定义的参数
	 */
	protected void onCollision(Trigger trigger, int trigger_x, int trigger_y,
			Actor actor, int direction, int strength, World world, int x,
			int y, Bundle userDefinedArguments) {

	}

	protected void draw(World world, int x, int y, Bundle userDefinedArguments) {

	}
}
