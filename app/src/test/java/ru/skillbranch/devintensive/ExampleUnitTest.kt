package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
//        val user2 = User("2", "John", "Wick")
//        val user3 = User("3", "John", "Silverhand", avatar = null, lastVisit = Date(), isOnline = true)

//        user.printMe()
//        user2.printMe()
//        user3.printMe()

//        println("$user $user2 $user3")
        println("$user")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("John Cena")
        val user2 = User.makeUser("John Wick")
//        val user3 = User.makeUser(null)
        val user4 = user2.copy(id = "4", lastName = "Cena", lastVisit = Date())
//        println("$user2 \n$user3")
        val user5 = User.makeUser(null)
        val user6 = User.makeUser("")
        val user7 = User.makeUser(" ")
        val user8 = User.makeUser("Cena")
        println("$user5\n$user6\n$user7\n$user8")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("John Wick")
        fun getUserInfo() = user
        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date())
        val user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        val user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))

//        if (user == user2) println("Equals data and hash:\n${user.hashCode()} $user \n${user2.hashCode()} $user2")
//        else  println("Not equals data and hash:\n${user.hashCode()} $user \n${user2.hashCode()} $user2")
//
//        if (user === user2) println("\nEquals address:\n${System.identityHashCode(user)} ${System.identityHashCode(user2)}")
//        else  println("\nNot equals address:\n${System.identityHashCode(user)} ${System.identityHashCode(user2)}")

        println(
            """
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format("HH:mm")}
        """.trimIndent()
        )
    }

    @Test
    fun test_data_maping() {
        val user = User.makeUser("Корякин Артём")
        val newUser = user.copy(lastVisit = Date().add(-7, TimeUnits.SECOND))

        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Корякин Артём")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url message", type = "image")

//        when(imgMessage) {
//            is BaseMessage -> println("This is base message.")
//            is TextMessage -> println("This is text message.")
//            is ImageMessage -> println("This is image message.")
//        }
        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}




