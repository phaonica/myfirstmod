package phaonica.myfirstmod.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import phaonica.myfirstmod.init.BlockInit;
import phaonica.myfirstmod.init.ItemInit;

public class TutorialTab extends CreativeTabs
{
	public TutorialTab(String label)
	{
		super("tutorial_tab");
		this.setBackgroundImageName("tutorial.png");
	}

	@Override
	public ItemStack getTabIconItem()
	{
		// return new ItemStack(ItemInit.tutorial_ingot); // this uses an item
		return new ItemStack(Item.getItemFromBlock(BlockInit.tutorial_ore)); // this uses a block
	}

}
