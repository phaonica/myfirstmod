package phaonica.myfirstmod.handlers;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import phaonica.myfirstmod.init.BlockInit;
import phaonica.myfirstmod.init.ItemInit;

public class RecipeHandler
{
	public static void registerCrafting()
	{
		ResourceLocation name = new ResourceLocation("phaomfm:tutorial_ore");
		ResourceLocation group = new ResourceLocation("phaomfm:tutorial_blocks");
		ItemStack output = new ItemStack(BlockInit.tutorial_ore);
		Object[] params = new Object[] {"SSS","SIS","SSS", 'S', Blocks.STONE, 'I', ItemInit.tutorial_ingot};
		
		GameRegistry.addShapedRecipe(name, group, output, params);
		
		
	}
	
	public static void registerSmelting()
	{
		Block input = BlockInit.tutorial_ore;
		ItemStack output = new ItemStack(ItemInit.tutorial_ingot);
		float xp = 10;
		
		GameRegistry.addSmelting(input, output, xp);
	}
}
