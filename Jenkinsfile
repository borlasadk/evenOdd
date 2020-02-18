#!/usr/bin/env groovy
@Library('evenOdd') _
import Properties
import DB

def _CTC_DB_VERSION
def ORACLE_TNS

node('CI') {
    // Node to build
//    agent {node {label 'Main'} }


    properties([
            disableConcurrentBuilds(),
            parameters([
                    choice(
                            name: 'ENVIRONMENT',
                            choices: DB.envList(),
                            description: DB.envDescription()
                    )

            ])
    ])
//    environment {
//        CI_DB_PMC_SYSTEM_PASSW = credentials('CI_DB_PMC_SYSTEM_PASSW')
//
//    }
 //    try {
         stage('get env vars') {

             (ORACLE_TNS, CI_DB_PMC_SYSTEM_PASSW) = DB.envList(ENVIRONMENT)
//             _CTC_DB_VERSION = dbUtils.createReport()

         }
         // On this stage, script difference_db.cmd compare database difference and generate a report in the text file.
         stage('Compare Database Difference') {
//             environment {
//                 CI_DB_PMC_SYSTEM_PASSW = credentials('CI_DB_PMC_SYSTEM_PASSW')
//             }
             echo 'Comparing Database Difference...'
//             (ORACLE_TNS, CI_DB_PMC_SYSTEM_PASSW) = DB.envList(ENVIRONMENT)
//             withCredentials([
//                     string(credentialsId: 'CI_DB_PMC_SYSTEM_PASSW', variable: 'CI_DB_PMC_SYSTEM_PASSW')
//             ])
           //              def CI_DB_PMC_SYSTEM_PASSW='sqlsql'
                         exec("chcp 1251 >nul\n dir ")
           //              dbUtils.createReport(ORACLE_TNS, CI_DB_PMC_SYSTEM_PASSW)

             echo 'Compared Database Difference!'
//                    _CTC_DB_VERSION=dbUtils.createReport()

         }
         // On this stage, mvn wagon:upload-single plugin upload report to Nexus.
         stage('Upload Report to Nexus') {

             echo 'Uploading Report to Nexus...'

             msteamsMessage += promoteRawJob(Properties.RawArtifact.DIFFERENCE_DB, Properties.RawArtifact.DIFFERENCE_DB.code)

             echo 'Uploaded Report to Nexus!'

         }
//         currentBuild.result = 'SUCCESS'
//     } catch (Exception err) {
//         println "Error: ${err}"
//         currentBuild.result = 'FAILURE'
//     } finally {
//         switch (currentBuild.result) {
//             case 'SUCCESS':
//                 mailNotify(
//                     "${_CTC_DB_VERSION}"
//                 )
////                 msteamsNotify.success("Build success")
//                 break
//             case 'FAILURE':
////                 msteamsNotify.fail("Build failed")
//                 break
//             default:
//                 break
//         }
//     }

    // Send email notification.
    post {

         success {
            echo 'Sending email notification...'
             mailNotify(
                     "${_CTC_DB_VERSION}"

             )
             echo 'Email notification sent!'
        }
    }


}