package lancet_.northern_lights.world.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModBiomeModifications {
    public static void load(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HEATHER_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WILD_OAT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.SPAWNS_SNOW_FOXES),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PATCH_CRANBERRY_BUSH_PLACED_KEY);
    }
}
