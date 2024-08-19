package zemoa.pantrycompanion.domain.pantry.business.operations

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import zemoa.pantrycompanion.domain.pantry.business.operations.arguments.AddItemArg
import zemoa.pantrycompanion.domain.pantry.entities.Pantry
import zemoa.pantrycompanion.domain.pantry.entities.PantryItem

@RunWith(MockitoJUnitRunner::class)
class AddItemOperationTest {
    @Test
    fun givenEmtpyPantry_whenAddItemWithQuantityOf2_thenMustAddItem() {
        val addItemArg = AddItemArg(name = "Test", quantity = 2)

        val sut = AddItemOperation(addItemArg)

        val pantry = Pantry("any")
        sut.process(pantry)

        val items = pantry.items
        assertEquals(1, items.size)
        assertEquals("Test", items.first().name)
        assertEquals(2, items.first().quantity)
    }

    @Test
    fun givenEmtpyPantry_whenAddItemWithNoQuantity_thenMustAddItemWithQuantity1() {
        val addItemArg = AddItemArg(name = "Test")

        val sut = AddItemOperation(addItemArg)

        val pantry = Pantry("any")
        sut.process(pantry)

        val items = pantry.items
        assertEquals(1, items.size)
        assertEquals("Test", items.first().name)
        assertEquals(1, items.first().quantity)
    }

    @Test
    fun givenExistingItemInPantry_whenAddSameItem_thenMustIncreaseItemsQuantity() {
        val addItemArg = AddItemArg(name = "Test", quantity = 2)

        val sut = AddItemOperation(addItemArg)

        val pantry = Pantry("any")
        pantry.items.add(PantryItem("Test", 1))
        sut.process(pantry)

        val items = pantry.items
        assertEquals(1, items.size)
        assertEquals("Test", items.first().name)
        assertEquals(3, items.first().quantity)
    }
}