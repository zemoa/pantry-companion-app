package zemoa.pantrycompanion.domain.pantry.business.operations

import zemoa.pantrycompanion.domain.pantry.business.operations.arguments.AddItemArg
import zemoa.pantrycompanion.domain.pantry.entities.Pantry
import zemoa.pantrycompanion.domain.pantry.entities.PantryItem

class AddItemOperation(val arg: AddItemArg): PantryOperation {
    override fun process(pantry: Pantry) {
        pantry.items.add(PantryItem(name = arg.name, quantity = arg.quantity))
    }
}