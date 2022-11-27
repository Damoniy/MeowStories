package br.com.deabyte.core.entity.player

import br.com.deabyte.core.entity.capability.InputCapability
import br.com.deabyte.core.entity.capability.MovementCapability
import br.com.deabyte.core.entity.capability.PositionCapability
import br.com.deabyte.core.world.Position
import com.badlogic.ashley.core.Entity


class PlayerEntity(val playerName: String,
                   position: Position,
                   val playerJob: PlayerJob,
                   private val playerStats: Map<String, PlayerStat>) : Entity() {

    init {
            this.add(PositionCapability(position.x, position.y))
            this.add(InputCapability(
                playerStats.getOrDefault("velocity", PlayerStat("velocity", 2.5f)).statValue,
                playerStats.getOrDefault("velocity", PlayerStat("velocity", 2.5f)).statValue))
    }

    fun getPosX(): Float {
        return this.getComponent(PositionCapability::class.java).x
    }

    fun getPosY(): Float {
        return this.getComponent(PositionCapability::class.java).y
    }
}


