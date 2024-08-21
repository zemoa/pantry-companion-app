package zemoa.pantrycompanion.domain.pantry.business.operations

import android.util.Log
import zemoa.pantrycompanion.domain.pantry.business.operations.arguments.RemoveItemArg
import zemoa.pantrycompanion.domain.pantry.entities.Pantry
import zemoa.pantrycompanion.domain.pantry.entities.PantryItem

class RemoveItemOperation(val arg: RemoveItemArg) : PantryOperation {
    companion object {
        val TAG = RemoveItemOperation::class.qualifiedName
    }
    override fun process(pantry: Pantry) {
        if((arg.quantity == null || arg.quantity <= 0)
            && (arg.all != true)) {
            Log.w(TAG, "Wrong quantity for deletion. qty: ${arg.quantity}, all: ${arg.all}")
            return
        }
        val existingItems = pantry.items

        if(arg.all == true) {
            processRemoving(pantry)
        } else {
            processDecrease(existingItems, pantry)
        }
    }

    private fun processDecrease(
        existingItems: MutableSet<PantryItem>,
        pantry: Pantry
    ) {
        val foundItem =
            existingItems.firstOrNull { pantryItem: PantryItem -> pantryItem.name == arg.name }
        if (foundItem == null) {
            Log.i(TAG, "Item ${arg.name} not found in pantry ${pantry.name}")
            return
        }
        if (arg.quantity != null) {
            foundItem.quantity -= arg.quantity
        }
        if(foundItem.quantity <= 0) {
            processRemoving(pantry)
        }
    }

    private fun processRemoving(pantry: Pantry) {
        pantry.items.removeIf { item -> item.name == arg.name }
    }
}