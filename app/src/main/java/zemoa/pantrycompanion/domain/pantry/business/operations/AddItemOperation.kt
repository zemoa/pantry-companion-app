package zemoa.pantrycompanion.domain.pantry.business.operations

import zemoa.pantrycompanion.domain.pantry.business.operations.arguments.AddItemArg
import zemoa.pantrycompanion.domain.pantry.entities.Pantry
import zemoa.pantrycompanion.domain.pantry.entities.PantryItem

class AddItemOperation(val arg: AddItemArg): PantryOperation {
    override fun process(pantry: Pantry) {
        val existingItem = pantry.items.find { pantryItem: PantryItem -> pantryItem.name.equals(arg.name) }
        if(existingItem != null) {
            existingItem.quantity += arg.quantity
        } else {
            pantry.items.add(PantryItem(name = arg.name, quantity = arg.quantity))
        }
    }
}