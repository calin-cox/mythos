package io.github.calincox.mythos;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(items.MODID)
public class blocks {

    public static final String MODID = "mythos";
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

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
            public static final DeferredBlock<Block> onyx = BLOCKS.registerSimpleBlock("onyx", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> onyx_item = ITEMS.registerSimpleBlockItem("onyx", onyx );
            // cobbled onyx
            public static final DeferredBlock<Block> cobbled_onyx = BLOCKS.registerSimpleBlock("cobbled_onyx", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> cobbled_onyx_item = ITEMS.registerSimpleBlockItem("cobbled_onyx", cobbled_onyx );
            //smooth onyx
            public static final DeferredBlock<Block> smooth_onyx = BLOCKS.registerSimpleBlock("smooth_onyx", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> smooth_onyx_item = ITEMS.registerSimpleBlockItem("smooth_onyx", smooth_onyx );
            //onyx bricks
            public static final DeferredBlock<Block> onyx_brick = BLOCKS.registerSimpleBlock("onyx_brick", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> onyx_brick_item = ITEMS.registerSimpleBlockItem("onyx_brick", onyx_brick );
            //chiseled onyx bricks
            public static final DeferredBlock<Block> chiseled_onyx_brick = BLOCKS.registerSimpleBlock("chiseled_onyx_brick", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> chiseled_onyx_brick_item = ITEMS.registerSimpleBlockItem("chiseled_onyx_brick", chiseled_onyx_brick );
            //cracked onyx bricks
            public static final DeferredBlock<Block> cracked_onyx_brick = BLOCKS.registerSimpleBlock("cracked_onyx_brick", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> cracked_onyx_brick_item = ITEMS.registerSimpleBlockItem("cracked_onyx_brick", cracked_onyx_brick );
            //mossy onyx bricks
            public static final DeferredBlock<Block> mossy_onyx_brick = BLOCKS.registerSimpleBlock("mossy_onyx_brick", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> mossy_onyx_brick_item = ITEMS.registerSimpleBlockItem("mossy_onyx_brick", mossy_onyx_brick );
            //onyx pillars
            public static final DeferredBlock<Block> onyx_pillar = BLOCKS.registerSimpleBlock("onyx_pillar", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> onyx_pillar_item = ITEMS.registerSimpleBlockItem("onyx_pillar", onyx_pillar);
            //cracked onyx pillars
            public static final DeferredBlock<Block> cracked_onyx_pillar = BLOCKS.registerSimpleBlock("cracked_onyx_pillar", BlockBehaviour.Properties.of().jumpFactor(1/2));
            public static final DeferredItem<BlockItem> cracked_onyx_pillar_item = ITEMS.registerSimpleBlockItem("cracked_onyx_pillar", cracked_onyx_pillar);

        //FANCYBLOCKS (for labyrinth use)
            public static final DeferredBlock<Block> mycenean_brick = BLOCKS.registerSimpleBlock("mycenean_brick", BlockBehaviour.Properties.of().destroyTime(-1));
            public static final DeferredBlock<Block> chiseled_mycenean_brick = BLOCKS.registerSimpleBlock("chiseled_mycenean_brick", BlockBehaviour.Properties.of().destroyTime(-1));
            public static final DeferredBlock<Block> mycenean_pillar = BLOCKS.registerSimpleBlock("mycenean_pillar", BlockBehaviour.Properties.of().destroyTime(-1));
            public static final DeferredBlock<Block> labyrinth_portal_frame = BLOCKS.registerSimpleBlock("labyrinth_portal_frame", BlockBehaviour.Properties.of().destroyTime(-1));

    //adding blocks to creative menu
    public void addCreative(BuildCreativeModeTabContentsEvent event)
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


        public blocks(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }
        
    }
