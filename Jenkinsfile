node("slave"){
  stage 'Build and Test'
  env.PATH = "${tool 'M3'}/bin:${env.PATH}"
  //checkout scm
  git url:"https://github.com/iyangdidi/sportstory.git"
  sh 'mvn clean package'
 }