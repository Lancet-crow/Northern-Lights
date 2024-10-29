package lancet_.northern_lights.datagen;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.CropBlock;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.HEATHER);
        addDrop(ModBlocks.OAT_CROP, cropDrops(ModBlocks.OAT_CROP, ModItems.OAT, ModItems.OAT_SEEDS,
                BlockStatePropertyLootCondition.builder(ModBlocks.OAT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7))));
    }
}
