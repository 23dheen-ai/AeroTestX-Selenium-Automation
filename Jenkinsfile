pipeline {

    agent any

    parameters {

        choice(
            name: 'BROWSER',
            choices: [
                'chrome',
                'firefox',
                'edge'
            ],
            description: 'Select browser for UI tests'
        )

        choice(
            name: 'SUITE',
            choices: [
                'smoke',
                'regression',
                'api',
                'database',
                'full'
            ],
            description: 'Select TestNG suite'
        )
    }

    stages {

        stage('Checkout') {

            steps {
                checkout scm
            }
        }

        stage('Environment') {

            steps {

                bat 'java -version'

                bat 'mvn -version'

                bat 'git --version'
            }
        }

        stage('Build') {

            steps {

                bat 'mvn clean compile'
            }
        }

        stage('Execute Tests') {

            steps {

                bat """
                    mvn test ^
                    -DsuiteXmlFile=testng/${SUITE}.xml ^
                    -Dbrowser=${BROWSER}
                """
            }
        }
    }

    post {

        always {

            junit(
                testResults:
                    'target/surefire-reports/*.xml',
                allowEmptyResults: true
            )

            archiveArtifacts(
                artifacts: 'target/surefire-reports/**',
                allowEmptyArchive: true
            )

            archiveArtifacts(
                artifacts: 'logs/**',
                allowEmptyArchive: true
            )

            archiveArtifacts(
                artifacts: 'screenshots/**',
                allowEmptyArchive: true
            )
        }

        success {

            echo 'AeroTestX execution completed successfully.'
        }

        failure {

            echo 'AeroTestX execution failed. Check the test reports.'
        }
    }
}