#!/usr/bin/env groovy

import Properties

class DB {
    static String envList() {
        Properties.DB.values().join('\n')
    }

    static List envList(String name) {
        [
                Properties.DB.valueOf(name).oracleTNS
        ]
    }

    static String envDescription() {
        String s = ""
        Properties.DB.values().each{
            s += "${it.name()} - ${it.address}\n"
        }
        s
    }
}

