package com.github.suxin1.pont.services

import com.intellij.openapi.project.Project
import com.github.suxin1.pont.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
