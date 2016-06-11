package com.thanhta.flappydick.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.thanhta.flappydick.FlappyDick;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		//adjust the screen's rectangle
		config.width = FlappyDick.WIDTH;
		config.height = FlappyDick.HEIGHT;
		config.title = FlappyDick.TITLE;
		new LwjglApplication(new FlappyDick(), config);
	}
}
