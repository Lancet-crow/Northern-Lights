package lancet_.northern_lights;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.item.ModItems;
import lancet_.northern_lights.world.feature.ModBiomeModifications;
import lancet_.northern_lights.world.feature.ModConfiguredFeatures;
import lancet_.northern_lights.world.feature.ModPlacedFeatures;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NorthernLights implements ModInitializer {
	public static final String MOD_ID = "northern_lights";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModItems();
		ModBiomeModifications.load();
		//Registry.register(RegistryKeys.FEATURE, ModConfiguredFeatures.HEATHER_PATCH_KEY, Mo)
	}

	// Depends in fabric.mod.json: 		"farmersdelight": ">=1.21-2.1.9+refabricated"
}