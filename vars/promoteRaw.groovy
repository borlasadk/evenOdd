#!/usr/bin/env groovy

import Properties
import Repo

def call(
    String artifactName,
    String artifactVersion
) {
    artifactVersion = dbUtils.versionGet()
    mvnExec("wagon:download-single \
        -Dwagon.url=${Properties.Repo.NEXUS_RAW_PATH} \
        -Dwagon.fromFile=${Properties.Paths.DIFFERENCE_DB_DIR}${artifactVersion}_${artifactName}.txt \
        -Dwagon.toFile=${Repo.nexusRawFilePath(artifactName, artifactVersion)}")
}
