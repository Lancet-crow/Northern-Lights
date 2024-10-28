package lancet_.northern_lights.world.feature;

import lancet_.northern_lights.NorthernLights;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> HEATHER_CONFIGURED_KEY = registerConfiguredFeatureKey("heather");


    private static RegistryKey<ConfiguredFeature<?,?>> registerConfiguredFeatureKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(NorthernLights.MOD_ID, name));
    }
}
