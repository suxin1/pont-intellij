package com.github.suxin1.pontintellij.services

import com.intellij.openapi.project.Project
import com.github.suxin1.pontintellij.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
