package zemoa.pantrycompanion.domain.pantry.business

import zemoa.pantrycompanion.domain.pantry.entities.Pantry

class PantryFactory {
    fun create(name: String) : Pantry {
        return Pantry(name)
    }
}