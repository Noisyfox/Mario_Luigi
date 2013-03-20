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
	 * ���ĺ�����������ܴ��������ݵ���ײ�¼�
	 * 
	 * @param trigger
	 * @param trigger_x
	 * @param trigger_y
	 * @param actor
	 * @param direction
	 *            ��ײ�ķ���1��2��3��4��
	 * @param strength
	 *            ��ײ�����ȣ�1��(��̤)2ǿ(ײ��)
	 * @param world
	 *            ��ǰ����
	 * @param x
	 *            ��λ����x
	 * @param y
	 *            ��λ����y
	 * @param userDefinedArguments
	 *            �û�����Ĳ���
	 */
	protected void onCollision(Trigger trigger, int trigger_x, int trigger_y,
			Actor actor, int direction, int strength, World world, int x,
			int y, Bundle userDefinedArguments) {

	}

	protected void draw(World world, int x, int y, Bundle userDefinedArguments) {

	}
}
