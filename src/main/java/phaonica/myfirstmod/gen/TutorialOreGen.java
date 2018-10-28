package phaonica.myfirstmod.gen;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import phaonica.myfirstmod.init.BlockInit;

public class TutorialOreGen implements IWorldGenerator
{
	private WorldGenerator tutorial_ore;
	
	public TutorialOreGen()
	{
		IBlockState blockstate = BlockInit.tutorial_ore.getDefaultState();
		int vein_size = 9; 
		tutorial_ore = new WorldGenMinable(blockstate, vein_size);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
			case 0: // overworld
				runGenerator(tutorial_ore, world, random, chunkX, chunkZ, 50, 0, 50);
				break;
			case 1: // end
				break;
			case -1: // nether
				break;
		}
	}

	private void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight)
	{
		// MAKE SURE NOTHING GENERATED OUT OF BOUNDS
		if ( minHeight > maxHeight || minHeight < 0 || maxHeight > 256 )
		{
			throw new IllegalArgumentException("Ore generated out of bounds");
		}			
		
		// CALCULATE HIGHT DIFF
		int heightDiff = maxHeight - minHeight + 1;
		
		for (int i = 0; i < chance; i++)
		{
			int x = chunkX * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunkZ * 16 + rand.nextInt(16);		
			
			gen.generate(world,  rand, new BlockPos(x,y,z));
		}
		

	}

	
	
}
