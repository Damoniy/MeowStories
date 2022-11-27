package br.com.deabyte.core.entity.system

import br.com.deabyte.core.entity.capability.InputCapability
import br.com.deabyte.core.entity.capability.MovementCapability
import br.com.deabyte.core.entity.capability.PositionCapability
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.Gdx

class InputSystem(): IteratingSystem(Family.all(InputCapability::class.java).get()) {

    private val posCapability: ComponentMapper<PositionCapability> = ComponentMapper.getFor(PositionCapability::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        val position = posCapability.get(entity)

        if(Gdx.input.isTouched) {
            position.x = Gdx.input.x.toFloat()
            position.y = Gdx.input.y.toFloat()

            println("Positions: ${position.x} / ${position.y}")
        }
    }
}