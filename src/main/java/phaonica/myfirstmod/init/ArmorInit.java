package phaonica.myfirstmod.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import phaonica.myfirstmod.Reference;
import phaonica.myfirstmod.init.armor.CustomArmor;
import phaonica.myfirstmod.init.items.CustomIngot;

public class ArmorInit 
{
	// SEE ARMORMATERIAL.CLASS FOR VANILLA VALUES
	private static String name = "tutorial";
	private static String textureName = Reference.MOD_ID + ":tutorial";
	private static int durability = 25;
	private static int[] reductionAmounts = new int[] {3,5,7,2};
	private static int enchantability = 8;
	private static SoundEvent soundOnEquip = SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
	private static float toughness = 1.5F;

	public static final ArmorMaterial tutorial_armor = EnumHelper.addArmorMaterial(name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness);
	
	public static Item tutorial_helmet; // could add ", tutorial_ingot_2;" etc...
	
	public static void init()
	{
		
		ArmorMaterial materialIn = tutorial_armor;
		int renderIndexIn = 1;
		EntityEquipmentSlot equipmentSlotIn = EntityEquipmentSlot.HEAD;
		
		tutorial_helmet = new CustomArmor("tutorial_helmet", materialIn, renderIndexIn, equipmentSlotIn);
	}
	
	public static void register()
	{
		registerItem(tutorial_helmet);
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
