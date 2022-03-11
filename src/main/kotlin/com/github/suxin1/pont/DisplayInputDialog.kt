package com.github.suxin1.pont

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.intellij.execution.ui.ConsoleView
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.wm.ToolWindow

class DisplayInputDialog : AnAction() {
    lateinit var toolWindow: ToolWindow

    lateinit var consoleView: ConsoleView

    override fun actionPerformed(e: AnActionEvent) {
        if(e.project == null) return

        val wrapper = MyDialog(e.project!!)

        if(wrapper.showAndGet()) {
            val state = PontStateService.getInstance().state
            if(state == null || state.firstName.isEmpty()) return
            println("Successfully handled user input")
            printState()
        }
    }

    private fun printState() {
        val state = PontStateService.getInstance().state
        println("from State: ${state?.firstName}")
    }
}