def call(String firstparam , String secondparam)
pipeline {
	agent any	
	stages {
		stage("First Stage")
			steps {
				sh "echo ${firstparam}"
				sh "echo ${secondparam}"
				  }
			}
		}