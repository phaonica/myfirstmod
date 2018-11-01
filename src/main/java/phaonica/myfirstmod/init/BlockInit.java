package phaonica.myfirstmod.init;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import phaonica.myfirstmod.MyFirstMod;
import phaonica.myfirstmod.init.blocks.CustomOre;

public class BlockInit 
{
	
	public static Block tutorial_ore;
	
	public static void init()
	{
		tutorial_ore = new CustomOre("tutorial_ore", 2.0F, 4.0F, 2);
	}
	
	public static void register()
	{
		registerBlock(tutorial_ore);
	}
	
	public static void registerBlock(Block block)
	{
		// GameRegistry.register(block);
		ForgeRegistries.BLOCKS.register(block);
		
		block.setCreativeTab(MyFirstMod.tutorial_tab);		
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		
		// GameRegistry.register(block);
		ForgeRegistries.ITEMS.register(item);

		Item item2 = Item.getItemFromBlock(block);
		int metadata = 0; // no metadata for this item		
		ResourceLocation name = block.getRegistryName();
		ModelResourceLocation model = new ModelResourceLocation(name , "inventory");
		ModelLoader.setCustomModelResourceLocation(item2, metadata, model);
	}
	
}
