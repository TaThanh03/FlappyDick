package com.thanhta.flappydick.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.thanhta.flappydick.FlappyDick;
import com.thanhta.flappydick.sprites.Bird;
import com.thanhta.flappydick.sprites.Tube;

public class PlayState extends State {
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private Bird bird;
    private Texture bg;
    private Array<Tube> tubes;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50,300);
        //set the game world's view smaller, "false" to count form bottom left
        cam.setToOrtho(false, FlappyDick.WIDTH/2, FlappyDick.HEIGHT/2);
        bg = new Texture("bg.png");
        tubes = new Array<Tube>();

        for (int i=1; i<= TUBE_COUNT; i++){
            tubes.add(new Tube(i*(TUBE_SPACING + Tube.TUBE_WIDTH)));

        }
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()){bird.jump();}
    }

    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        //adjust cam to follow the bird position
        cam.position.x = bird.getPosition().x +80;
        //remove went off screen
        for (Tube tube: tubes){
            if (cam.position.x - (cam.viewportWidth/2) > tube.getPosTopTube().x + tube.getTopTube().getWidth()){
                tube.reposition(tube.getPosTopTube().x+((Tube.TUBE_WIDTH + TUBE_SPACING)* TUBE_COUNT));
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb){
        //adjust to the right game world's viewport
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2), 0);
        sb.draw(bird.getTexture(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube: tubes) {
            sb.draw(tube.getTopTube(), tube.getPosTopTube().x, tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPosBotTube().x, tube.getPosBotTube().y);
        }

        sb.end();
    }

    @Override
    public void dispose() {

    }
}
