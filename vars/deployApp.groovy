def call(String imageName) {
    stage('Deploy') {
        sh "docker run -d -p 8080:80 ${imageName}"
    }
}
