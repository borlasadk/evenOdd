#!/usr/bin/env groovy

def Version (
        String ORACLE_TNS,
        String CI_DB_PMC_SYSTEM_PASSW
) {

    return exec("cd Scripts\\\\difference_db\\\\ && difference_db.cmd ${ORACLE_TNS} ${CI_DB_PMC_SYSTEM_PASSW}", true).trim().split()[-1]
}

def createReport(
        String ORACLE_TNS,
        String CI_DB_PMC_SYSTEM_PASSW
) {
    exec("cd Scripts\\difference_db\\ && difference_db.cmd ${ORACLE_TNS} ${CI_DB_PMC_SYSTEM_PASSW}")

}