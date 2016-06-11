package com.thanhta.flappydick.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.thanhta.flappydick.FlappyDick;

public class PlayState extends State {
    private Texture bird;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Texture("bird.png");
        //set the game world's view smaller
        //"false" to count form bottom left
        cam.setToOrtho(false, FlappyDick.WIDTH/2, FlappyDick.HEIGHT/2);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb){
        //adjust to the right game world's viewport
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bird, 50, 50);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
