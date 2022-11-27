package br.com.deabyte.core

import br.com.deabyte.core.screen.FirstScreen
import com.badlogic.gdx.Game

/** [com.badlogic.gdx.ApplicationListener] implementation shared by all platforms.  */
class Catland : Game() {
    override fun create() {
        setScreen(FirstScreen())
    }
}