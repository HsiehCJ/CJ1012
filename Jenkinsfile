pipeline {
    // 位置
    agent any
    
    environment {
        MAVEN_HOME="/opt/maven/3.8.3/libexec"
        JAVA_HOME="/opt/java/openjdk"
        PATH="$JAVA_HOME/bin:$MAVEN_HOME/bin:$PATH"
    }
    stages{
        stage('準備環境') {
            steps {
                sh 'java -version'
                sh 'mvn -version'
                sh 'git --version'
    // 印出環境變數
                sh 'printenv'
                sh 'pwd'
            }
        }
    }
}
