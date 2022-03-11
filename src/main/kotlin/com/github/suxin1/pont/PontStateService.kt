package com.github.suxin1.pont

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage

@State(
        name = "demo",
        storages = [Storage("demo.xml")]
)
class PontStateService : PersistentStateComponent<MyState> {
    private var pluginState : MyState = MyState()

    override fun getState(): MyState? {
        return pluginState
    }

    override fun loadState(state: MyState) {
        pluginState = state
    }

    companion object {
        @JvmStatic
        fun getInstance() : PersistentStateComponent<MyState> {
            return ServiceManager.getService(PontStateService::class.java)
        }
    }
}