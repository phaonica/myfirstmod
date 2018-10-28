package phaonica.myfirstmod.handlers;

import net.minecraftforge.fml.common.registry.GameRegistry;
import phaonica.myfirstmod.gen.TutorialOreGen;
import phaonica.myfirstmod.init.ArmorInit;
import phaonica.myfirstmod.init.BlockInit;
import phaonica.myfirstmod.init.ItemInit;
import phaonica.myfirstmod.init.ToolInit;

public class RegistryHandler 
{
	public static void Client()
	{
		
	}
	
	public static void Common()
	{		
		ItemInit.init();
		ItemInit.register();	
		
		BlockInit.init();
		BlockInit.register();		
		BlockInit.registerRenders();
		
		ToolInit.init();
		ToolInit.register();
		
		ArmorInit.init();
		ArmorInit.register();
		
		RecipeHandler.registerCrafting();
		RecipeHandler.registerSmelting();
		
		GameRegistry.registerWorldGenerator(new TutorialOreGen(), 0);

	}
}
