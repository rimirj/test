def call(String repoUrl , String nextparam) {
  pipeline {
       agent any
       stages {
           stage("First Print stage") {
               steps {
		       sh "echo ${nextparam}"
               }
           }
           stage("Second Print") {
               steps {
		       sh "echo ${repoUrl}"
                       
               }
           }
           
       }
   }
}
