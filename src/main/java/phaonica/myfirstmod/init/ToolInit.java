package phaonica.myfirstmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import phaonica.myfirstmod.Reference;
import phaonica.myfirstmod.init.items.CustomIngot;
import phaonica.myfirstmod.init.tools.CustomPickaxe;

public class ToolInit 
{
	
	
	// SEE TOOLMATERIAL.CLASS FOR VANILLA VALUES
	private static String name = "tutorial";
	private static int harvestLevel = 3; // same as diamond
	private static int maxUses = 1200; // just under diamond
	private static float efficiency = 7.0F; // just under diamond
	private static float damage = 2.5F; // just under diamond
	private static int enchantability = 8; // just under diamond

	public static final ToolMaterial tutorial_material = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damage, enchantability);
	
	public static Item tutorial_pickaxe; // could add ", tutorial_ingot_2;" etc...
	
	public static void init()
	{
		tutorial_pickaxe = new CustomPickaxe("tutorial_pickaxe", tutorial_material);
	}
	
	public static void register()
	{
		registerItem(tutorial_pickaxe);
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
