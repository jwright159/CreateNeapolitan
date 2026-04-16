package gay.draconevix.create_neapolitan;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.slf4j.Logger;

@Mod(CreateNeapolitan.MODID)
public class CreateNeapolitan {
    public static final String MODID = "create_neapolitan";
    public static final Logger LOGGER = LogUtils.getLogger();

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, MODID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(Registries.FLUID, MODID);

    public static final IceCreamFluid PLAIN_ICE_CREAM_FLUID = new IceCreamFluid("plain_ice_cream");
    public static final IceCreamFluid VANILLA_ICE_CREAM_FLUID = new IceCreamFluid("vanilla_ice_cream");
    public static final IceCreamFluid CHOCOLATE_ICE_CREAM_FLUID = new IceCreamFluid("chocolate_ice_cream");
    public static final IceCreamFluid STRAWBERRY_ICE_CREAM_FLUID = new IceCreamFluid("strawberry_ice_cream");
    public static final IceCreamFluid MINT_ICE_CREAM_FLUID = new IceCreamFluid("mint_ice_cream");
    public static final IceCreamFluid ADZUKI_ICE_CREAM_FLUID = new IceCreamFluid("adzuki_ice_cream");
    public static final IceCreamFluid BANANA_ICE_CREAM_FLUID = new IceCreamFluid("banana_ice_cream");

    public static final DeferredItem<PlainIceCreamItem> PLAIN_ICE_CREAM = ITEMS.register("plain_ice_cream", () -> new PlainIceCreamItem(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).usingConvertsTo(Items.BOWL).build())
            .craftRemainder(Items.BOWL)
            .stacksTo(1)));
    public static final DeferredItem<SequencedPlainIceCreamItem>
            INCOMPLETE_NEAPOLITAN_ICE_CREAM = ITEMS.register("incomplete_neapolitan_ice_cream", () -> new SequencedPlainIceCreamItem(new Item.Properties()
            .food(new FoodProperties.Builder().nutrition(4).saturationModifier(0.3f).usingConvertsTo(Items.BOWL).build())
            .craftRemainder(Items.BOWL)
            .stacksTo(1)));

    public CreateNeapolitan(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
        FLUID_TYPES.register(modEventBus);
        FLUIDS.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(PLAIN_ICE_CREAM.get());
        }
    }
}
