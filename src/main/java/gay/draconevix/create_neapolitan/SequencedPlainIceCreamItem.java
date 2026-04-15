package gay.draconevix.create_neapolitan;

import com.simibubi.create.AllDataComponents;
import net.createmod.catnip.theme.Color;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class SequencedPlainIceCreamItem extends PlainIceCreamItem {
	public SequencedPlainIceCreamItem(Properties builder) {
		super(builder);
	}

	public float getProgress(ItemStack stack) {
		if (!stack.has(AllDataComponents.SEQUENCED_ASSEMBLY))
			return 0;
		//noinspection DataFlowIssue
		return stack.get(AllDataComponents.SEQUENCED_ASSEMBLY).progress();
	}

	@Override
	public boolean isBarVisible(@NotNull ItemStack stack) {
		return getProgress(stack) != 0;
	}

	@Override
	public int getBarWidth(@NotNull ItemStack stack) {
		return Math.round(getProgress(stack) * 13);
	}

	@Override
	public int getBarColor(@NotNull ItemStack stack) {
		return Color.mixColors(0xFF_FFC074, 0xFF_46FFE0, getProgress(stack));
	}
}
