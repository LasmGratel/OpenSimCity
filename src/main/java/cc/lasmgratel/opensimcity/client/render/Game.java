package cc.lasmgratel.opensimcity.client.render;

import cc.lasmgratel.opensimcity.client.OpenSimCityClient;
import cc.lasmgratel.opensimcity.client.controller.InputProcessorHandler;
import cc.lasmgratel.opensimcity.client.model.Model;
import cc.lasmgratel.opensimcity.client.util.registry.OSCClientRegistries;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.MeshPartBuilder;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.g3d.utils.shapebuilders.BoxShapeBuilder;

import java.util.Random;

public class Game implements ApplicationListener {
    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelCache modelCache;
    private Environment environment;
    private CameraInputController cameraInputController;

    @Override
    public void create() {
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0,0,0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        cameraInputController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(new InputMultiplexer(cameraInputController, new InputProcessorHandler()));

        Random random = new Random();
        ModelBuilder modelBuilder = new ModelBuilder();
        modelCache = new ModelCache();
        for (Color color : Colors.getColors().values()) {
            modelBuilder.begin();
            modelBuilder.node();
            MeshPartBuilder mpb = modelBuilder.part("box" + color.toString(), GL20.GL_TRIANGLES, VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal, new Material(ColorAttribute.createDiffuse(color)));
            BoxShapeBuilder.build(mpb, random.nextInt(15), random.nextInt(15), random.nextInt(15));
            OSCClientRegistries.MODELS.register(new Model(new ModelInstance(modelBuilder.end())).setRegistryName("box" + color.toString()));
        }
        modelCache.begin(camera);
        OSCClientRegistries.MODELS.getValues().stream().map(Model::getGdxModel).forEach(modelCache::add);
        modelCache.end();
        OpenSimCityClient.getLogger().info("Cached {} models", OSCClientRegistries.MODELS.getValues().size());
        modelBatch = new ModelBatch();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        cameraInputController.update();
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        modelBatch.begin(camera);
        modelBatch.render(modelCache, environment);
        modelBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
        modelCache.dispose();
        modelBatch.dispose();
    }
}
