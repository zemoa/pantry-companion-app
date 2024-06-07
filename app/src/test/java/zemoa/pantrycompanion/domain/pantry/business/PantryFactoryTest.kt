package zemoa.pantrycompanion.domain.pantry.business

import org.junit.Assert.*
import org.junit.Test

class PantryFactoryTest {
    @Test fun testPantryCreation() {
        val sut = PantryFactory()
        val pantry = sut.create("Pantry name")
        assertNotNull(pantry)
        assertEquals("Pantry name", pantry.name)
    }
}