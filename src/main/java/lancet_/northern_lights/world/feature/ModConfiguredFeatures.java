package lancet_.northern_lights.world.feature;

import lancet_.northern_lights.NorthernLights;
import lancet_.northern_lights.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures {


    //public static final RegistryKey<ConfiguredFeature<?, ?>> HEATHER_PATCH_KEY = registerFeatureKey("heather_patch");

    /*public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context){
        NorthernLights.LOGGER.info("Adding Heather Patch to Configured Features");
        register(context, HEATHER_PATCH_KEY, Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEATHER)))
        );
        register(context, HEATHER_KEY, Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(
                BlockStateProvider.of(ModBlocks.HEATHER)));
        register(context, HEATHER_PATCH_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        64, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK,
                        new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HEATHER)))
                )
        );
    }

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(Block block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(block))));
    }*/



    /*private static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> context, RegistryKey<ConfiguredFeature<?, ?>> key,
            F feature, FC featureConfig){
        context.register(key, new ConfiguredFeature<>(feature, featureConfig));
    }*/
}
