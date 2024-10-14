package io.github.calincox.mythos;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
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
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;
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


    //METALS AND THEIR RELATED BITS
    
        //Celestial Bronze
            public static final DeferredBlock<Block> celestial_bronze_block = BLOCKS.registerSimpleBlock("celestial_bronze_block", BlockBehaviour.Properties.of().explosionResistance(25));
            public static final DeferredItem<BlockItem> celestial_bronze_block_item = ITEMS.registerSimpleBlockItem("celestial_bronze_block", celestial_bronze_block);
            public static final DeferredItem<Item> celestial_bronze_ingot = ITEMS.registerItem("celestial_bronze_ingot", null);
            public static final DeferredItem<Item> celestial_bronze_nugget = ITEMS.registerItem("celestial_bronze_nugget", null);
            


            //CB tools
            //TODO: make tools functional

            //but first, TIERS! #TODO
    public static final Tier CELESTIAL_BRONZE_TIER = new SimpleTier(
        // The tag that determines what blocks this tool cannot break.
        BlockTags.INCORRECT_FOR_DIAMOND_TOOL ,
        // Determines the durability of the tier.
        // Stone is 131, iron is 250.
        1000,
        // Determines the mining speed of the tier. Unused by swords.
        // Stone uses 4, iron uses 6.
        8,
        // Determines the attack damage bonus. Different tools use this differently. For example, swords do (getAttackDamageBonus() + 4) damage.
        // Stone uses 1, iron uses 2, corresponding to 5 and 6 attack damage for swords, respectively.
        2.5f,
        // Determines the enchantability of the tier. This represents how good the enchantments on this tool will be.
        // Gold uses 22, we put CELESTIAL_BRONZE slightly above that.
        25,
        // Determines the repair ingredient of the tier. Use a supplier for lazy initializing.
        () -> Ingredient.of(celestial_bronze_ingot.get()));

        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ExampleMod.MOD_ID);

            public static final Supplier<Item> celestial_bronze_sword = ITEMS.register("celestial_bronze_sword", () -> new SwordItem(
        // The tier to use.
        CELESTIAL_BRONZE_TIER,
        // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
            // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                SwordItem.createAttributes(
                    // The tier to use.
                    CELESTIAL_BRONZE_TIER,
                    // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                    3,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                    // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                    -2.4f
            
                )
            )
        )
        );
            public static final DeferredItem<Item> celestial_bronze_pickaxe = ITEMS.registerItem("celestial_bronze_pickaxe", null);
            public static final DeferredItem<Item> celestial_bronze_axe = ITEMS.registerItem("celestial_bronze_axe", null);
            public static final DeferredItem<Item> celestial_bronze_shovel = ITEMS.registerItem("celestial_bronze_shovel", null);
            public static final DeferredItem<Item> celestial_bronze_hoe = ITEMS.registerItem("celestial_bronze_hoe", null);
           
           //CB Armor
           //TODO: make armor functional
            public static final DeferredItem<Item> celestial_bronze_helmet = ITEMS.registerItem("celestial_bronze_helmet", null);
            public static final DeferredItem<Item> celestial_bronze_chestplate = ITEMS.registerItem("celestial_bronze_chestplate", null);
            public static final DeferredItem<Item> celestial_bronze_leggings = ITEMS.registerItem("celestial_bronze_leggings", null);
            public static final DeferredItem<Item> celestial_bronze_boots = ITEMS.registerItem("celestial_bronze_boots", null);

        //Stygian Iron
            public static final DeferredBlock<Block> stygian_iron_block = BLOCKS.registerSimpleBlock("stygian_iron_block", BlockBehaviour.Properties.of().explosionResistance(25));
            public static final DeferredItem<BlockItem> stygian_iron_block_item = ITEMS.registerSimpleBlockItem("stygian_iron_block", stygian_iron_block);
            public static final DeferredItem<Item> stygian_iron_ingot = ITEMS.registerItem("stygian_iron_ingot", null);
            public static final DeferredItem<Item> stygian_iron_nugget = ITEMS.registerItem("stygian_iron_nugget", null);
            
            //SI tools
            //TODO: make tools functional
            public static final DeferredItem<Item> stygian_iron_sword = ITEMS.registerItem("stygian_iron_sword", null);
            public static final DeferredItem<Item> stygian_iron_pickaxe = ITEMS.registerItem("stygian_iron_pickaxe", null);
            public static final DeferredItem<Item> stygian_iron_axe = ITEMS.registerItem("stygian_iron_axe", null);
            public static final DeferredItem<Item> stygian_iron_shovel = ITEMS.registerItem("stygian_iron_shovel", null);
            public static final DeferredItem<Item> stygian_iron_hoe = ITEMS.registerItem("stygian_iron_hoe", null);
           
           //SI Armor
           //TODO: make armor functional
            public static final DeferredItem<Item> stygian_iron_helmet = ITEMS.registerItem("stygian_iron_helmet", null);
            public static final DeferredItem<Item> stygian_iron_chestplate = ITEMS.registerItem("stygian_iron_chestplate", null);
            public static final DeferredItem<Item> stygian_iron_leggings = ITEMS.registerItem("stygian_iron_leggings", null);
            public static final DeferredItem<Item> stygian_iron_boots = ITEMS.registerItem("stygian_iron_boots", null);

            // Creates a creative tab with the id "mythos:example_tab" for the example item, that is placed after the combat tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mythos")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ambrosia.get().getDefaultInstance())
           
           //don't mind me, just going to make a function entirely too long -- here goes nothing! --CMC
            .displayItems((parameters, output) -> {
                output.accept(ambrosia.get());
                output.accept(ash.get());
                output.accept(ichor.get());

                //CB
                output.accept(celestial_bronze_block_item.get());
                output.accept(celestial_bronze_ingot.get());
                output.accept(celestial_bronze_nugget.get());
                //CB TOOLS
                output.accept(celestial_bronze_sword.get());
                output.accept(celestial_bronze_pickaxe.get());
                output.accept(celestial_bronze_axe.get());
                output.accept(celestial_bronze_shovel.get());
                output.accept(celestial_bronze_hoe.get());
                //CB ARMOR
                output.accept(celestial_bronze_helmet.get());
                output.accept(celestial_bronze_chestplate.get());
                output.accept(celestial_bronze_leggings.get());
                output.accept(celestial_bronze_boots.get());

                //SI
                output.accept(stygian_iron_block_item.get());
                output.accept(stygian_iron_ingot.get());
                output.accept(stygian_iron_nugget.get());
                //CB TOOLS
                output.accept(stygian_iron_sword.get());
                output.accept(stygian_iron_pickaxe.get());
                output.accept(stygian_iron_axe.get());
                output.accept(stygian_iron_shovel.get());
                output.accept(stygian_iron_hoe.get());
                //CB ARMOR
                output.accept(stygian_iron_helmet.get());
                output.accept(stygian_iron_chestplate.get());
                output.accept(stygian_iron_leggings.get());
                output.accept(stygian_iron_boots.get());
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

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(cobbled_onyx_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(onyx_brick_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(cracked_onyx_brick_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(smooth_onyx_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(mossy_onyx_brick_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(chiseled_onyx_brick_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(onyx_pillar_item);

            if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
                event.accept(cracked_onyx_pillar_item);
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
