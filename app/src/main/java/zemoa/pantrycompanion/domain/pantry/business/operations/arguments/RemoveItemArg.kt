package zemoa.pantrycompanion.domain.pantry.business.operations.arguments

data class RemoveItemArg(val name: String, val quantity: Int? = null, val all: Boolean? = null)
