package phaonica.myfirstmod.world.gen;

import java.util.Random;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
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
	private WorldGenerator overworld, nether, end;
	
	public TutorialOreGen()
	{
		IBlockState blockstate = BlockInit.tutorial_ore.getDefaultState();
		int vein_size = 9; 
		overworld = new WorldGenMinable(blockstate, vein_size);
		
		IBlockState blockstate2 = BlockInit.tutorial_ore.getDefaultState();
		int vein_size2 = 9; 
		Predicate<IBlockState> blockmatcher2 = BlockMatcher.forBlock(Blocks.NETHERRACK);
		nether = new WorldGenMinable(blockstate2, vein_size2, blockmatcher2);
		
		IBlockState blockstate3 = BlockInit.tutorial_ore.getDefaultState();
		int vein_size3 = 9;
		Predicate<IBlockState> blockmatcher3 = BlockMatcher.forBlock(Blocks.END_STONE);
		end = new WorldGenMinable(blockstate3, vein_size3, blockmatcher3);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
			case 0: // overworld
				runGenerator(overworld, world, random, chunkX, chunkZ, 50, 0, 50);
				break;
			case 1: // end
				runGenerator(end, world, random, chunkX, chunkZ, 50, 0, 255);
				break;
			case -1: // nether
				runGenerator(nether, world, random, chunkX, chunkZ, 50, 0, 50);
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
