def call(String imageName, String registry) {
    stage('Docker Push') {
        sh "docker tag ${imageName} ${registry}/${imageName}"
        sh "docker push ${registry}/${imageName}"
    }
}
