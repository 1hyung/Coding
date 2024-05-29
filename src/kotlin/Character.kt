package kotlin

open class Character {
    val damage = 10
    var healthPoint = 100

    fun attack(target: Character) {
        target.takeAttack(damage)
    }

    open fun takeAttack(damage: Int) {
        healthPoint -= damage
    }
}

// 상속을 받으려면 Character class를 open으로 작성해줘야함.
class CharacterWithArmor : Character() {
    val defensePoint = 3

    //takeAttack도 상속을 받으려면 open을 붙여줘야한다.
    //damage: Int 라는 인터페이스는 똑같이 맞춰줘야한다.
    //자신의 healthPoint를 감소시키는 로직은 open fun takeAttack(damage: Int) 부모가 가지고 있어서
    //CharacterWithArmor에서는 감소해야하는 데미지를 잘 구하는 로직만 구하면 됨!

    override fun takeAttack(damage: Int) {
        val actualDamage = damage - defensePoint
        //healthPoint -= actualDamage 이것을 아래처럼 구현 가능
        //super를 사용하면 부모를 가리킬 수 있음
        super.takeAttack(actualDamage)
//CharacterWithArmor는 damage를 계산한 다음에 실제로 hp를 깎는 것은 부모에 있는 로직을 그대로 재사용한다.
    }
}