package phaonica.myfirstmod.init.blocks.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import phaonica.myfirstmod.util.IMetaName;

public class ItemBlockVariants extends ItemBlock
{

	public ItemBlockVariants(Block block)
	{
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		// planks _ variant
		// planks _ aluminium
		return super.getUnlocalizedName() + "_" + ((IMetaName)this.block).getSpecialName(stack);
	}
	
	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}

}
