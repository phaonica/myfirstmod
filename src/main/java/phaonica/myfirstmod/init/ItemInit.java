package phaonica.myfirstmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import phaonica.myfirstmod.Reference;
import phaonica.myfirstmod.init.items.CustomIngot;

public class ItemInit 
{
	
	public static Item tutorial_ingot; // could add ", tutorial_ingot_2;" etc...
	
	public static void init()
	{
		tutorial_ingot = new CustomIngot("tutorial_ingot");
	}
	
	public static void register()
	{
		registerItem(tutorial_ingot);
	}

	public static void registerItem(Item item)
	{
		// GameRegistry.register(item);
		ForgeRegistries.ITEMS.register(item);
		
		// REGISTER ITEM NAME, META, AND TEXTURE		
		int metadata = 0; // no metadata for this item
		ResourceLocation name = item.getRegistryName();
		ModelResourceLocation model = new ModelResourceLocation(name, "inventory");
		ModelLoader.setCustomModelResourceLocation(item, metadata, model);

	}
}
