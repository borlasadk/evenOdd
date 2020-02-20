#!/usr/bin/env groovy

def createReport(
        String ORACLE_TNS,
        String CI_DB_PMC_SYSTEM_PASSW
) {
    exec("cd Scripts\\difference_db\\ && difference_db.cmd ${ORACLE_TNS} ${CI_DB_PMC_SYSTEM_PASSW}")
    def fileContents = readFile "Scripts\\difference_db\\version.properties"
    return fileContents
}

def versionReport(

)
{
    _CTC_DB_VERSION = powershell(script: 'dir Scripts/difference_db/*.txt | Select -Last 1 -Exp name', returnStdout: true)
}

