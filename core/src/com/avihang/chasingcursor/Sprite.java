package com.avihang.chasingcursor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Sprite extends ShapeRenderer {

    private float x;
    private float y;
    private float nextX;
    private float nextY;
    private float speedX;
    private float speedY;
    private float[] rgb;

    public Sprite(float x,float y, float speed) {
        rgb = new float[3];
        for (int i = 0; i < 3; i++)
            rgb[i] = MathUtils.random(0, 1f);
        speedX = speedY = speed;
        this.x = x;
        this.y = y;
    }

    public void draw() {
        nextX = Gdx.input.getX();
        nextY = Gdx.graphics.getHeight() - Gdx.input.getY();

        if(x < nextX)
            x += speedX * Gdx.graphics.getDeltaTime();
        else
            x -= speedX * Gdx.graphics.getDeltaTime();
        if (y < nextY)
            y += speedY * Gdx.graphics.getDeltaTime();
        else
            y -= speedY * Gdx.graphics.getDeltaTime();

        super.begin(ShapeType.Filled);
        super.setColor(rgb[0], rgb[1], rgb[2], 1f);
        super.circle(x,y,50);
        super.end();
    }


}
