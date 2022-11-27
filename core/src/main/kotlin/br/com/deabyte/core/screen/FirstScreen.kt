package br.com.deabyte.core.screen

import br.com.deabyte.core.entity.capability.RenderCapability
import br.com.deabyte.core.entity.player.PlayerEntity
import br.com.deabyte.core.entity.player.PlayerJob
import br.com.deabyte.core.entity.system.InputSystem
import br.com.deabyte.core.entity.system.RenderSystem
import br.com.deabyte.core.world.Position
import com.badlogic.ashley.core.Engine
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.TextureRegion

/** First screen of the application. Displayed after the application is created.  */
class FirstScreen : Screen {

    private lateinit var camera: OrthographicCamera
    private val engine = Engine();
    private val player = PlayerEntity("Emer", Position(0f, 0f), PlayerJob("", emptyList()), emptyMap())

    init {

    }

    override fun show() {
        camera = OrthographicCamera(640f, 480f)
        camera.setToOrtho(false, (Gdx.graphics.width).toFloat(), (Gdx.graphics.height).toFloat())

        player.add(RenderCapability(TextureRegion(Texture("coin.png"))))

        engine.addEntity(player)
        engine.addSystem(InputSystem())
        engine.addSystem(RenderSystem(camera))
    }

    override fun render(delta: Float) {
        // Draw your screen here. "delta" is the time since last render in seconds.

        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        engine.update(Gdx.graphics.deltaTime)
    }

    override fun resize(width: Int, height: Int) {
        // Resize your screen here. The parameters represent the new window size.
    }

    override fun pause() {
        // Invoked when your application is paused.
    }

    override fun resume() {
        // Invoked when your application is resumed after pause.
    }

    override fun hide() {
        // This method is called when another screen replaces this one.
    }

    override fun dispose() {
        // Destroy screen's assets here.
    }
}