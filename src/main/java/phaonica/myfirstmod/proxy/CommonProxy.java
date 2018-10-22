package phaonica.myfirstmod.proxy;

import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import phaonica.myfirstmod.handlers.RegistryHandler;

//THIS IS THE MULTI-PLAYER SERVER SIDE
public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.Common();
	}
	

	public void init(FMLInitializationEvent event)
	{
		
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
}
