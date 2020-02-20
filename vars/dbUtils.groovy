#!/usr/bin/env groovy

def createReport(
        String ORACLE_TNS,
        String CI_DB_PMC_SYSTEM_PASSW,
        String fileContents
) {
    exec("cd Scripts\\difference_db\\ && difference_db.cmd ${ORACLE_TNS} ${CI_DB_PMC_SYSTEM_PASSW}")
    fileContents = readFile "Scripts\\difference_db\\version.properties" as String
    return fileContents.trim()
}



