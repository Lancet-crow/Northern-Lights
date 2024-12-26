package lancet_.northern_lights.datagen;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.block.custom.CranberryBushBlock;
import lancet_.northern_lights.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
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

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        addDrop(ModBlocks.HEATHER);
        addDrop(ModBlocks.WILD_OAT, ModItems.OAT_SEEDS);
        addDrop(ModBlocks.OAT_CROP, cropDrops(ModBlocks.OAT_CROP, ModItems.OAT, ModItems.OAT_SEEDS,
                BlockStatePropertyLootCondition.builder(ModBlocks.OAT_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7))));
        addDrop(
                ModBlocks.CRANBERRY_BUSH,
                block -> applyExplosionDecay(
                        block,
                        LootTable.builder().pool(
                                LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.CRANBERRY_BUSH).
                                                properties(StatePredicate.Builder.create().
                                                        exactMatch(CranberryBushBlock.AGE, 3)))
                                        .with(ItemEntry.builder(ModItems.CRANBERRIES))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                ).pool(
                                LootPool.builder().conditionally(
                                        BlockStatePropertyLootCondition.builder(ModBlocks.CRANBERRY_BUSH)
                                                .properties(StatePredicate.Builder.create().
                                                        exactMatch(CranberryBushBlock.AGE, 2)))
                                        .with(ItemEntry.builder(ModItems.CRANBERRIES))
                                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                                        .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))
                                )
                )
        );
    }
}
