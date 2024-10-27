package lancet_.northern_lights.item;

import lancet_.northern_lights.NorthernLights;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.HoneyBottleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HEATHER_HONEY_BOTTLE = registerItem("heather_honey_bottle",
            new HoneyBottleItem(new Item.Settings().recipeRemainder(Items.GLASS_BOTTLE).food(ModFoodComponents.HEATHER_HONEY_BOTTLE).maxCount(16)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(NorthernLights.MOD_ID, name), item);
    }

    public static void registerModItems(){
        NorthernLights.LOGGER.info("Started registering items for mod " + NorthernLights.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(HEATHER_HONEY_BOTTLE);
        });
    }
}
