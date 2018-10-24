package phaonica.myfirstmod.handlers;

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
	}
}
