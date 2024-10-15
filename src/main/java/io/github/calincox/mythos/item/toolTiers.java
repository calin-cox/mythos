package io.github.calincox.mythos.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;


public class toolTiers
{



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
            () -> Ingredient.of(modItems.celestial_bronze_ingot.get())
        );


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
                () -> Ingredient.of(modItems.stygian_iron_ingot.get())
            );
}