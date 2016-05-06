package com.meizu.samples

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingExtension {
    String message =  'Hello'
    String greeter = 'Gradle'
}

class GreetingContainer {
    final String name
    List<String> msgList = []

    GreetingContainer(String name) {
        this.name = name
    }

    void message(String...args) {
        msgList += Arrays.asList(args)
    }
}


class HelloGradle implements Plugin<Project> {
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

