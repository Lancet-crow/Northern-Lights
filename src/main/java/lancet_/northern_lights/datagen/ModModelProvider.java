package lancet_.northern_lights.datagen;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.state.property.Properties;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.OAT_CROP, Properties.AGE_7,
                0, 1, 2, 3, 4, 5, 6, 7);
        blockStateModelGenerator.registerTintableCross(ModBlocks.HEATHER, BlockStateModelGenerator.TintType.TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.HEATHER_HONEY_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.OAT, Models.GENERATED);
        //itemModelGenerator.register(ModItems.OAT_SEEDS, Models.GENERATED);
    }
}
