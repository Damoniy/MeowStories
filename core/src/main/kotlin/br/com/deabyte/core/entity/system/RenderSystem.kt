package br.com.deabyte.core.entity.system

import br.com.deabyte.core.entity.capability.PositionCapability
import br.com.deabyte.core.entity.capability.RenderCapability
import com.badlogic.ashley.core.ComponentMapper
import com.badlogic.ashley.core.Entity
import com.badlogic.ashley.core.Family
import com.badlogic.ashley.systems.IteratingSystem
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class RenderSystem(private val orthographicCamera: OrthographicCamera) :
    IteratingSystem(Family.all(RenderCapability::class.java, PositionCapability::class.java).get()) {

    private var spriteBatch: SpriteBatch = SpriteBatch()

    private val posCapability: ComponentMapper<PositionCapability> = ComponentMapper.getFor(PositionCapability::class.java)
    private val renCapability: ComponentMapper<RenderCapability> = ComponentMapper.getFor(RenderCapability::class.java)

    override fun processEntity(entity: Entity?, deltaTime: Float) {
        this.orthographicCamera.update()
        this.spriteBatch.begin()
        this.spriteBatch.projectionMatrix = orthographicCamera.combined

        val position = posCapability.get(entity)
        val render = renCapability.get(entity)

        this.spriteBatch.draw(render.region, position.x, -position.y + 480)
        this.spriteBatch.end()
    }
}