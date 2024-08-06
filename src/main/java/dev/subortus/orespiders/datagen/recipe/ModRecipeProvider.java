package dev.subortus.orespiders.datagen.recipe;

import dev.subortus.orespiders.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.DIAMOND)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.DIAMOND_NUGGET.get())
                .unlockedBy(getHasName(ModItems.DIAMOND_NUGGET.get()), has(ModItems.DIAMOND_NUGGET.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DIAMOND_NUGGET.get(), 9)
                .requires(Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND), has(Items.DIAMOND))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.QUEEN_SPIDER_EYE.get())
                .pattern("DRI")
                .pattern("EGL")
                .pattern("SCS")
                .define('S', Items.SPIDER_EYE)
                .define('C', Items.COAL)
                .define('G', Items.GOLD_INGOT)
                .define('E', Items.EMERALD)
                .define('L', Items.LAPIS_LAZULI)
                .define('D', Items.DIAMOND)
                .define('R', Items.REDSTONE)
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.SPIDER_EYE), has(Items.SPIDER_EYE))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MYSTERIOUS_POTION.get())
                .pattern("EGE")
                .pattern("GBG")
                .pattern("EGE")
                .define('E', ModItems.QUEEN_SPIDER_EYE.get())
                .define('G', Items.GUNPOWDER)
                .define('B', Items.GLASS_BOTTLE)
                .unlockedBy(getHasName(ModItems.QUEEN_SPIDER_EYE.get()), has(ModItems.QUEEN_SPIDER_EYE.get()))
                .save(pWriter);

    }


}
