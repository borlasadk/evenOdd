#!/usr/bin/env groovy

import Properties

enum Environment {
    static String envList() {
        Properties.Environment.values().join('\n')
    }

    static String envList(String name) {
        Properties.Environment.valueOf(name).address
    }

    static String envDescription() {
        String s = ""
       Properties.Environment.values().each{
            s += "${it.name()} - ${it.address}\n"
        }
        s
    }
}