package zemoa.pantrycompanion.domain.pantry.entities

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.any
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import zemoa.pantrycompanion.domain.pantry.business.operations.PantryOperation

@RunWith(MockitoJUnitRunner::class)
class PantryTest {

    @Mock
    private lateinit var operation: PantryOperation
    @Test
    fun testApplyOperation() {
        val sut = Pantry("any")
        sut.apply(operation)

        verify(operation, times(1)).process(any())
    }
}