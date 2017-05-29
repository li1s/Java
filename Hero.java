package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Hero {
	private Vector2 position;
	private float speed;
	private Texture texture;
	private int fireRate;
	private int fireCounter;
	
	public Hero () {
		position = new Vector2(50,320);
		speed = 10.0f;
		texture = new Texture ("ship64.png");
		fireRate = 4; //частота выстрела
		fireCounter = 0; //счестчик
	}

	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);		
	}
	public void update () {
		if (Gdx.input.isKeyPressed(Input.Keys.W)) {
			position.y += speed;
			if (position.y > 620) position.y = -32; 	
		}
		if (Gdx.input.isKeyPressed(Input.Keys.S)) {
			position.y -= speed;
			if (position.y < - 64) position.y = 620;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.A)) {
			position.x -= speed;
			if (position.x < 0  ) position.x = 0;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.D)) {
			position.x += speed;
			if(position.x > 1016) position.x = 1016;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.L)) {
			fireCounter ++;
			 if (fireCounter >= fireRate) {
				 fire ();
				 fireCounter = 0;
			 }
		}
		if (Gdx.input.isTouched()) {
			if (Gdx.input.getX() < position.x + 32) position.x -= speed;
			if (Gdx.input.getX() > position.x + 32) position.x += speed;

		}
	}
	
	public void fire () {
		for (int i = 0; i < MyGdxGame.bullet.length; i ++) {
			if (MyGdxGame.bullet[i].isActive ()) {
				MyGdxGame.bullet[i].setup(position.x + 48, position.y + 24);
				break;
			}
		}
	}
}
