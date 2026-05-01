package com.github.thaldos;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.utils.Array;

public class MainScreen extends ScreenAdapter {
    private AssetManager assetManager;
    private Environment environment;
    private PerspectiveCamera camera;
    private CameraInputController cameraController;
    private ModelBatch modelBatch;
    private Model model;
    private Array<ModelInstance> instances = new Array<ModelInstance>();

    public MainScreen() {
        modelBatch = new ModelBatch();

        // Load all resources in assets manager :
        assetManager = new AssetManager();
        assetManager.load("libgdx.png", Texture.class);
        assetManager.finishLoading();

        // Get image by asset manager :
        // image = assetManager.get("libgdx.png", Texture.class);

        // Create the environment :
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        // Create the camera :
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();

        // Handle the camera with mouse :
        cameraController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(cameraController);

        // Get a model builder :
        Material materialBlue = new Material(ColorAttribute.createDiffuse(Color.CYAN));
        ModelBuilder modelBuilder = new ModelBuilder();

        // Create a 3D box :
        ModelInstance modelInstance3DBox = new ModelInstance(
            modelBuilder.createBox(5f, 5f, 5f, materialBlue, Usage.Position | Usage.Normal)
        );
        modelInstance3DBox.transform.setToTranslation(5f, 0f, 0f);
        instances.add(modelInstance3DBox);

        // Create a 3D axes :
        ModelInstance modelInstance3DAxes = new ModelInstance(
            modelBuilder.createXYZCoordinates(2f, materialBlue, Usage.Position | Usage.Normal)
        );
        modelInstance3DAxes.transform.setToTranslation(0f, 0f, 0f);
        instances.add(modelInstance3DAxes);
    }

    @Override
    public void render(float delta) {
        // Update camera :
        cameraController.update();

        // Render instances :
        modelBatch.begin(camera);
        for (ModelInstance instance : instances) {
            modelBatch.render(instance, environment);
        }
        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        model.dispose();
        assetManager.dispose();
    }
}
