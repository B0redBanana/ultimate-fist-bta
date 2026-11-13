
package boredbanana.ultimatefist.items;

import net.minecraft.core.block.Block;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import net.minecraft.core.world.pos.TilePosc;

public class ItemUltimateFist extends ItemTool {

	public static ItemUltimateFist ITEM;

	private static final float MINING_SPEED = 1_000.0F;
	private static final int ENTITY_DAMAGE = 100;



	public ItemUltimateFist(String name, String namespaceId, int id)
	{
		super(name, namespaceId, id, 0, ToolMaterial.diamond, BlockTags.MINEABLE_BY_PICKAXE
		);
	}

	// Not sure if I'm doing this right, but it works, so I'm not messing with it too much

	@Override
	public float getStrVsBlock(ItemStack stack, Block<?> block)
	{
		if (block.getHardness() < 0.0F)
		{
			return 0.0F;
		}
		return MINING_SPEED;
	}

	@Override
	public boolean canHarvestBlock(ItemStack stack, Mob mob, Block<?> block)
	{
		return block.getHardness() >= 0.0F;
	}

	@Override
	public int getDamageVsEntity(ItemStack stack, Entity entity)
	{
		return ENTITY_DAMAGE;
	}

	@Override
	public boolean onBlockDestroyed(ItemStack itemStack, World world, Mob mob, Block<?> removedBlock, TilePosc blockPos, Side side)
	{
		return true;
	}

	@Override
	public boolean hitEntity(ItemStack selfStack, Mob target, Mob attacker)
	{
		return true;
	}
}
