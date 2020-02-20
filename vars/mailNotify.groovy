#!/usr/bin/env groovy

import Properties

def call(


) {
    mail to: Properties.Emails.EMAIL_TEST,
         cc: Properties.Emails.EMAIL_TEST,
        subject: "Report of CTC DB structure changes: ${dbUtils.versionGet()}_${Repo.nexusRawFilePath.artifactName}",
        body:  '''<p>Dear Colleagues,</p>
                        <p> </p>
                        <p></a>. </p>
                        <p> </p>
                        <p>Please find attached difference of database structure for coming CTC release 19.11.</a>.</p>
                        <p> </p>
                        <p>Thank you.</p>''',
        attachmentsPattern: "${Properties.Paths.DIFFERENCE_DB_DIR}${dbUtils.versionGet()}_${Repo.nexusRawFilePath.artifactName}.txt"
}

def call(
    String fullDisplayName, 
    String buildNumber,
    String buildUrl,
    String email
) {
    mail to: "${email}", 
        subject: "The pipeline ${fullDisplayName}", 
        body:  "Build # ${buildNumber}: \nCheck console output at ${buildUrl} to view the results."
}
