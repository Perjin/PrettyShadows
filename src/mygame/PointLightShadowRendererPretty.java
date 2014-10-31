/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.Vector4f;

/**
 *
 * @author Jan
 */
public class PointLightShadowRendererPretty extends com.jme3.shadow.PointLightShadowRenderer{
        /**
     * Used for serialization use
     * PointLightShadowRenderer"PointLightShadowRenderer(AssetManager
     * assetManager, int shadowMapSize)
     */
    public PointLightShadowRendererPretty() {
        super();
    }

    /**
     * Creates a PointLightShadowRenderer
     *
     * @param assetManager the application asset manager
     * @param shadowMapSize the size of the rendered shadowmaps (512,1024,2048,
     * etc...)
     */
    public PointLightShadowRendererPretty(AssetManager assetManager, int shadowMapSize) {
        super(assetManager, shadowMapSize);
    }
    
    @Override
    protected void setMaterialParameters(Material material) {
        material.setVector4("LightPos", new Vector4f(light.getPosition().x, light.getPosition().y, light.getPosition().z, 1f/light.getRadius()));
        material.setVector4("LightColor", light.getColor().toVector4f());
        
        
    }
        
}
