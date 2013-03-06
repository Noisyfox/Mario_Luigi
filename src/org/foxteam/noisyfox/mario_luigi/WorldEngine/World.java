package org.foxteam.noisyfox.mario_luigi.WorldEngine;

import java.util.HashMap;

import android.util.SparseArray;

public class World {

	protected static HashMap<String, Integer> mExternalId_environment = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_objects = new HashMap<String, Integer>();
	protected static HashMap<String, Integer> mExternalId_trigger = new HashMap<String, Integer>();

	protected static SparseArray<Environment> mInternalId_environment = new SparseArray<Environment>();
	protected static SparseArray<Objects> mInternalId_objects = new SparseArray<Objects>();
	protected static SparseArray<Trigger> mInternalId_trigger = new SparseArray<Trigger>();
}