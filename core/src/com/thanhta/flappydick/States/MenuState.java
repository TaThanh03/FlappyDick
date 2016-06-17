package com.thanhta.flappydick.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.thanhta.flappydick.FlappyDick;

import sun.rmi.runtime.Log;

public class MenuState extends State{
    private Texture background;
    private Texture playBtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            //through away texts that not use anymore to prevent memory leech
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        //bottom left hand corner
        sb.draw(background, 0,0, FlappyDick.WIDTH, FlappyDick.HEIGHT);
        sb.draw(playBtn, (FlappyDick.WIDTH/2)- (playBtn.getWidth()/2),
                (FlappyDick.HEIGHT/2));
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
