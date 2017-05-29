package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private BackGround background;
	private Hero hero;
	private Asteroid[] asteroid;
	public static Bullet [] bullet;
	private Texture textureBullet;
	
	public void create () {
	    batch = new SpriteBatch();
		background = new BackGround();
		hero = new Hero ();
		asteroid = new Asteroid [50];
		for ( int i = 0; i < asteroid.length; i++) {
			asteroid[i] = new Asteroid();
		}
		bullet = new Bullet [200];	
		for (int i = 0; i < bullet.length; i++) {
			bullet[i] = new Bullet();
		}
		textureBullet = new Texture ("bullet64x32.png");
		
	}

	@Override
	public void render () {
		update ();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
		for ( int i = 0; i < asteroid.length; i++) {
			asteroid[i].render(batch);
		}
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i].isActive())
				batch.draw(textureBullet, bullet[i].getPosition().x - 32, bullet[i].getPosition().y - 16);
		}
		
		
		
		batch.end();
	}
	
	
	public void update () {
		background.update();
		hero.update();
		for ( int i = 0; i < asteroid.length; i++) {
			asteroid[i].update();
		}
		for (int i = 0; i < bullet.length; i++) {
			if (bullet[i].isActive()) {
				bullet[i].update();
			}
		}
	}
	
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
