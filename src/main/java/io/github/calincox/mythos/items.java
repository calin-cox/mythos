package io.github.calincox.mythos;

import org.slf4j.Logger;


import com.mojang.logging.LogUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
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
@Mod(items.MODID)
public class items
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
            public static final DeferredItem<Item> celestial_bronze_ingot = ITEMS.registerSimpleItem("celestial_bronze_ingot", new Item.Properties());
            public static final DeferredItem<Item> celestial_bronze_nugget = ITEMS.registerSimpleItem("celestial_bronze_nugget", new Item.Properties());
            


            //CB tools
            //TODO: make tools functional

            //but first, TIERS! #TODO
    public static final Tier CELESTIAL_BRONZE_TIER = new SimpleTier(
        // The tag that determines what blocks this tool cannot break.
        BlockTags.INCORRECT_FOR_DIAMOND_TOOL ,
        // Determines the durability of the tier.
            1000,
        // Determines the mining speed of the tier. Unused by swords.
            8,
        // Determines the attack damage bonus. Different tools use this differently. For example, swords do (getAttackDamageBonus() + 4) damage.
            2.5f,
        // Determines the enchantability of the tier. This represents how good the enchantments on this tool will be.
            25,
        // Determines the repair ingredient of the tier. Use a supplier for lazy initializing.
            () -> Ingredient.of(celestial_bronze_ingot.get())
        );


            public static final DeferredItem<SwordItem> celestial_bronze_sword = ITEMS.register("celestial_bronze_sword", () -> new SwordItem(
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

            public static final DeferredItem<PickaxeItem> celestial_bronze_pickaxe = ITEMS.register("celestial_bronze_pickaxe", () -> new PickaxeItem(
        // The tier to use.
        CELESTIAL_BRONZE_TIER,
        // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
            // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                PickaxeItem.createAttributes(
                    // The tier to use.
                    CELESTIAL_BRONZE_TIER,
                    // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                    1,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                    // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                    -2.8f
            
                    )
            
                )
            )
            );

            public static final DeferredItem<AxeItem> celestial_bronze_axe = ITEMS.register("celestial_bronze_axe", () -> new AxeItem(
        // The tier to use.
        CELESTIAL_BRONZE_TIER,
            new Item.Properties().attributes(
                AxeItem.createAttributes(
                    CELESTIAL_BRONZE_TIER,
                    // The type-specific attack damage bonus.
                    3,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4.
                    -2.4f
                    )
                )
            )
            );
            
            public static final DeferredItem<ShovelItem> celestial_bronze_shovel = ITEMS.register("celestial_bronze_shovel", () -> new ShovelItem(
        // The tier to use.
        CELESTIAL_BRONZE_TIER,
        // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
            // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                ShovelItem.createAttributes(
                    // The tier to use.
                    CELESTIAL_BRONZE_TIER,
                    // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                    1.5f,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                    // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                    -3f
            
                    )
            
                )
            )
            );
            
            public static final DeferredItem<HoeItem> celestial_bronze_hoe = ITEMS.register("celestial_bronze_hoe", () -> new HoeItem(
                // The tier to use.
                CELESTIAL_BRONZE_TIER,
                    new Item.Properties().attributes(
                        HoeItem.createAttributes(
                            CELESTIAL_BRONZE_TIER,
                            // The type-specific attack damage bonus.
                            3,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4.
                            -2.4f
                            )
                        )
                    )
                    );
           
           //CB Armor
           //TODO: make armor functional
           /*  public static final DeferredItem<Item> celestial_bronze_helmet = ITEMS.registerItem("celestial_bronze_helmet", null);
            public static final DeferredItem<Item> celestial_bronze_chestplate = ITEMS.registerItem("celestial_bronze_chestplate", null);
            public static final DeferredItem<Item> celestial_bronze_leggings = ITEMS.registerItem("celestial_bronze_leggings", null);
            public static final DeferredItem<Item> celestial_bronze_boots = ITEMS.registerItem("celestial_bronze_boots", null);*/

        //Stygian Iron
            public static final DeferredBlock<Block> stygian_iron_block = BLOCKS.registerSimpleBlock("stygian_iron_block", BlockBehaviour.Properties.of().explosionResistance(25));
            public static final DeferredItem<BlockItem> stygian_iron_block_item = ITEMS.registerSimpleBlockItem("stygian_iron_block", stygian_iron_block);
            public static final DeferredItem<Item> stygian_iron_ingot = ITEMS.registerSimpleItem("stygian_iron_ingot", new Item.Properties());
            public static final DeferredItem<Item> stygian_iron_nugget = ITEMS.registerSimpleItem("stygian_iron_nugget", new Item.Properties());

        //SI Tier
        public static final Tier STYGIAN_IRON_TIER = new SimpleTier(
            // The tag that determines what blocks this tool cannot break.
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL ,
            // Determines the durability of the tier.
                3000,
            // Determines the mining speed of the tier. Unused by swords.
                16,
            // Determines the attack damage bonus. Different tools use this differently. For example, swords do (getAttackDamageBonus() + 4) damage.
                4,
            // Determines the enchantability of the tier. This represents how good the enchantments on this tool will be.
                22,
            // Determines the repair ingredient of the tier. Use a supplier for lazy initializing.
                () -> Ingredient.of(stygian_iron_ingot.get())
            );
            
            //SI tools
            public static final DeferredItem<SwordItem> stygian_iron_sword = ITEMS.register("stygian_iron_sword", () -> new SwordItem(
        // The tier to use.
        STYGIAN_IRON_TIER,
        // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
            // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                SwordItem.createAttributes(
                    // The tier to use.
                    STYGIAN_IRON_TIER,
                    // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                    3,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                    -2.4f
                    )
            
                )
            )
            );

            public static final DeferredItem<PickaxeItem> stygian_iron_pickaxe = ITEMS.register("stygian_iron_pickaxe", () -> new PickaxeItem(
        // The tier to use.
        STYGIAN_IRON_TIER,
        // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
            // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                PickaxeItem.createAttributes(
                    // The tier to use.
                    STYGIAN_IRON_TIER,
                    // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                    1,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                    // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                    -2.8f
            
                    )
            
                )
            )
            );

            public static final DeferredItem<AxeItem> stygian_iron_axe = ITEMS.register("stygian_iron_axe", () -> new AxeItem(
        // The tier to use.
        STYGIAN_IRON_TIER,
            new Item.Properties().attributes(
                AxeItem.createAttributes(
                    STYGIAN_IRON_TIER,
                    // The type-specific attack damage bonus.
                    3,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4.
                    -2.4f
                    )
                )
            )
            );
            
            public static final DeferredItem<ShovelItem> stygian_iron_shovel = ITEMS.register("stygian_iron_shovel", () -> new ShovelItem(
        // The tier to use.
        STYGIAN_IRON_TIER,
        // The item properties. We don't need to set the durability here because TieredItem handles that for us.
            new Item.Properties().attributes(
            // There are `createAttributes` methods in either the class or subclass of each DiggerItem
                ShovelItem.createAttributes(
                    // The tier to use.
                    STYGIAN_IRON_TIER,
                    // The type-specific attack damage bonus. 3 for swords, 1.5 for shovels, 1 for pickaxes, varying for axes and hoes.
                    1.5f,
                    // The type-specific attack speed modifier. The player has a default attack speed of 4, so to get to the desired
                    // value of 1.6f, we use -2.4f. -2.4f for swords, -3f for shovels, -2.8f for pickaxes, varying for axes and hoes.
                    -3f
            
                    )
            
                )
            )
            );
            
            public static final DeferredItem<HoeItem> stygian_iron_hoe = ITEMS.register("stygian_iron_hoe", () -> new HoeItem(
                // The tier to use.
                STYGIAN_IRON_TIER,
                    new Item.Properties().attributes(
                        HoeItem.createAttributes(
                            STYGIAN_IRON_TIER,
                            // The type-specific attack damage bonus.
                            3,
                            // The type-specific attack speed modifier. The player has a default attack speed of 4.
                            -2.4f
                            )
                        )
                    )
                    );
           //SI Armor
           //TODO: make armor functional
           /* public static final DeferredItem<Item> stygian_iron_helmet = ITEMS.registerItem("stygian_iron_helmet", null);
            public static final DeferredItem<Item> stygian_iron_chestplate = ITEMS.registerItem("stygian_iron_chestplate", null);
            public static final DeferredItem<Item> stygian_iron_leggings = ITEMS.registerItem("stygian_iron_leggings", null);
            public static final DeferredItem<Item> stygian_iron_boots = ITEMS.registerItem("stygian_iron_boots", null); */

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
                /* output.accept(celestial_bronze_helmet.get());
                output.accept(celestial_bronze_chestplate.get());
                output.accept(celestial_bronze_leggings.get());
                output.accept(celestial_bronze_boots.get()); */

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
                /* output.accept(stygian_iron_helmet.get());
                output.accept(stygian_iron_chestplate.get());
                output.accept(stygian_iron_leggings.get());
                output.accept(stygian_iron_boots.get()); */
                // Add items and other unique things to the creative menu here. This method is preferred over the event (ln 145) for most things.
            }).build());

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public items(IEventBus modEventBus, ModContainer modContainer)
    {
       

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
    }
    
}