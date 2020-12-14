class Person(
    val name: String, val age: Int,
    var mother: Person? = null, var father: Person? = null,
    var siblings: Array<Person>? = null
) {

    override fun toString(): String {
        return this.name
    }

    var amountOfAllRelatives = 0
    var listOfRelatives: MutableList<Person> = mutableListOf<Person>()

    fun createListRelativesOf(person: Person) {
        //tree traversal, form a list of all relatives and counting of them
        this.mother?.let {
            person.listOfRelatives.add(it)
            person.amountOfAllRelatives++
            it.createListRelativesOf(person)
        }
        this.father?.let {
            person.listOfRelatives.add(it)
            person.amountOfAllRelatives++
            it.createListRelativesOf(person)
        }
        this.siblings?.let {
            it.forEach {
                person.listOfRelatives.add(it)
                person.amountOfAllRelatives++
                it.createListRelativesOf(person)
            }
        }
    }
}