pipeline {

    agent any

    environment {
        list_of_repos = 'abc,def,ghi'
    }

    stages {
        stage('Read Repository') {
            steps {
                script {
                    for (repo in list_of_repos.split(","))
                    {
                        println("${repo}")
                    }
                }
            }
        }
        stage('Reading properties from properties file') {
            steps {
                script {
                    def props = readProperties file: 'extravars.properties'
                    env.Username = props.Username
                }
                echo "The username  is $Username"
            }

        }

    }

}