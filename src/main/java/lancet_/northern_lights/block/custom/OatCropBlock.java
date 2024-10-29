package lancet_.northern_lights.block.custom;

import lancet_.northern_lights.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class OatCropBlock extends CropBlock {
    public static final int MAX_AGE = 7;

    public static final IntProperty AGE = Properties.AGE_7;

    public OatCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.OAT_SEEDS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
