package me.protobyte.sdsserver.rules

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RulesKtTest {

    @Test
    fun ParseTest1() {
        val test = parse("BETWEEN 08:00 16:00 DISPLAY image0.png ON screen0 EVERY 5m")

        assertEquals(test,mutableListOf(
            RulePart(
                RuleTypes.Between,
                listOf("08:00","16:00")
            ),
            RulePart(
                RuleTypes.Display,
                listOf("image0.png")
            ),
            RulePart(
                RuleTypes.On,
                listOf("screen0")
            ),
            RulePart(
                RuleTypes.Every,
                listOf("5m")
            )
        ))
    }

    @Test
    fun ParseTest2() {
        val test = parse("DISPLAY image0.png ON screen0")

        assertEquals(test,mutableListOf(
            RulePart(
                RuleTypes.Display,
                listOf("image0.png")
            ),
            RulePart(
                RuleTypes.On,
                listOf("screen0")
            )
        ))
    }

    @Test
    fun ParseTest3() {
        val test = parse("EVERY 5m 00:00 DISPLAY image0.png")

        assertEquals(test,mutableListOf(
            RulePart(
                RuleTypes.Every,
                listOf("5m","00:00")
            ),
            RulePart(
                RuleTypes.Display,
                listOf("image0.png")
            )
        ))
    }
}