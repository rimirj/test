def call(String firstparam){
pipeline {
	agent any	
	stages {
		stage("First Stage") {
			steps {
				sh "echo ${firstparam}"
				
				  }
			}
		}
	}
}