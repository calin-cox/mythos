package io.github.calincox.mythos;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MythosRegistry.MODID)
public class MythosRegistry
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "mythos";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "mythos" namespace
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "mythos" namespace
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "mythos" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Creates a new Block with the id "mythos:example_block", combining the namespace and path
   
    //Blocks
        
        //Marble, the Paradigm. Notice the itemstate of the block is implemented here, rather than with items.
    public static final DeferredBlock<Block> marble = BLOCKS.registerSimpleBlock("marble", BlockBehaviour.Properties.of().mapColor(MapColor.STONE).destroyTime(3/2).speedFactor(4/3));
        // Creates a new BlockItem with the id "mythos:example_block", combining the namespace and path
        public static final DeferredItem<BlockItem> marble_item = ITEMS.registerSimpleBlockItem("marble", marble);

        //variants of marble
            //polished marble
            public static final DeferredBlock<Block> polished_marble = BLOCKS.registerSimpleBlock("polished_marble", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY));
            public static final DeferredItem<BlockItem> polished_marble_item = ITEMS.registerSimpleBlockItem("polished_marble", polished_marble);
            //cut marble
            public static final DeferredBlock<Block> cut_marble = BLOCKS.registerSimpleBlock("cut_marble", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY));
            public static final DeferredItem<BlockItem> cut_marble_item = ITEMS.registerSimpleBlockItem("cut_marble", cut_marble);
            //marble pillars!
            public static final DeferredBlock<Block> marble_pillar = BLOCKS.registerSimpleBlock("marble_pillar", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY));
            public static final DeferredItem<BlockItem> marble_pillar_item = ITEMS.registerSimpleBlockItem("marble_pillar", marble_pillar);
            //cracked marble pillars!
            public static final DeferredBlock<Block> cracked_marble_pillar = BLOCKS.registerSimpleBlock("cracked_marble_pillar", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY));
            public static final DeferredItem<BlockItem> cracked_marble_pillar_item = ITEMS.registerSimpleBlockItem("cracked_marble_pillar", cracked_marble_pillar);
            //mosaic tiles!
            public static final DeferredBlock<Block> marble_mosaic = BLOCKS.registerSimpleBlock("marble_mosaic", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY));
            public static final DeferredItem<BlockItem> marble_mosaic_item = ITEMS.registerSimpleBlockItem("marble_mosaic", marble_mosaic);

        //onyx!
            public static final DeferredBlock<Block> onyx = BLOCKS.registerSimpleBlock("onyx", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> onyx_item = ITEMS.registerSimpleBlockItem("onyx", onyx );
            // cobbled onyx
            public static final DeferredBlock<Block> cobbled_onyx = BLOCKS.registerSimpleBlock("cobbled_onyx", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> cobbled_onyx_item = ITEMS.registerSimpleBlockItem("cobbled_onyx", cobbled_onyx );
            //smooth onyx
            public static final DeferredBlock<Block> smooth_onyx = BLOCKS.registerSimpleBlock("smooth_onyx", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> smooth_onyx_item = ITEMS.registerSimpleBlockItem("smooth_onyx", smooth_onyx );
            //onyx bricks
            public static final DeferredBlock<Block> onyx_brick = BLOCKS.registerSimpleBlock("onyx_brick", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> onyx_brick_item = ITEMS.registerSimpleBlockItem("onyx_brick", onyx_brick );
            //chiseled onyx bricks
            public static final DeferredBlock<Block> chiseled_onyx_brick = BLOCKS.registerSimpleBlock("chiseled_onyx_brick", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> chiseled_onyx_brick_item = ITEMS.registerSimpleBlockItem("chiseled_onyx_brick", chiseled_onyx_brick );
            //cracked onyx bricks
            public static final DeferredBlock<Block> cracked_onyx_brick = BLOCKS.registerSimpleBlock("cracked_onyx_brick", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> cracked_onyx_brick_item = ITEMS.registerSimpleBlockItem("cracked_onyx_brick", cracked_onyx_brick );
            //mossy onyx bricks
            public static final DeferredBlock<Block> mossy_onyx_brick = BLOCKS.registerSimpleBlock("mossy_onyx_brick", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> mossy_onyx_brick_item = ITEMS.registerSimpleBlockItem("mossy_onyx_brick", mossy_onyx_brick );
            //onyx pillars
            public static final DeferredBlock<Block> onyx_pillar = BLOCKS.registerSimpleBlock("onyx_pillar", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> onyx_pillar_item = ITEMS.registerSimpleBlockItem("onyx_pillar", onyx_pillar);
            //cracked onyx pillars
            public static final DeferredBlock<Block> cracked_onyx_pillar = BLOCKS.registerSimpleBlock("cracked_onyx_pillar", BlockBehaviour.Properties.of().isRedstoneConductor(null).jumpFactor(1/2));
            public static final DeferredItem<BlockItem> cracked_onyx_pillar_item = ITEMS.registerSimpleBlockItem("cracked_onyx_pillar", cracked_onyx_pillar);

        //FANCYBLOCKS (for labyrinth use)
            public static final DeferredBlock<Block> mycenean_brick = BLOCKS.registerSimpleBlock("mycenean_brick", BlockBehaviour.Properties.of().destroyTime(-1));
            public static final DeferredBlock<Block> chiseled_mycenean_brick = BLOCKS.registerSimpleBlock("chiseled_mycenean_brick", BlockBehaviour.Properties.of().destroyTime(-1));
            public static final DeferredBlock<Block> mycenean_pillar = BLOCKS.registerSimpleBlock("mycenean_pillar", BlockBehaviour.Properties.of().destroyTime(-1));
     
     
    //Items
     
        //Ash
        public static final DeferredItem<Item> ash = ITEMS.registerSimpleItem("ash", new Item.Properties().stacksTo(24));
        //Ichor
        public static final DeferredItem<Item> ichor = ITEMS.registerSimpleItem("ichor", new Item.Properties()); 

        // Creates a new food item with the id "mythos:ambrosia", nutrition 1 and saturation 2
        public static final DeferredItem<Item> ambrosia = ITEMS.registerSimpleItem("ambrosia", new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build()));

    // Creates a creative tab with the id "mythos:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mythos")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ambrosia.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ambrosia.get());
                output.accept(ash.get());
                output.accept(ichor.get());
                // Add items and other unique things to the creative menu here. This method is preferred over the event (ln 145) for most things.
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public MythosRegistry(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (mythos) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code -- not sure what this does
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // creative mode item tab registration -- important for testing without JEI / REI / other Dataminers -- 
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        //marble -- notice that it is currently being registered to the Vanilla BUILDING BLOCKS tab. 
        //There is other creative mode registration for the custom tab later.
            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(marble_item);

            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(marble_mosaic_item);

            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(marble_pillar_item);

            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(cracked_marble_pillar_item);

            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(polished_marble_item);

            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(cut_marble_item);

            
        //onyx. see prior note.
            if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(onyx_item);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
