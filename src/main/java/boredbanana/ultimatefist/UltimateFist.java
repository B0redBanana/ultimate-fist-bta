package boredbanana.ultimatefist;

import boredbanana.ultimatefist.items.ItemUltimateFist;
import boredbanana.ultimatefist.recipes.RecipeUltimateFist;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.HalpLibe;
import turniplabs.halplibe.event.defs.CommonEvents;
import turniplabs.halplibe.helper.ItemBuilder;
import turniplabs.halplibe.util.dependency.Key;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryCategory;
import turniplabs.halplibe.helper.creativeInventory.CreativeInventoryPlacement;

public class UltimateFist implements ModInitializer {
	public static final String MOD_ID = HalpLibe.registerMod("ultimatefist", true);
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Got this bit from https://github.com/LukeisStuff/paxels so I can properly load the texture
	public static String itemKey(String name)
	{
		return MOD_ID + ":item/" + name;
	}


	@Override
	public void onInitialize()
	{
		CommonEvents.BEFORE_GAME_START.listen(Key.of(MOD_ID), this::beforeGameStart);
		CommonEvents.RECIPES_NAMESPACE_INIT.listen(Key.of(MOD_ID), RecipeUltimateFist::initNamespaces);
		CommonEvents.RECIPES_READY.listen(Key.of(MOD_ID), RecipeUltimateFist::registerRecipes);
		LOGGER.info("Ultimate Fist initialized. Yippie :)");
	}



	// I think this is the right place to put this Creative Inventory placement

	public void beforeGameStart()
	{
		ItemUltimateFist.ITEM = new ItemBuilder(MOD_ID)
			.setCreativeInventoryPlacement(
				new CreativeInventoryPlacement.Category(
					CreativeInventoryCategory.MISC_TOOLS
				)
			)
	// Shoutout to the Paxels mod
			.build(new ItemUltimateFist("ultimate_fist", itemKey("ultimate_fist"), 6000));
	}


}
