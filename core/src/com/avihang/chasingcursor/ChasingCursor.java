package com.avihang.chasingcursor;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class ChasingCursor extends ApplicationAdapter {
    SpriteBatch batch;
    ShapeRenderer sprite_1;
    ShapeRenderer sprite_2;
    float nextX;
    float nextY;
    float xCircle;
    float yCircle;
    float xSpeed;
    float ySpeed;
    Sprite[] sprites;

    @Override
    public void create() {
        batch = new SpriteBatch();
        sprite_1 = new ShapeRenderer();
        xCircle = yCircle = 0;
        xSpeed = ySpeed = 250;
        sprites = new Sprite[4];
        sprites[0] = new Sprite(0,0, MathUtils.random(50f,300f));
        sprites[1] = new Sprite(1280,0,MathUtils.random(50f,300f));
        sprites[2] = new Sprite(1280,720,MathUtils.random(50f,300f));
        sprites[3] = new Sprite(0,720,MathUtils.random(50f,300f));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        for (int i = 0; i < sprites.length; i++)
            sprites[i].draw();
    }

    @Override
    public void dispose() {
        batch.dispose();
        sprite_1.dispose();
    }

    private void drawCircle() {
        sprite_1.begin(ShapeRenderer.ShapeType.Filled);
        sprite_1.setColor(1, 0, 0, 1f);
        sprite_1.circle(xCircle, yCircle, 75);
        sprite_1.end();
    }

    private void moving() {
        if (xCircle < nextX)
            xCircle += xSpeed * Gdx.graphics.getDeltaTime();
        else
            xCircle -= xSpeed * Gdx.graphics.getDeltaTime();
        if (yCircle < nextY)
            yCircle += ySpeed * Gdx.graphics.getDeltaTime();
        else
            yCircle -= ySpeed * (Gdx.graphics.getHeight() - Gdx.graphics.getDeltaTime());
    }
}
