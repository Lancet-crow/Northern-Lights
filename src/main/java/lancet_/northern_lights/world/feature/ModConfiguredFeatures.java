package lancet_.northern_lights.world.feature;

import lancet_.northern_lights.NorthernLights;
import lancet_.northern_lights.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> HEATHER_PATCH_KEY = registerFeatureKey("heather_patch");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        register(
                context,
                HEATHER_PATCH_KEY,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEATHER)))
        );
    }

    private static RegistryKey<ConfiguredFeature<?,?>> registerFeatureKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature, FC featureConfig){
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }
}
