package dev.subortus.orespiders.datagen.item;

import dev.subortus.orespiders.OreSpidersMod;
import dev.subortus.orespiders.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, OreSpidersMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.COAL_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.QUARTZ_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.LAPIS_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.REDSTONE_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.ENDER_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GOLDEN_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.IRON_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.DIAMOND_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.EMERALD_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.OBSIDIAN_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.GLOWSTONE_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.NETHERITE_SPIDER_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        simpleItem(ModItems.DIAMOND_NUGGET, "generated");
        simpleItem(ModItems.QUEEN_SPIDER_EYE, "generated");
        simpleItem(ModItems.MYSTERIOUS_POTION, "generated");
        simpleItem(ModItems.ORB_WEAVER_PROJECTILE, "generated");
        simpleItem(ModItems.ORB_WEAVER, "handheld");

    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String type){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/"+type)).texture("layer0",
                new ResourceLocation(OreSpidersMod.MOD_ID, "item/" + item.getId().getPath()));
    }


}
