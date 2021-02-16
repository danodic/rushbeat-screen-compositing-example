package dev.danodic.rushbeat.compositing.example;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import dev.danodic.rushbeat.rushbeat.compositor.Pipeline;
import dev.danodic.rushbeat.rushbeat.compositor.ScreenPipeline;
import dev.danodic.rushbeat.rushbeat.compositor.stages.ChromaAberration;

/**
 *
 * @author danodic
 */
public class Example implements ApplicationListener {

    Texture texture;
    SpriteBatch batch;
    ScreenPipeline screenPipeline;
    ChromaAberration chroma;
    Float intensity;

    @Override
    public void create() {
        batch = new SpriteBatch();
        intensity = 0f;
        texture = new Texture("assets/sample.png");

        // Create the pipeline
        screenPipeline = new ScreenPipeline(1600, 900);

        // Create a chroma aberration pass
        chroma = new ChromaAberration(1600, 900);

        // Create the pipeline pass and add stages
        Pipeline firstPass = screenPipeline.addPipeline();
        firstPass.add(chroma);
    }

    @Override
    public void render() {
        update();
        clear();
        screenPipeline.begin();
        batch.begin();
        batch.draw(texture, 0, 0);
        batch.end();
        screenPipeline.end();
        screenPipeline.render();
    }

    public void clear() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
    
    public void update() {
        intensity += 0.01f;
        if(intensity>=1f) {
            intensity = 0.0f;
        }
        chroma.setIntensity(intensity);
    }

    @Override
    public void resize(int arg0, int arg1) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        texture.dispose();
    }

}
