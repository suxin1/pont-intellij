package com.github.suxin1.pont;

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

class MyGreetingAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
//        TODO("Not yet implemented")
        val notification = NotificationGroup("AndroidVille", NotificationDisplayType.BALLOON, true)
        notification.createNotification(
                "Hello from fist plugin",
                "Welcome install suxin1's first plugin",
                NotificationType.INFORMATION,
                null
        ).notify(e.project);
    }
}
