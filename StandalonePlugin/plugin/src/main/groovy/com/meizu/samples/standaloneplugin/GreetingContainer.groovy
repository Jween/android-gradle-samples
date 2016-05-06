package com.meizu.samples.standaloneplugin

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