package cc.lasmgratel.opensimcity.common.util;

import com.google.gson.*;
import ro.fortsoft.pf4j.util.StringUtils;

import javax.annotation.Nonnull;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Locale;

public class ResourceLocation implements Comparable<ResourceLocation> {
    protected final String resourceDomain;
    protected final String resourcePath;

    protected ResourceLocation(int ignored, String... resourceName) {
        this.resourceDomain = StringUtils.isEmpty(resourceName[0]) ? "opensimcity" : resourceName[0].toLowerCase(Locale.ROOT);
        this.resourcePath = resourceName[1].toLowerCase(Locale.ROOT);
        if (resourcePath == null)
            throw new NullPointerException("Resource path cannot be null! Cached resource name: " + Arrays.toString(resourceName));
    }

    public ResourceLocation(String resourceName) {
        this(0, splitObjectName(resourceName));
    }

    public ResourceLocation(String resourceDomainIn, String resourcePathIn) {
        this(0, resourceDomainIn, resourcePathIn);
    }

    /**
     * Splits an object name (such as minecraft:apple) into the domain and path parts and returns these as an array of
     * length 2. If no colon is present in the passed value the returned array will contain {null, toSplit}.
     */
    public static String[] splitObjectName(String toSplit) {
        String[] strings = new String[]{"opensimcity", toSplit};
        int i = toSplit.indexOf(58);

        if (i >= 0) {
            strings[1] = toSplit.substring(i + 1, toSplit.length());

            if (i > 1)
                strings[0] = toSplit.substring(0, i);
        }

        return strings;
    }

    public String getResourcePath() {
        return this.resourcePath;
    }

    public String getResourceDomain() {
        return this.resourceDomain;
    }

    public String toString() {
        return this.resourceDomain + ':' + this.resourcePath;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        else if (!(o instanceof ResourceLocation))
            return false;
        else {
            ResourceLocation resourcelocation = (ResourceLocation) o;
            return this.resourceDomain.equals(resourcelocation.resourceDomain) && this.resourcePath.equals(resourcelocation.resourcePath);
        }
    }

    public int hashCode() {
        return 31 * this.resourceDomain.hashCode() + this.resourcePath.hashCode();
    }

    public int compareTo(@Nonnull ResourceLocation o) {
        int i = this.resourceDomain.compareTo(o.resourceDomain);

        if (i == 0)
            i = this.resourcePath.compareTo(o.resourcePath);

        return i;
    }

    public static class Serializer implements JsonDeserializer<ResourceLocation>, JsonSerializer<ResourceLocation> {
        public ResourceLocation deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
            return new ResourceLocation(json.isJsonPrimitive() ? json.getAsString() : "");
        }

        public JsonElement serialize(ResourceLocation src, Type type, JsonSerializationContext context) {
            return new JsonPrimitive(src.toString());
        }
    }
}
