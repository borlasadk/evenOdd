#!/usr/bin/env groovy

import Properties

class Repo {
    static String nexusRawFilePath(String name, String version) {
        return "releases/${name}/${version}_${name}.txt"
    }

}
