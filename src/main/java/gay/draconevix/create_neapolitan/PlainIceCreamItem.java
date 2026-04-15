package gay.draconevix.create_neapolitan;

import com.teamabnormals.neapolitan.common.item.IceCreamItem;
import com.teamabnormals.neapolitan.common.item.MilkBottleItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class PlainIceCreamItem extends IceCreamItem {
	public PlainIceCreamItem(Properties builder) {
		super(builder);
	}

	@Override
	public @NotNull ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
		MilkBottleItem.clearRandomEffect(level, entity);
		return super.finishUsingItem(stack, level, entity);
	}
}
