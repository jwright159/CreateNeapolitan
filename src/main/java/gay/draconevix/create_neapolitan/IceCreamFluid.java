package gay.draconevix.create_neapolitan;

import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;

public class IceCreamFluid {
	public final DeferredHolder<FluidType, FluidType> FLUID_TYPE;
	public final DeferredHolder<Fluid, BaseFlowingFluid.Source> SOURCE;
	public final DeferredHolder<Fluid, BaseFlowingFluid.Flowing> FLOWING;

	public IceCreamFluid(String name) {
		BaseFlowingFluid.Properties properties = new BaseFlowingFluid.Properties(this::getFluidType, this::getSource, this::getFlowing);
		FLUID_TYPE = CreateNeapolitan.FLUID_TYPES.register(name, () -> new FluidType(FluidType.Properties.create()));
		SOURCE = CreateNeapolitan.FLUIDS.register(name, () -> new BaseFlowingFluid.Source(properties));
		FLOWING = CreateNeapolitan.FLUIDS.register("flowing_" + name, () -> new BaseFlowingFluid.Flowing(properties));
	}

	public FluidType getFluidType() {
		return FLUID_TYPE.get();
	}

	public BaseFlowingFluid.Source getSource() {
		return SOURCE.get();
	}

	public BaseFlowingFluid.Flowing getFlowing() {
		return FLOWING.get();
	}
}
