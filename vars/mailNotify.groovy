#!/usr/bin/env groovy

import Properties

def call(


) {
    emailext recipientProviders: [[$class: 'RequesterRecipientProvider']],
             to: Properties.Emails.EMAIL_TEST,
             cc: Properties.Emails.EMAIL_TEST,
             subject: "Report of CTC DB structure changes: ${dbUtils.versionGet()}",
             body:  '''Dear Colleagues,
                        
                        Please find attached difference of database structure for coming CTC release 19.11.
                        
                        Thank you.''',
        attachmentsPattern: "${Properties.Paths.DIFFERENCE_DB_DIR}*.txt"
}

def call(
    String fullDisplayName, 
    String buildNumber,
    String buildUrl,
    String email
) {
    emailext to: "${email}",
        subject: "The pipeline ${fullDisplayName}", 
        body:  "Build # ${buildNumber}: \nCheck console output at ${buildUrl} to view the results."
}
