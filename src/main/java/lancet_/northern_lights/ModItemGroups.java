package lancet_.northern_lights;

import lancet_.northern_lights.block.ModBlocks;
import lancet_.northern_lights.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup NORTHERN_LIGHTS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NorthernLights.MOD_ID, "northern_lights_group"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.OAT))
                    .displayName(Text.translatable("itemGroup.northern_lights.northern_lights_group"))
                    .entries(((displayContext, entries) -> {
                        entries.add(ModBlocks.HEATHER);
                        entries.add(ModItems.HEATHER_HONEY_BOTTLE);
                        entries.add(ModItems.OAT);
                        entries.add(ModItems.OAT_DOUGH);
                        entries.add(ModItems.OAT_SEEDS);
                        entries.add(ModBlocks.WILD_OAT);
                    })).build());

    public static void registerItemGroups(){
        NorthernLights.LOGGER.info("Created ItemGroup " + NORTHERN_LIGHTS_GROUP + " for mod " + NorthernLights.MOD_ID);
    }
}
