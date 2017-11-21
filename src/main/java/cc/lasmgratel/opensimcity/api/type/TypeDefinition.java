package cc.lasmgratel.opensimcity.api.type;

import cc.lasmgratel.opensimcity.api.type.provide.Provide;
import cc.lasmgratel.opensimcity.api.type.requirement.Requirement;
import cc.lasmgratel.opensimcity.common.util.registry.RegistryEntry;

import java.util.Set;

public interface TypeDefinition extends RegistryEntry<TypeDefinition> {
    Set<Requirement<?>> getRequirements();
    Set<Provide<?>> getProvides();
}
