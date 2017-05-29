package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackGround {
	private Texture texture;
	
	public BackGround () {
		texture = new Texture ("night-sky-large.jpg");
	}
	
	public void render (SpriteBatch batch) {
		batch.draw(texture, 0, 0);
	}
	public void update() {
		
	}
}

