package zemoa.pantrycompanion.domain.pantry.business.operations

import zemoa.pantrycompanion.domain.pantry.entities.Pantry

interface PantryOperation {
    fun process(pantry: Pantry)
}