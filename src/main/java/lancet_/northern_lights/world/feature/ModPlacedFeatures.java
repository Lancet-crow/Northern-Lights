package lancet_.northern_lights.world.feature;

import lancet_.northern_lights.NorthernLights;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> HEATHER_PLACED_KEY = registerPlacedFeatureKey("heather_placed");

    private static RegistryKey<PlacedFeature> registerPlacedFeatureKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(NorthernLights.MOD_ID, name));
    }
}
