package com.thanhta.flappydick.States;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

public class GameStateManager {
    //Manage states work well in stack form
    private Stack<State> states;
    public GameStateManager(){
        states = new Stack<State>();
    }
    public void push(State state){
        states.push(state);
    }
    public void pop(){
        states.pop();
    }
    //to pop and then push instally another state, use "set"
    public void set(State state){
        states.pop();
        states.push(state);
    }
    public void update(float dt){
    //peek = see the top one in stack
        states.peek().update(dt);
    }
    public void render(SpriteBatch sb){
        states.peek().render(sb);
    }
}
