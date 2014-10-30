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
        plsr.setShadowZExtend(15);
        plsr.setShadowZFadeLength(5);
        plsr.setShadowIntensity(1.0f);
        plsr.setFlushQueues(true);
//        plsr.displayDebug();
        viewPort.addProcessor(plsr);
        node.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);

        
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

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
