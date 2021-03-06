package phaonica.myfirstmod.init.blocks.trees;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import phaonica.myfirstmod.util.IMetaName;
import phaonica.myfirstmod.world.feature.tree.WorldGenAluminumTree;
import phaonica.myfirstmod.world.feature.tree.WorldGenTutorialTree;

public class CustomBlockSapling extends BlockBush implements IGrowable, IMetaName
{
    public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 1);
    protected static final AxisAlignedBB SAPLING_AABB = new AxisAlignedBB(0.09999999403953552D, 0.0D, 0.09999999403953552D, 0.8999999761581421D, 0.800000011920929D, 0.8999999761581421D);

	public static final PropertyEnum<CustomBlockPlanks.EnumType> VARIANT = 
			PropertyEnum.<CustomBlockPlanks.EnumType>create("variant", CustomBlockPlanks.EnumType.class, new Predicate<CustomBlockPlanks.EnumType>()
	{
		public boolean apply(@Nullable CustomBlockPlanks.EnumType apply )
		{
			return apply.getMeta() < 2;
		}
	});
	
	public CustomBlockSapling(String name)
	{
		System.out.println("postInit called");

		setUnlocalizedName(name);
		setRegistryName(name);
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, CustomBlockPlanks.EnumType.TUTORIAL).withProperty(STAGE, Integer.valueOf(0)));
	}
	
	// SAPLING SHAPE
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return SAPLING_AABB;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return NULL_AABB;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
	
	 @Override
	public boolean isFullCube(IBlockState state)
	{
		 return false;
	}
	
	 // VARIANTS
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for(CustomBlockPlanks.EnumType customblockplanks$enumtype : CustomBlockPlanks.EnumType.values())
		{
			items.add(new ItemStack(this,1,customblockplanks$enumtype.getMeta()));
		}
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
	}
	
	
	public String getSpecialName(ItemStack stack)
	{
		return CustomBlockPlanks.EnumType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, CustomBlockPlanks.EnumType.byMetadata(meta & 1)).withProperty(STAGE, Integer.valueOf((meta & 8) >> 3));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;
		i = i | ((CustomBlockPlanks.EnumType)state.getValue(VARIANT)).getMeta();
		i = i | ((Integer)state.getValue(STAGE)).intValue() << 3;
		return i;
	}
	
	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT, STAGE});
	}
	
	// TREE CODE
	

	
	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		
		System.out.println("grow called");

		// TODO Auto-generated method stub
		if (((Integer)state.getValue(STAGE)).intValue() == 0)
		{
			System.out.println("not doing generateTree");

			// if it's in state 0, no growing
			worldIn.setBlockState(pos, state.cycleProperty(STAGE), 4);
			
		}
		else
		{
			System.out.println("doing generateTree");

			this.generateTree(worldIn, rand, pos, state);
		}
	}
	
	public void generateTree(World world, Random rand, BlockPos pos, IBlockState state)
	{
		System.out.println("generateTree called");

		if ( !TerrainGen.saplingGrowTree(world, rand, pos) ) 
		{
			System.out.println("doing saplingGrowTree");
			return;			
		}
		else
		{
			System.out.println("not doing saplingGrowTree");
		}
		
		WorldGenerator gen = (WorldGenerator)(rand.nextInt(10) == 0 ? new WorldGenBigTree(false) : new WorldGenTrees(false));
		boolean flag = false;
		
		switch((CustomBlockPlanks.EnumType)state.getValue(VARIANT))
		{
		case TUTORIAL:
			System.out.println("doing TUTORIAL");
			gen = new WorldGenTutorialTree();
			break;
		case ALUMINIUM:
			System.out.println("doing ALUMINIUM");
			gen = new WorldGenAluminumTree();
			break;
		default:
			System.out.println("doing none");
		}
		
		
		
		IBlockState iBlockState = Blocks.AIR.getDefaultState();
		if(flag)
		{
			world.setBlockState(pos.add(0,0,0), iBlockState, 4);
			world.setBlockState(pos.add(1,0,0), iBlockState, 4);
			world.setBlockState(pos.add(0,0,1), iBlockState, 4);
			world.setBlockState(pos.add(1,0,1), iBlockState, 4);
		}
		else
		{
			world.setBlockState(pos, iBlockState,4);
		}
		
		if (!gen.generate(world, rand, pos))
		{
			if(flag)
			{
				world.setBlockState(pos.add(0,0,0), iBlockState, 4);
				world.setBlockState(pos.add(1,0,0), iBlockState, 4);
				world.setBlockState(pos.add(0,0,1), iBlockState, 4);
				world.setBlockState(pos.add(1,0,1), iBlockState, 4);
			}
			else
			{
				world.setBlockState(pos, iBlockState,4);
			}			
		}
	}
	
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
	       if (!worldIn.isRemote)
	        {
	            super.updateTick(worldIn, pos, state, rand); //Calls the BlockBush version

	            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
	            {
	                this.grow(worldIn, rand, pos, state);
	            }
	        }
	}
	
	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		System.out.println("canGrow called");

		return true;
	}
	
	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		System.out.println("canUseBonemeal called");

		return (double)worldIn.rand.nextFloat() < 8.45D;
	}
	
	@Override
	protected boolean canSustainBush(IBlockState state)
	{
		System.out.println("canSustainBush called");

		// return blocks that sapling can grown on
        return state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.FARMLAND;
	}
	
	
	
	
	
}
