package lancet_.northern_lights.datagen;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    public LootTable.Builder readyCropDrops(Block crop, Item product, Item seeds){
        return cropDrops(crop, product, seeds, BlockStatePropertyLootCondition.builder(crop)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7)));
    }

    public Function<Block, LootTable.Builder> berryBushDrop(Block bushBlock, Item berryItem,
                                                            RegistryWrapper.Impl<Enchantment> impl){
        return block -> applyExplosionDecay(block,
                LootTable.builder().pool(
                        LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(bushBlock).
                                                properties(StatePredicate.Builder.create().
                                                        exactMatch(SweetBerryBushBlock.AGE, 3)))
                                .with(ItemEntry.builder(berryItem))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                ).pool(
                        LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(bushBlock)
                                                .properties(StatePredicate.Builder.create().
                                                        exactMatch(SweetBerryBushBlock.AGE, 2)))
                                .with(ItemEntry.builder(berryItem))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                ));
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.HEATHER);
        addDrop(ModBlocks.WILD_OAT, ModItems.OAT_SEEDS);
        addDrop(ModBlocks.OAT_CROP, readyCropDrops(ModBlocks.OAT_CROP, ModItems.OAT, ModItems.OAT_SEEDS));
        addDrop(ModBlocks.CRANBERRY_BUSH, berryBushDrop(ModBlocks.CRANBERRY_BUSH, ModItems.CRANBERRIES, impl));
    }
}