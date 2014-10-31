package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.light.AmbientLight;
import com.jme3.light.PointLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.shadow.EdgeFilteringMode;
import com.jme3.shadow.PointLightShadowFilter;
import com.jme3.shadow.PointLightShadowRenderer;
import com.jme3.util.TangentBinormalGenerator;


public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        flyCam.setMoveSpeed(20f);
        Node node = new Node("Geometry");
        Spatial geom = box(4,1,4);
        geom.setLocalTranslation(2f, -2f, 0f);
        node.attachChild(geom);
        Spatial geom2 = box (1,1,1);
        node.attachChild(geom2);
        Spatial sphere = sphere(1f);
        sphere.setLocalTranslation(4f, 0f, 0f);
        node.attachChild(sphere);
        PointLight pl = new PointLight();
        Spatial light1 = sphereLight(.05f);
        light1.setLocalTranslation(1.5f, 2f, 2f);
        rootNode.attachChild(light1);
        pl.setPosition(new Vector3f(1.5f, 2f, 2f));
        pl.setRadius(10f);
        pl.setColor(new ColorRGBA(2f, 1f, .5f, 1f));
        
        rootNode.attachChild(node);
//        rootNode.addLight(pl);
        
        
        AmbientLight al = new AmbientLight();
        al.setColor(new ColorRGBA(0.25f, .5f, .75f, 1f));
        rootNode.addLight(al);
        PointLightShadowRendererPretty plsr = new PointLightShadowRendererPretty(assetManager, 1024);
//        PointLightShadowRenderer plsr = new PointLightShadowRenderer(assetManager, 1024);
        plsr.setLight(pl);        
        plsr.setEdgeFilteringMode(EdgeFilteringMode.PCF4);
        plsr.setShadowIntensity(1.0f);
        plsr.setFlushQueues(false);
//        plsr.displayDebug();
        viewPort.addProcessor(plsr);
        
        
        PointLightShadowRendererPretty plsr2 = new PointLightShadowRendererPretty(assetManager, 1024);
//        PointLightShadowRenderer plsr = new PointLightShadowRenderer(assetManager, 1024);
        PointLight pl2 = new PointLight();
        Spatial light2 = sphereLight(.05f);
        light2.setLocalTranslation(2.5f, 2f, -2f);
        rootNode.attachChild(light2);
        pl2.setPosition(new Vector3f(2.5f, 2f, -2f));
        pl2.setRadius(10f);
        pl2.setColor(new ColorRGBA(1f, 2f, .5f, 1f));
        plsr2.setLight(pl2);        
        plsr2.setEdgeFilteringMode(EdgeFilteringMode.PCF4);
        plsr2.setShadowIntensity(1.0f);
        plsr2.setFlushQueues(true);
        PointLight pl3 = new PointLight();
        Spatial light3 = sphereLight(.05f);
        light3.setLocalTranslation(-1.5f, 1f, 0f);
        rootNode.attachChild(light3);
        pl3.setPosition(new Vector3f(-1.5f, 1f, 0f));
        pl3.setRadius(5f);
        pl3.setColor(new ColorRGBA(0f, 0f, 1.5f, 1f));
        rootNode.addLight(pl3);
//        plsr.displayDebug();
        viewPort.addProcessor(plsr2);
       // node.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        
    }
    
    Spatial box(float x, float y, float z){
        Box b = new Box(x,y,z);
        Geometry geom = new Geometry("Box", b);
        Material mat = assetManager.loadMaterial("Materials/LightingShadow.j3m");
        geom.setMaterial(mat);
        geom.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        TangentBinormalGenerator.generate(geom);
        return geom;
    }
    
    Spatial sphere(float r){
        Sphere b = new Sphere(16,16,r);
        Geometry geom = new Geometry("Sphere", b);
        Material mat = assetManager.loadMaterial("Materials/LightingShadow.j3m");
        geom.setMaterial(mat);
        geom.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        TangentBinormalGenerator.generate(geom);
        return geom;
    }
    Spatial sphereLight(float r){
        Sphere b = new Sphere(16,16,r);
        Geometry geom = new Geometry("Sphere", b);
        Material mat = assetManager.loadMaterial("Common/Materials/WhiteColor.j3m");
        geom.setMaterial(mat);
        geom.setShadowMode(RenderQueue.ShadowMode.Off);
        TangentBinormalGenerator.generate(geom);
        return geom;
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
