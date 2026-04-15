package gay.draconevix.create_neapolitan;

import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import org.jetbrains.annotations.NotNull;

public class IceCreamFluidClient {
	public static void registerFluidClientExtensions(RegisterClientExtensionsEvent event) {
		registerIceCreamFluidClient(event, CreateNeapolitan.PLAIN_ICE_CREAM_FLUID);
		registerIceCreamFluidClient(event, CreateNeapolitan.VANILLA_ICE_CREAM_FLUID);
		registerIceCreamFluidClient(event, CreateNeapolitan.CHOCOLATE_ICE_CREAM_FLUID);
		registerIceCreamFluidClient(event, CreateNeapolitan.STRAWBERRY_ICE_CREAM_FLUID);
		registerIceCreamFluidClient(event, CreateNeapolitan.MINT_ICE_CREAM_FLUID);
		registerIceCreamFluidClient(event, CreateNeapolitan.ADZUKI_ICE_CREAM_FLUID);
		registerIceCreamFluidClient(event, CreateNeapolitan.BANANA_ICE_CREAM_FLUID);
	}

	public static void registerIceCreamFluidClient(RegisterClientExtensionsEvent event, IceCreamFluid fluid) {
		event.registerFluidType(new Extensions(fluid), fluid.FLUID_TYPE);
	}

	public static class Extensions implements IClientFluidTypeExtensions {
		private final ResourceLocation STILL_TEXTURE;
		private final ResourceLocation FLOWING_TEXTURE;

		public Extensions(IceCreamFluid fluid) {
			STILL_TEXTURE = ResourceLocation.fromNamespaceAndPath(CreateNeapolitan.MODID, "block/" + fluid.FLUID_TYPE.getId().getPath() + "_still");
			FLOWING_TEXTURE = ResourceLocation.fromNamespaceAndPath(CreateNeapolitan.MODID, "block/" + fluid.FLUID_TYPE.getId().getPath() + "_flowing");
		}

		@Override
		public @NotNull ResourceLocation getStillTexture() {
			return STILL_TEXTURE;
		}

		@Override
		public @NotNull ResourceLocation getFlowingTexture() {
			return FLOWING_TEXTURE;
		}
	}
}
