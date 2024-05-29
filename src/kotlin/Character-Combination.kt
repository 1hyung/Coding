package com.example

class Armor(
    val defensePoint: Int,
) {
    fun getDefenseDamage(damage: Int):Int{
        return damage - defensePoint
    }
}

class Character2(
    val armor: Armor?,
) {
    val damage = 10
    var healthPoint = 100

    fun attack(target: Character2) {
        target.takeAttack(damage)
    }

    open fun takeAttack(damage: Int) {
        val defensedDamage =  armor?.getDefenseDamage(damage) ?: damage
        //armor가 ?일 때 ?에 getDefenseDamage를 호출할 수 없으니 그냥 앞에 값을 null로 처리하겠다
        // ?: 엘비스연산자를 사용하면 ?: 앞에 부분이 null이면 뒤에 부분을 사용하겠다.
        healthPoint -= defensedDamage
    }
}

fun main() {
    val characterWithoutArmor = Character2(null)
    val characterWithArmor =  Character2(Armor(3))

    characterWithoutArmor.takeAttack(10)
    println(characterWithoutArmor.healthPoint)

    characterWithArmor.takeAttack(10)
    println(characterWithArmor.healthPoint)
}