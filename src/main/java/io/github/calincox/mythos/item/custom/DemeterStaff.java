package io.github.calincox.mythos.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;

public class DemeterStaff extends Item { 

    private static final Map<Block, Block> DEMETERSTAFF_MAP = 
    Map.of(
        Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE,
        Blocks.STONE_BRICKS, Blocks.MOSSY_STONE_BRICKS
    );

    public DemeterStaff(Properties properties){
        super(properties);
    }
    
    @Override //override minecraft's "intended functionality" for an object it doesn't know exists.
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel(); //get the level from context parameter
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock(); 
         //pass level to get block state of ?block at clicked position -- work backwards to create clickedBlock.
       
         if (DEMETERSTAFF_MAP.containsKey(clickedBlock)) { //if what I'm looking at is on my list...
            if (!level.isClientSide()) { //and I'm on the server side, NOT THE CLIENT...
                level.setBlockAndUpdate(context.getClickedPos(), DEMETERSTAFF_MAP.get(clickedBlock).defaultBlockState());
           //set the block that I am looking at to the other entry in my key, at its default block state -- and the then update the blocks.

            context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                    //get it from context, damage it, and then superimpose it over the other item in the mainhand
                item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                    //while being sure not to stack underflow by called the "onEquippedItemBroken" event.

            level.playSound(context.getPlayer(), context.getClickedPos(), SoundEvents.ENDERMAN_SCREAM, SoundSource.BLOCKS);
            //play a local sound, given a player, a position for the sound, a soundEvent audio file, and a SoundSource for volume sliders.

           
           
           
            } 
        
        
        
        }

    

       

        
        return InteractionResult.SUCCESS;

    }

    

     @Override
     public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.mythos.MasterBolt.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.mythos.masterbolt"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
