def call(String repoUrl) {
  pipeline {
       agent any
       stages {
           stage("First Print stage") {
               steps {
                   sh "echo First"
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
