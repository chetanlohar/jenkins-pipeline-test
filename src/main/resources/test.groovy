node {
    stage 'Clone the project'
    git 'https://github.com/chetanlohar/jenkins-pipeline-test.git'
    dir('.') {
        stage("Compilation") {
            sh "./mvnw clean compile -DskipTests"
        }
        stage("Checkstyle") {
            sh "./mvnw checkstyle:checkstyle"

            step([$class: 'CheckStylePublisher',
                  canRunOnFailed: true,
                  defaultEncoding: '',
                  healthy: '100',
                  pattern: '**/target/checkstyle-result.xml',
                  unHealthy: '90',
                  useStableBuildAsReference: true
            ])
        }
        stage("Tests") {
            sh "./mvnw test"
        }
        stage("Package") {
            sh "./mvnw clean install"
        }
        stage ("Stage Deploy") {
            sh 'ssh root@192.168.2.6 fuser -k -TERM 9090/tcp'
            sh 'ssh root@192.168.2.6 rm -rf /home/chetan/dmp/jenkins-pipeline-test-0.0.1-SNAPSHOT.jar'
            sh 'scp -r /var/jenkins_home/workspace/pipeline/target/jenkins-pipeline-test-0.0.1-SNAPSHOT.jar root@192.168.2.6:/home/chetan/dmp/'
            sh 'ssh root@192.168.2.6 sh runDMP.sh'
        }
    }
}