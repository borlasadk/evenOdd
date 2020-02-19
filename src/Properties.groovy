#!/usr/bin/env groovy

class Properties {
    class Emails {
        static String EMAIL_DIFFERENCE_DB_LIST="Pavel_Horbach1@epam.com, Dmitry_Rubin@epam.com, Ihar_Ilmovsky@epam.com, WFTInternalApplicationsReporting@epam.com"
        static String EMAIL_LEADER_LIST="SpecialEPM-CTCLeaders@epam.com"
    }

    class Repo {
        static String NEXUS_URL = "http://ci.epm-ctc.projects.epam.com:8081"
        static String RAW_URL = "http://ci.epm-ctc.projects.epam.com:8081/service/rest/beta/components?repository=raw-artifacts"
        static String NEXUS_RAW_PATH = NEXUS_URL + "/repository/raw-artifacts/"
        static String NEXUS_RELEASE_PATH = NEXUS_URL + "/repository/releases/"
    }

    class Paths {
        static String CI_TOOL_DIR ="D:\\Jenkins_WS\\Common\\tools\\citool"
        static String CI_TOOL="D:\\Jenkins_WS\\Common\\tools\\citool\\citool.exe"
        static String COMMON_DIR="D:\\Jenkins_WS\\Common"
        static String JBOSS_HOME="c:\\jboss-eap-6.4"
        static String MASTER_NODE="\\\\ci.epm-ctc.projects.epam.com"
        static String PROJECT_DIR="\\\\epbyminsa0100.minsk.epam.com\\Projects\\EPM-CTC"
        static String PROJECT_REPOSITORY="http://ci.epm-ctc.projects.epam.com:8081/repository"
        static String SCRIPTS_DIR="D:\\Jenkins_WS\\Common\\CI\\Scripts"
        static String WS_DIR="D:\\Jenkins_WS"
        static String WS_DIR_MASTER="\\\\ci.epm-ctc.projects.epam.com\\Jenkins_WS"
    }

    class MSTeams {
        static String OFFICE365_DEV ="https://outlook.office.com/webhook/7d65dd73-9ea5-4ccc-9d0f-4247c559ca7f@b41b72d0-4e9f-4c26-8a69-f949f367c91d/JenkinsCI/0c762b787c5746e5b0730d683818ede8/2c2aa73b-4560-45b0-8bde-0c20449ddb5b"
        static String OFFICE365_FRONTEND_SONAR="https://outlook.office.com/webhook/7d65dd73-9ea5-4ccc-9d0f-4247c559ca7f@b41b72d0-4e9f-4c26-8a69-f949f367c91d/JenkinsCI/26e64bb8baba44ba90261adcc0cce648/0db841ad-5bb4-4546-90ed-1f47a2f3dfb2"
        static String OFFICE365_TEAM="https://outlook.office.com/webhook/667d8321-74f1-4224-8303-3f4a1ea21766@b41b72d0-4e9f-4c26-8a69-f949f367c91d/JenkinsCI/df9b5680015a4e4cb965219d52d758c5/2c2aa73b-4560-45b0-8bde-0c20449ddb5b"
        static String RELEASE_PREFIX="https://artifactory.epam.com/artifactory/EPM-CTC/releases"
    }

    class Git {
        static String API_URL = "git@github.com:borlasadk/evenOdd.git"
        static String API_CRED_ID = "JenkinsSSH"
    }



    enum Environment {
        TST1('tst1.epm-ctc.projects.epam.com'),
        TST3('tst3.epm-ctc.projects.epam.com'),
        TST5('tst5.epm-ctc.projects.epam.com'),
        PUBLIC('epmctc-public.minsk.epam.com');

        Environment(String address) {
            this.address = address
        }

        final String address
    }



    enum RawArtifact {
        DIFFERENCE_DB('DIFFERENCE_DB', 'difference_db')


        RawArtifact(String name, String code){
            this.name = name
            this.code = code
        }

        final String name
        final String code
    }

    enum DB {
        TST1(
                'ecsc0010601d.epam.com',
                'CTCTST1'
        ),
        TST3(
                'ecsc00106830.epam.com',
                'CTCTST3'
        ),
        TST5(
                'ecsc00106838.epam.com',
                'CTCTST5'
        ),
        PUBLIC(
                'ecsc00103df9.epam.com',
                'CTCPUB'
        );

        DB(
                String address,
                String oracleTNS
        ) {
            this.address = address
            this.oracleTNS = oracleTNS
        }

        final String address
        final String oracleTNS
    }
}
