package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //TOdo сделать так чтобы возвращало ожидаемые значения
        val parts: List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        return firstName to lastName
    }

    fun transliteration(payload: String, divider: String = " "): String {
        TODO()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstInitial: String = firstName?.first().toString()
        val lastInitial: String = lastName?.first().toString()

        return "$firstInitial$lastInitial"
    }
}

