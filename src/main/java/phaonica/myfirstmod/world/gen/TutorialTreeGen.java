package phaonica.myfirstmod.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeForest;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import phaonica.myfirstmod.world.feature.tree.WorldGenTutorialTree;

public class TutorialTreeGen implements IWorldGenerator
{
	private final WorldGenerator TUTORIAL = new WorldGenTutorialTree();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.getDimension())
		{
			case 0: // over world
				runGenerator(TUTORIAL, world, random, chunkX, chunkZ, 3, -1, 0, BiomePlains.class, BiomeForest.class);
				break;
			case 1: // end

				break;
			case -1: // nether

				break;
		}
	}
	
	
	
	private void runGenerator(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, double chancesToSpawn, int minHeight, int maxHeight, Class<?>...classes)
	{
		if ( chancesToSpawn < 1 )
		{
			if (random.nextDouble() < chancesToSpawn) chancesToSpawn = 1;
			else chancesToSpawn = 0;
		}
		
		ArrayList<Class<?>>classesList = new ArrayList<Class<?>>(Arrays.asList(classes));
		
		int heightDiff = maxHeight - minHeight + 1;
		
		for (int i = 0; i < chancesToSpawn; i++)
		{
			int x = chunkX * 16 + 10 + random.nextInt(15);
			int y = minHeight + random.nextInt(heightDiff);
			int z = chunkZ * 16 + 10 + random.nextInt(15);
			BlockPos pos = new BlockPos(x,y,z);
			
			if (minHeight < 0 ) pos = world.getHeight(pos);
			Class<?> biome = world.provider.getBiomeForCoords(pos).getClass();
			if ( classesList.contains(biome) || classes.length == 0 )
			{
				generator.generate(world, random, pos);
			}
			
		}
		
	}
}
