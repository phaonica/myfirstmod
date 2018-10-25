package phaonica.myfirstmod.handlers;

import phaonica.myfirstmod.init.BlockInit;
import phaonica.myfirstmod.init.ItemInit;

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

	}
}
