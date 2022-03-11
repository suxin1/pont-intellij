package com.github.suxin1.pont

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project

class NotificationManager {
    companion object {
        @JvmStatic
        fun createAndShowNotification(project: Project, content: String) {
            val notification = NotificationGroup("AndroidVille", NotificationDisplayType.BALLOON, true)
            println("Notification is called")
            notification.createNotification(
                    "Hola",
                    content,
                    NotificationType.INFORMATION,
                    null
            ).notify(project)
        }
    }
}