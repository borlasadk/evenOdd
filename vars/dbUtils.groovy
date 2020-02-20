#!/usr/bin/env groovy

def pmcDBVersion(String ORACLE_TNS,
                 String CI_DB_PMC_SYSTEM_PASSW,
                 String _CTC_DB_VERSION
) {

    return exec("cd Scripts\\difference_db\\ && difference_db.cmd ${ORACLE_TNS} ${CI_DB_PMC_SYSTEM_PASSW}", true).trim().split()[-1]
}

def createReport(
        String ORACLE_TNS,
        String CI_DB_PMC_SYSTEM_PASSW
) {
    exec("cd Scripts\\difference_db\\ && difference_db.cmd ${ORACLE_TNS} ${CI_DB_PMC_SYSTEM_PASSW}")

}