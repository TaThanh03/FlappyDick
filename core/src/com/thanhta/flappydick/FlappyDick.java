package com.thanhta.flappydick;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thanhta.flappydick.States.GameStateManager;
import com.thanhta.flappydick.States.MenuState;

public class FlappyDick extends ApplicationAdapter {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
	public static final String TITLE = "Flappy Dick";
    private GameStateManager gsm;
	private Music music;
    //Do not create SpriteBatch in each individual state
    // because it's very heavy, you only needed one, it can be passing thought each state
	private SpriteBatch batch;

	@Override
	public void dispose() {
		super.dispose();
		music.dispose();
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
        gsm = new GameStateManager();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		music.setLooping(true);
		music.setVolume(0.1f);
		music.play();
        Gdx.gl.glClearColor(1, 0, 0, 1);
        gsm.push(new MenuState(gsm));
	}

	@Override
	public void render () {
        //wipe the screen clean
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        //get the delta time when update
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);
	}
}
