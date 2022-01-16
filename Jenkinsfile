parameters([
        gitParameter(branch: '',
                branchFilter: 'origin/(.*)',
                defaultValue: 'master',
                description: '',
                name: 'GIT_BRANCH',
                quickFilterEnabled: false,
                selectedValue: 'NONE',
                sortMode: 'NONE',
                tagFilter: '*',
                type: 'PT_BRANCH')
])

node {
    stage('File Param WA') {
        writeFile file: '${WORKSPACE}/api/src/main/resources/', text: params.application_secret
    }
    stage("Parameter Check") {
        echo 'Start'
        echo "env.JOB_NAME - " + env.JOB_NAME
        echo "params.GIT_BRANCH - " + params.GIT_BRANCH
        git_branch = params.GIT_BRANCH.replace("origin/", "")

        echo "build with this branch : ${git_branch}"
    }
    stage('Clone') {
        git branch: "${git_branch}", credentialsId: 'jenkins_token', url: 'https://github.com/minssan9/backend_ejr.git'
    }
    stage("Compilations") {
        sh "chmod +x gradlew"
        sh "./gradlew :api:clean :api:build -x test"
    }
    stage("Build Docker Image") {
        sh "docker build -t ${env.JOB_NAME}_${git_branch}:${BUILD_NUMBER} --build-arg SPRING_PROFILES_ACTIVE=${git_branch} ./api"
//        sh "docker build -t euljiro_api_develop --build-arg SPRING_PROFILES_ACTIVE=develop ./api"
    }

//    stage("Build Docker Image") {
//        sh "docker push ${env.JOB_NAME}_${git_branch}:${BUILD_NUMBER}"
//    }

    stage('deploy in develop env') {
        if (git_branch == "develop") {
            try {
//                sh "docker pull ${env.JOB_NAME}_${git_branch}:${BUILD_NUMBER}"

                sh "docker rm -f ${env.JOB_NAME}_${git_branch}"
                sh "docker run -it -d -p 44001:44001 -v /var/log:/var/log -e SPRING_PROFILES_ACTIVE=${git_branch} -h ${env.JOB_NAME} --name ${env.JOB_NAME}_${git_branch} ${env.JOB_NAME}_${git_branch}:${BUILD_NUMBER} "
                // docker run -it -d -p 44001:44001 -v /var/log:/var/log -e SPRING_PROFILES_ACTIVE=develop  -h backend_ejr --name euljiro_api_develop euljiro_api_develop
            } catch (e) {
                sh 'echo develop deploy Fail!!'
            }
        }
    }


    stage('deploy in release env') {
        if (git_branch == "release") {
            sh 'docker tag nodejs:latest 293001004573.dkr.ecr.ap-northeast-2.amazonaws.com/${env.JOB_NAME}:latest'

            withAWS(role: 'euljiro', roleAccount: '293001004573', externalId: 'externalId') {
                sh 'aws ecr get-login-password --region ap-northeast-2 | docker login --username AWS --password-stdin 293001004573.dkr.ecr.ap-northeast-2.amazonaws.com/${env.JOB_NAME}'
                sh 'docker push 293001004573.dkr.ecr.ap-northeast-2.amazonaws.com/${env.JOB_NAME}:latest'
            }
            try {
                // release redeploy
                withAWS(region: 'ap-northeast-2', credentials: 'jenkinsaws') {
                    sh """
                    aws ecs update-service \
                    --region ap-northeast-2 \
                    --cluster ${env.JOB_NAME} \
                    --service ${env.JOB_NAME} \
                    --force-new-deployment \
                    --desired-count 2
                    aws ecs wait services-stable \
                    --cluster ${env.JOB_NAME} \
                    --services ${env.JOB_NAME}D
                """
                }
            } catch (e) {
                sh 'echo release deploy Fail!!'
            }
        }
    }
}
