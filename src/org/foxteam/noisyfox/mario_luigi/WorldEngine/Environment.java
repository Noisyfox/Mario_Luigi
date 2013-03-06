package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import android.graphics.Canvas;
import android.os.Bundle;

/**
 * 
 * @ClassName: Environment
 * @Description: Environment 描述，用于绘制不可交互的物件，如树木、草丛、环境等，提供一个共享计时器，参数以 json
 *               形式储存，运行时系统自动读取为 Bundle 形式并作为参数传递给各函数
 * @author: Noisyfox
 * @date: 2013-3-4 下午5:25:27
 * 
 */
public abstract class Environment {
	/**
	 * 共享计时器，每一帧最初系统会自动增加1
	 */
	protected static long sharedTimer = 0;

	/**
	 * 动画帧数，如果小于1不会有任何效果，等于1将会预先绘制到缓存bitmap中，大于1将会动态绘制动画。
	 * 注意，预绘制缓存将使用Canvas，动态绘制将使用openGL
	 */
	protected int frameCount = 0;

	public Environment(String id) {
		if (World.mExternalId_environment.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:Environment:Id:\""
					+ id + "\" already exist!");
		}

		int iid = World.mExternalId_environment.size() + 1;
		World.mExternalId_environment.put(id, Integer.valueOf(id));
		World.mInternalId_environment.put(iid, this);
	}

	/**
	 * 预绘制内容到缓存画布
	 * 
	 * @param c
	 *            缓冲画布
	 * @param world
	 *            当前世界
	 * @param x
	 *            单位坐标x
	 * @param y
	 *            单位坐标y
	 * @param userDefinedArguments
	 *            用户定义的参数
	 */
	protected abstract void preDraw(Canvas c, World world, int x, int y,
			Bundle userDefinedArguments);

	protected abstract void draw(World world, int x, int y,
			Bundle userDefinedArguments);

}
