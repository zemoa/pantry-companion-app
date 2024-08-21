package zemoa.pantrycompanion.domain.pantry.business.operations

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import zemoa.pantrycompanion.domain.pantry.business.operations.arguments.RemoveItemArg
import zemoa.pantrycompanion.domain.pantry.entities.Pantry
import zemoa.pantrycompanion.domain.pantry.entities.PantryItem

@RunWith(MockitoJUnitRunner::class)
class RemoveItemOperationTest {
    @Test
    fun givenExistingItem_whenRemove1_thenDecreaseItemsQuantity() {
        val removeItemArg = RemoveItemArg(name = "Test", quantity = 1)
        val sut = RemoveItemOperation(removeItemArg)

        val pantry = Pantry("any")
        pantry.items.add(PantryItem("Test", quantity = 3))
        sut.process(pantry)

        val items = pantry.items
        assertEquals(1, items.size)
        assertEquals(2, items.first().quantity)
    }

    @Test
    fun givenExistingItemWithQuantity1_whenRemoveNegativeNumber_thenDoNothing() {
        val removeItemArg = RemoveItemArg(name = "Test", quantity = -5)
        val sut = RemoveItemOperation(removeItemArg)

        val pantry = Pantry("any")
        pantry.items.add(PantryItem("Test", quantity = 3))
        sut.process(pantry)

        val items = pantry.items
        assertEquals(3, items.first().quantity)
    }

    @Test
    fun givenEmptyPantry_whenRemove1_thenNoThingHappen() {
        val removeItemArg = RemoveItemArg(name = "Test", quantity = 1)
        val sut = RemoveItemOperation(removeItemArg)

        val pantry = Pantry("any")
        sut.process(pantry)

        val items = pantry.items
        assertEquals(0, items.size)
    }

    @Test
    fun givenExistingItem_whenRemoveAll_thenRemoveItem() {
        val removeItemArg = RemoveItemArg(name = "Test", all = true)
        val sut = RemoveItemOperation(removeItemArg)

        val pantry = Pantry("any")
        pantry.items.add(PantryItem("Test", quantity = 3))
        sut.process(pantry)

        val items = pantry.items
        assertEquals(0, items.size)
    }

    @Test
    fun givenExistingItemWithQuantity1_whenRemove1_thenRemoveItem() {
        val removeItemArg = RemoveItemArg(name = "Test", quantity = 3)
        val sut = RemoveItemOperation(removeItemArg)

        val pantry = Pantry("any")
        pantry.items.add(PantryItem("Test", quantity = 3))
        sut.process(pantry)

        val items = pantry.items
        assertEquals(0, items.size)
    }
}