package lancet_.northern_lights;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.item.ModItems;
import lancet_.northern_lights.world.feature.ModBiomeModifications;
import lancet_.northern_lights.world.feature.ModConfiguredFeatures;
import lancet_.northern_lights.world.feature.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NorthernLights implements ModInitializer {
	public static final String MOD_ID = "northern_lights";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<ConfiguredFeature<?, ?>> HEATHER_CONFIGURED_KEY = registerConfiguredFeatureKey("heather");
	public static final RegistryKey<PlacedFeature> HEATHER_PLACED_KEY = registerPlacedFeatureKey("heather_placed");

	private static RegistryKey<ConfiguredFeature<?,?>> registerConfiguredFeatureKey(String name) {
		return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(name));
	}
	private static RegistryKey<PlacedFeature> registerPlacedFeatureKey(String name){
		return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(name));
	}

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModItems();
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.VEGETAL_DECORATION, HEATHER_PLACED_KEY);
		//Registry.register(RegistryKeys.FEATURE, ModConfiguredFeatures.HEATHER_KEY);
	}

	// Depends in fabric.mod.json: 		"farmersdelight": ">=1.21-2.1.9+refabricated"
}