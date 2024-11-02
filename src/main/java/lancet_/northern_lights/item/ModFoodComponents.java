package lancet_.northern_lights.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent HEATHER_HONEY_BOTTLE = new FoodComponent.Builder().nutrition(8).saturationModifier(0.3f).build();
    public static final FoodComponent DOUGH_DEFAULT = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 0.3f).build();
}
