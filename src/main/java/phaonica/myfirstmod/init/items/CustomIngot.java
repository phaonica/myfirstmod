package phaonica.myfirstmod.init.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import phaonica.myfirstmod.MyFirstMod;

public class CustomIngot extends Item {
	
	public CustomIngot(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(MyFirstMod.tutorial_tab);
	}

}
