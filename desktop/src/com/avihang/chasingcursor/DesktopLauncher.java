package com.avihang.chasingcursor;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.avihang.chasingcursor.ChasingCursor;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		//config.disableAudio(true);
		config.setTitle("ChasingCursor");
		config.setWindowedMode(1280,720);
		config.useVsync(true);
		new Lwjgl3Application(new ChasingCursor(), config);
	}
}
