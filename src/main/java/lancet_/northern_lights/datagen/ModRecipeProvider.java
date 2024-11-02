package lancet_.northern_lights.datagen;

import lancet_.northern_lights.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerShapelessRecipe(exporter, Items.SUGAR, ModItems.HEATHER_HONEY_BOTTLE, "sugar", 5);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.OAT_DOUGH)
                .input(Items.EGG).input(ModItems.OAT, 3)
                .criterion(hasItem(ModItems.OAT), conditionsFromItem(ModItems.OAT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OAT_DOUGH)+"_from_eggs"));
        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.OAT_DOUGH)
                .input(Items.WATER_BUCKET).input(ModItems.OAT, 3)
                .criterion(hasItem(ModItems.OAT), conditionsFromItem(ModItems.OAT))
                .offerTo(exporter, Identifier.of(getRecipeName(ModItems.OAT_DOUGH)+"_from_water"));
    }
}
