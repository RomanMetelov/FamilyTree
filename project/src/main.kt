fun main() {
    val human: Person = getMe()
    human.createListRelativesOf(human)
    println("I have ${human.amountOfAllRelatives} relatives: ${human.listOfRelatives.joinToString(postfix = ".")}")

}

fun getMe(): Person {
    val me: Person = Person("Me", 23)

    me.mother = Person("Mother", 45)
    me.father = Person("Father", 47)
    me.siblings = arrayOf(Person("Sister", 25))

    me.mother!!.mother = Person("Grandmother", 72)
    me.mother!!.father = Person("Grandfather", 76)
    me.mother!!.siblings = arrayOf(Person("Aunt", 49), Person("Uncle", 54))

    me.father!!.mother = Person("Grandfather2", 74)
    me.father!!.father = Person("Grandmother2", 73)
    me.father!!.siblings = arrayOf(Person("Grandfather3", 49))

    return me
}

