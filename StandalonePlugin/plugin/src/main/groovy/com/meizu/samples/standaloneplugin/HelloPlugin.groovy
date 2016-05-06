package com.meizu.samples.standaloneplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class HelloPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create("greeting", GreetingExtension)
        project.task('hello') << {
            println "${project.greeting.message} from ${project.greeting.greeter}"
        }

        def greetings = project.container(GreetingContainer)
        project.extensions.greetings = greetings
        project.task('hellos') << {
            greetings.all {
                println "${it.msgList*.toString()} from ${it.name}"
            }
        }
    }
}