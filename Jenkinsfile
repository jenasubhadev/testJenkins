pipeline {

    agent any

    environment {
        list_of_repos = 'abc,def,ghi'
    }
    parameters {
        string(name: "override_list_of_repo", defaultValue: "", trim: true, description: "Sample string parameter")
    }
    stages {
        stage('Read Repository') {
            when {
                expression { params.override_list_of_repo != null }
            }
            steps {
                script {
                    for (repo in override_list_of_repo.split(","))
                    {
                        println("${repo}")
                    }
                    echo "Hello $params.override_list_of_repo"
                }
            }
        }
        stage('Reading properties from properties file') {
            when {
                expression { params.override_list_of_repo == "" }
            }
            steps {
                script {
                    def props = readProperties file: 'list_of_repos.properties'
                    env.list_of_repo = props.list_of_repos
                    for (repo in list_of_repo.split(","))
                    {
                        println("${repo}")
                    }
                }
            }

        }

    }

}