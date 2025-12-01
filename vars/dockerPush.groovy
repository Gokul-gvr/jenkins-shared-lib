def call(String imageName) {
    stage('Docker Push') {
        sh "docker push ${imageName}"
    }
}
