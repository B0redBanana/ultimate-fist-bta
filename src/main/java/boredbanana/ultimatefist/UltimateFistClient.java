package boredbanana.ultimatefist;

import boredbanana.ultimatefist.items.ItemUltimateFist;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.render.item.model.ItemModelStandard;
import turniplabs.halplibe.event.defs.ClientEvents;
import turniplabs.halplibe.util.dependency.Key;

public class UltimateFistClient implements ClientModInitializer {

	@Override
	public void onInitializeClient()
	{
		ClientEvents.ITEM_MODEL_RELOAD.listen(
			Key.of(UltimateFist.MOD_ID),
			dispatcher ->
			{
				if (ItemUltimateFist.ITEM == null)
				{
					return;
				}
				dispatcher.addDispatch(new ItemModelStandard(ItemUltimateFist.ITEM));
			}
		);
	}
}
