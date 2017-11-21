package cc.lasmgratel.opensimcity.api.type.provide;

import cc.lasmgratel.opensimcity.common.util.registry.RegistryEntry;
import com.google.gson.annotations.SerializedName;

public class ProvideDefinition extends RegistryEntry.Impl<ProvideDefinition> {
    private String type;

    @SerializedName("default")
    private Object defaultValue;
}
