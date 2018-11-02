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
import phaonica.myfirstmod.Reference;
import phaonica.myfirstmod.init.blocks.CustomOre;
import phaonica.myfirstmod.init.blocks.item.ItemBlockVariants;
import phaonica.myfirstmod.init.blocks.trees.CustomBlockPlanks;

public class BlockInit 
{
	
	public static Block tutorial_ore;
	
	static Block planks,leaves,log;
	
	public static void init()
	{
		tutorial_ore = new CustomOre("tutorial_ore", 2.0F, 4.0F, 2);
		planks = new CustomBlockPlanks("planks");
	}
	
	public static void register()
	{
		registerBlock(tutorial_ore);
		
		registerBlock(planks, new ItemBlockVariants(planks));
	}
	
	public static void registerBlock(Block block)
	{
		// GameRegistry.register(block);
		ForgeRegistries.BLOCKS.register(block);
		
		block.setCreativeTab(MyFirstMod.tutorial_tab);	
		
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());	
		ForgeRegistries.ITEMS.register(item);

		Item item2 = Item.getItemFromBlock(block);
		int metadata = 0; // no metadata for this item		
		ResourceLocation name = block.getRegistryName();
		ModelResourceLocation model = new ModelResourceLocation(name , "inventory");
		ModelLoader.setCustomModelResourceLocation(item2, metadata, model);
	}
	
	public static void registerBlock(Block block, ItemBlock itemBlock)
	{
		// GameRegistry.register(block);
		ForgeRegistries.BLOCKS.register(block);
		
		block.setCreativeTab(MyFirstMod.tutorial_tab);		

		itemBlock.setRegistryName(block.getRegistryName());;
		ForgeRegistries.ITEMS.register(itemBlock);

		Item item2 = Item.getItemFromBlock(block);
		int metadata = 0; // no metadata for this item		
		ResourceLocation name = block.getRegistryName();
		ModelResourceLocation model = new ModelResourceLocation(name , "inventory");
		ModelLoader.setCustomModelResourceLocation(item2, metadata, model);
	}
	
	public static void registerRenders()
	{
		for (int i = 0; i < CustomBlockPlanks.EnumType.values().length; i++)
		{
			registerRender(planks,i,"planks_" + CustomBlockPlanks.EnumType.values()[i].getName());
		}
	}
	
	public static void registerRender(Block block, int meta, String filename)
	{	
		Item item2 = Item.getItemFromBlock(block);

		ResourceLocation name = new ResourceLocation(Reference.MOD_ID,filename);		
		
		ModelResourceLocation model = new ModelResourceLocation(name , "inventory");

		ModelLoader.setCustomModelResourceLocation(item2, meta, model);
	}
	
	public static void registerBlockWithVariants(Block block, ItemBlock itemBlock)
	{
		ForgeRegistries.BLOCKS.register(block);
		
		block.setCreativeTab(MyFirstMod.tutorial_tab);
		
		itemBlock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemBlock);

		Item item2 = Item.getItemFromBlock(block);
		int metadata = 0; // no metadata for this item		
		ResourceLocation name = block.getRegistryName();
		ModelResourceLocation model = new ModelResourceLocation(name , "inventory");	
	}
	
}
