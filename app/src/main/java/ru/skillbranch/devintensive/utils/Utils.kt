package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")
        var firstName = parts?.getOrNull(0)
        var lastName = parts?.getOrNull(1)

        return isEmpty(firstName) to isEmpty(lastName)
    }

    fun transliteration(payload: String, divider: String = " "): String {
        val stringBuilder: StringBuilder = StringBuilder(payload.length * 2)
        for (ch in payload.toCharArray()) {
            when (ch) {
                'А' -> stringBuilder.append('A')
                'Б' -> stringBuilder.append('B')
                'В' -> stringBuilder.append('V')
                'Г' -> stringBuilder.append('G')
                'Д' -> stringBuilder.append('D')
                'Е' -> stringBuilder.append('E')
                'Ё' -> stringBuilder.append("JE")
                'Ж' -> stringBuilder.append("ZH")
                'З' -> stringBuilder.append('Z')
                'И' -> stringBuilder.append('I')
                'Й' -> stringBuilder.append('Y')
                'К' -> stringBuilder.append('K')
                'Л' -> stringBuilder.append('L')
                'М' -> stringBuilder.append('M')
                'Н' -> stringBuilder.append('N')
                'О' -> stringBuilder.append('O')
                'П' -> stringBuilder.append('P')
                'Р' -> stringBuilder.append('R')
                'С' -> stringBuilder.append('S')
                'Т' -> stringBuilder.append('T')
                'У' -> stringBuilder.append('U')
                'Ф' -> stringBuilder.append('F')
                'Х' -> stringBuilder.append("KH")
                'Ц' -> stringBuilder.append('C')
                'Ч' -> stringBuilder.append("CH")
                'Ш' -> stringBuilder.append("SH")
                'Щ' -> stringBuilder.append("JSH")
                'Ъ' -> stringBuilder.append("HH")
                'Ы' -> stringBuilder.append("IH")
                'Ь' -> stringBuilder.append("JH")
                'Э' -> stringBuilder.append("EH")
                'Ю' -> stringBuilder.append("JU")
                'Я' -> stringBuilder.append("JA")
                'а' -> stringBuilder.append('a')
                'б' -> stringBuilder.append('b')
                'в' -> stringBuilder.append('v')
                'г' -> stringBuilder.append('g')
                'д' -> stringBuilder.append('d')
                'е' -> stringBuilder.append('e')
                'ё' -> stringBuilder.append("je")
                'ж' -> stringBuilder.append("zh")
                'з' -> stringBuilder.append('z')
                'и' -> stringBuilder.append('i')
                'й' -> stringBuilder.append('y')
                'к' -> stringBuilder.append('k')
                'л' -> stringBuilder.append('l')
                'м' -> stringBuilder.append('m')
                'н' -> stringBuilder.append('n')
                'о' -> stringBuilder.append('o')
                'п' -> stringBuilder.append('p')
                'р' -> stringBuilder.append('r')
                'с' -> stringBuilder.append('s')
                'т' -> stringBuilder.append('t')
                'у' -> stringBuilder.append('u')
                'ф' -> stringBuilder.append('f')
                'х' -> stringBuilder.append("kh")
                'ц' -> stringBuilder.append('c')
                'ч' -> stringBuilder.append("ch")
                'ш' -> stringBuilder.append("sh")
                'щ' -> stringBuilder.append("jsh")
                'ъ' -> stringBuilder.append("ih")
                'ь' -> stringBuilder.append("jh")
                'э' -> stringBuilder.append("eh")
                'ю' -> stringBuilder.append("ju")
                'я' -> stringBuilder.append("ja")
                ' ' -> stringBuilder.append(' ')
            }
        }
        return stringBuilder.toString()
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val firstInitial: String = if (firstName.isNullOrEmpty()) "null" else firstName.first().toString()
        val lastInitial: String = if (lastName.isNullOrEmpty()) "null" else lastName.first().toString()

        val stringBuilder: StringBuilder = java.lang.StringBuilder()

        if (firstInitial in listOf(" ", "null") && lastInitial in listOf(" ", "null")) {
            stringBuilder.append("null")
        } else if (firstInitial !in listOf(" ", "null") && lastInitial !in listOf(" ", "null")) {
            stringBuilder.append(firstInitial.toUpperCase())
            stringBuilder.append(lastInitial.toUpperCase())
        } else if (firstInitial != "null" && lastInitial == "null") {
            stringBuilder.append(firstInitial.toUpperCase())
        }

        return stringBuilder.toString()
    }

    private fun isEmpty(value: String?) = if (value == "" || value == " ") null else value


}

