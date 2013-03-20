package org.foxteam.noisyfox.mario_luigi.WorldEngine;

public class World {

	public void loadFromJSON(String jsonString) {

	}

	protected enum ScaleMode {
		adaptive, stretch
	}

	protected class View {
		float width = 0f;
		float height = 0f;
		ScaleMode scaleMode = ScaleMode.adaptive;
	}
}
