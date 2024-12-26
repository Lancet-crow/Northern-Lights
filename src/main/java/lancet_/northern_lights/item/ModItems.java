package lancet_.northern_lights.item;

import lancet_.northern_lights.NorthernLights;
import lancet_.northern_lights.block.ModBlocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HEATHER_HONEY_BOTTLE = registerItem("heather_honey_bottle",
            new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE)
                    .food(ModFoodComponents.HEATHER_HONEY_BOTTLE).maxCount(16)));

    public static final Item OAT = registerItem("oat", new Item(new Item.Settings()));
    public static final Item OAT_SEEDS = registerItem("oat_seeds",
            new AliasedBlockItem(ModBlocks.OAT_CROP, new Item.Settings()));
    public static final Item OAT_DOUGH = registerItem("oat_dough",
            new Item(new Item.Settings().food(ModFoodComponents.DOUGH_DEFAULT)));

    public static final Item CRANBERRIES = registerItem("cranberries",
            new AliasedBlockItem(ModBlocks.CRANBERRY_BUSH, new Item.Settings().food(ModFoodComponents.CRANBERRIES)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(NorthernLights.MOD_ID, name), item);
    }

    public static void registerModItems(){
        NorthernLights.LOGGER.info("Started registering items for mod " + NorthernLights.MOD_ID);
    }
}
