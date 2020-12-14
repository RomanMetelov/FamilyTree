class Person(
    val name: String, val age: Int,
    var mother: Person? = null, var father: Person? = null,
    var siblings: Array<Person>? = null
) {

    var amountOfAllRelatives = 0
    //var listOfRelatives: MutableList<Person> = mutableListOf<Person>() //never used

    fun countAmountOfAllRelatives() {
        //var total: Int = 0 //never used
        this.mother?.let {
            amountOfAllRelatives++
            it.countAmountOfAllRelatives()
        }
        this.father?.let {
            amountOfAllRelatives++
            it.countAmountOfAllRelatives()
        }
        this.siblings?.let {
            it.forEach {
                amountOfAllRelatives++
                it.countAmountOfAllRelatives()
            }
        }
    }
}

