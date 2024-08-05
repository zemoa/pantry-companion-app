package zemoa.pantrycompanion.domain.pantry.entities

import zemoa.pantrycompanion.domain.pantry.business.operations.PantryOperation

class Pantry(val name: String) {
    val items: MutableSet<PantryItem> = mutableSetOf()
    fun apply(operation: PantryOperation) {
        operation.process(this)
    }
}