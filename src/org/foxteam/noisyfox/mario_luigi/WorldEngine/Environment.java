package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import android.graphics.Canvas;
import android.os.Bundle;

/**
 * 
 * @ClassName: Environment
 * @Description: Environment ���������ڻ��Ʋ��ɽ��������������ľ���ݴԡ������ȣ��ṩһ�������ʱ���������� json
 *               ��ʽ���棬����ʱϵͳ�Զ���ȡΪ Bundle ��ʽ����Ϊ�������ݸ�������
 * @author: Noisyfox
 * @date: 2013-3-4 ����5:25:27
 * 
 */
public abstract class Environment {
	/**
	 * �����ʱ����ÿһ֡���ϵͳ���Զ�����1
	 */
	protected static long sharedTimer = 0;

	/**
	 * ����֡�������С��1�������κ�Ч��������1����Ԥ�Ȼ��Ƶ�����bitmap�У�����1���ᶯ̬���ƶ�����
	 * ע�⣬Ԥ���ƻ��潫ʹ��Canvas����̬���ƽ�ʹ��openGL
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
	 * Ԥ�������ݵ����滭��
	 * 
	 * @param c
	 *            ���廭��
	 * @param world
	 *            ��ǰ����
	 * @param x
	 *            ��λ����x
	 * @param y
	 *            ��λ����y
	 * @param userDefinedArguments
	 *            �û�����Ĳ���
	 */
	protected abstract void preDraw(Canvas c, World world, int x, int y,
			Bundle userDefinedArguments);

	protected abstract void draw(World world, int x, int y,
			Bundle userDefinedArguments);

}
