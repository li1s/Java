package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Asteroid {

	private static Texture texture; //картинка общая для всех астероидов
	private Vector2 position;
	private float speed;
	
	public Asteroid () {
		position = new Vector2 ((float) Math.random() * 1080 + 1080, (float) Math.random() * 640);
				speed = 5.0f + (float) Math.random() * 5.0f;
				if (texture == null) {
					texture = new Texture ("asteroid64.png");
				}
	}
	
	public void recreate () {
		position.x = 1080;
		position.y = (float) Math.random() * 640;
		speed = 5.0f + (float) Math.random() * 5.0f;
	}
	
	public void update () {
		position.x -= speed;
		if (position.x < -64) {
			recreate ();
		}
		
	}
	public void render(SpriteBatch batch) {
		batch.draw(texture, position.x, position.y);
	}
	
	
	
	
	
	
}
