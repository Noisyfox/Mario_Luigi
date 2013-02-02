package org.foxteam.noisyfox.mario_luigi;

import org.foxteam.noisyfox.FoxGaming.Core.FGGameActivity;

public final class MainActivity extends FGGameActivity {

	@Override
	public void onCreate() {
		this.forceLandscape();
	}

	@Override
	public void onEngineReady() {
	}

}
