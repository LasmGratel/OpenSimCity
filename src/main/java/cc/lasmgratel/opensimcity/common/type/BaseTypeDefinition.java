package cc.lasmgratel.opensimcity.common.type;

import cc.lasmgratel.opensimcity.api.type.TypeDefinition;
import cc.lasmgratel.opensimcity.api.type.provide.Provide;
import cc.lasmgratel.opensimcity.api.type.requirement.Requirement;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseTypeDefinition implements TypeDefinition {
    private Set<Provide<?>> provides = new HashSet<>();
    private Set<Requirement<?>> requirements = new HashSet<>();

    @Override
    public Set<Provide<?>> getProvides() {
        return provides;
    }

    @Override
    public Set<Requirement<?>> getRequirements() {
        return requirements;
    }
}
