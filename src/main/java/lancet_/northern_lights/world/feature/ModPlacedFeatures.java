package lancet_.northern_lights.world.feature;

import lancet_.northern_lights.NorthernLights;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> HEATHER_PATCH_KEY = registerFeatureKey("heather_patch_placed");
    public static final RegistryKey<PlacedFeature> HEATHER_KEY = registerFeatureKey("heather_placed");

    public static void bootstrap(Registerable<PlacedFeature> context){
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        NorthernLights.LOGGER.info("Adding Heather Patch to Placed Features");
        register(context, HEATHER_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.HEATHER_KEY),
                List.of(BlockFilterPlacementModifier.of(BlockPredicate.IS_AIR)));
        register(context, HEATHER_PATCH_KEY, registryLookup.getOrThrow(ModConfiguredFeatures.HEATHER_PATCH_KEY),
                Modifiers.modifiers(12));
    }

    private static RegistryKey<PlacedFeature> registerFeatureKey(String name){
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                 RegistryEntry<ConfiguredFeature<?, ?>> config,
                                 List<PlacementModifier> modifierList){
        context.register(key, new PlacedFeature(config, List.copyOf(modifierList)));
    }
    public static class Modifiers{
        public static List<PlacementModifier> modifiers(int count) {
            return List.of(CountPlacementModifier.of(count), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        }
    }
}
