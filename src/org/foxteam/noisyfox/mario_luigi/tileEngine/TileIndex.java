package org.foxteam.noisyfox.mario_luigi.tileEngine;

import android.util.SparseArray;

public final class TileIndex {

	protected SparseArray<ElementDes> index = new SparseArray<ElementDes>();

	protected class ElementDes {
		protected boolean isStatic;
		protected Class<?> elementClass;
	}

	public final void addElementToIndex(int index,Class<?> element){
		
	}

}
