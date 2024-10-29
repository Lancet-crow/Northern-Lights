package lancet_.northern_lights.block;

import lancet_.northern_lights.NorthernLights;
import lancet_.northern_lights.block.custom.OatCropBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModBlocks {

    public static final Block HEATHER = registerBlock("heather",
            new FlowerBlock(createStewEffects(
                  new SuspiciousStewEffectsComponent.StewEffect(StatusEffects.INSTANT_HEALTH, 1)
            ), AbstractBlock.Settings.create()
            .mapColor(MapColor.DARK_DULL_PINK)
            .noCollision()
            .breakInstantly()
            .sounds(BlockSoundGroup.GRASS)
            .offset(AbstractBlock.OffsetType.XZ)
            .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block OAT_CROP = Registry.register(Registries.BLOCK,
            Identifier.of(NorthernLights.MOD_ID, "oat_crop"), new OatCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(NorthernLights.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(NorthernLights.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModItems() {
        NorthernLights.LOGGER.info("Started registering blocks for mod " + NorthernLights.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.add(HEATHER);
        });
    }

    private static SuspiciousStewEffectsComponent createStewEffects(SuspiciousStewEffectsComponent.StewEffect ... effects){
        return new SuspiciousStewEffectsComponent(List.of(effects));
    }
}
