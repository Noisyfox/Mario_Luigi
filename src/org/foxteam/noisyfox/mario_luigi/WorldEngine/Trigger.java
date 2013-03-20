package org.foxteam.noisyfox.mario_luigi.WorldEngine;

/**
 * 
 * @ClassName: Trigger
 * @Description: ���������������ײ�¼������ܷ�͸֮�֣����ɼ�
 * @author: Noisyfox
 * @date: 2013-3-4 ����11:01:47
 * 
 */
public class Trigger {

	public static final int BLOCK_NONE = 0x0;
	public static final int BLOCK_RIGHT = 0x1;
	public static final int BLOCK_UP = 0x2;
	public static final int BLOCK_LEFT = 0x4;
	public static final int BLOCK_DOWN = 0x8;

	public int block = BLOCK_NONE;
	public int width = 0;
	public int height = 0;

	public Trigger(String id) {
		if (WordEngine.mExternalId_trigger.containsKey(id)) {
			throw new IllegalArgumentException("WorldEngine:Trigger:Id:\"" + id
					+ "\" already exist!");
		}

		int iid = WordEngine.mExternalId_trigger.size() + 1;
		WordEngine.mExternalId_trigger.put(id, Integer.valueOf(id));
		WordEngine.mInternalId_trigger.put(iid, this);
	}

}
