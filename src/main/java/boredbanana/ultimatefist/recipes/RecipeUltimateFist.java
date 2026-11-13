package boredbanana.ultimatefist.recipes;

import boredbanana.ultimatefist.UltimateFist;
import boredbanana.ultimatefist.items.ItemUltimateFist;
import net.minecraft.core.item.Items;
import turniplabs.halplibe.helper.RecipeBuilder;

public final class RecipeUltimateFist {
	private RecipeUltimateFist() {
	}

	public static void initNamespaces() {
		RecipeBuilder.initNameSpace(UltimateFist.MOD_ID);
	}

	// Recipe time! This is the original recipe.

	public static void registerRecipes() {
		RecipeBuilder.Shaped(UltimateFist.MOD_ID)
			.setShape(
				"DDD",
				"LLD",
				"DDD"
			)
			.addInput('D', Items.DIAMOND)
			.addInput('L', Items.LEATHER)
			.create("ultimate_fist", ItemUltimateFist.ITEM.getDefaultStack());

		// I'm not sure if this is how you properly add a second recipe

		RecipeBuilder.Shaped(UltimateFist.MOD_ID)
			.setShape(
				"DDD",
				"DLL",
				"DDD"
			)
			.addInput('D', Items.DIAMOND)
			.addInput('L', Items.LEATHER)
			.create("ultimate_fist", ItemUltimateFist.ITEM.getDefaultStack());

	}
}
