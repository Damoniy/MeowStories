package br.com.deabyte.core.entity.system

import br.com.deabyte.core.entity.capability.MovementCapability
import br.com.deabyte.core.entity.capability.PositionCapability
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import ktx.ashley.get


class MovementSystem :
    IteratingSystem(Family.all(PositionCapability::class.java, MovementCapability::class.java).get()) {

    private val posCapability: ComponentMapper<PositionCapability> = ComponentMapper.getFor(PositionCapability::class.java)
    private val movCapability: ComponentMapper<MovementCapability> = ComponentMapper.getFor(MovementCapability::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val position = posCapability.get(entity)
        val velocity = movCapability.get(entity)

        position.x += velocity.x * deltaTime
        position.y += velocity.y * deltaTime
    }
}