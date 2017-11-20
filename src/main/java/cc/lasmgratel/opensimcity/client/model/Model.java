package cc.lasmgratel.opensimcity.client.model;

import cc.lasmgratel.opensimcity.common.util.registry.RegistryEntry;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

public class Model extends RegistryEntry.Impl<Model> implements RenderableProvider {
    private com.badlogic.gdx.graphics.g3d.ModelInstance gdxModel;

    public Model(com.badlogic.gdx.graphics.g3d.ModelInstance gdxModel) {
        this.gdxModel = gdxModel;
    }

    public ModelInstance getGdxModel() {
        return gdxModel;
    }

    @Override
    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool) {
        gdxModel.getRenderables(renderables, pool);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        return gdxModel != null ? gdxModel.equals(model.gdxModel) : model.gdxModel == null;
    }

    @Override
    public int hashCode() {
        return gdxModel != null ? gdxModel.hashCode() : 0;
    }
}
