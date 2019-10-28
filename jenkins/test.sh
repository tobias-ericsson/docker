

JENKINS_URL="http://localhost:8080"
USER="tobias"
PASSWORD="test"
JOB_NAME="FirstJob2"

 # API: 
 # http://my.jenkins.com/api/?
 # 
 # LIST JOBS:
 # http://my.jenkins.com/api/xml
 #
 # DELETE JOB:
 # curl -X POST "http://my.jenkins.com/job/<JOB-NAME>/doDelete"

job_exist () {
  local job_name="$1"
  #curl ${JENKINS_URL}/job/${JOB_NAME}/api/json?tree=name --user ${USER}:${PASSWORD} 
  response=$(curl -s -o /dev/null -w "%{http_code}" ${JENKINS_URL}/job/${job_name}/api/json?tree=name --user ${USER}:${PASSWORD})
  if [ "200" = "${response}" ] ; then
    echo "job ${job_name} exist (${response})"
    return 0
  else
    echo "job ${job_name} not found (${response})"
    return 1
  fi
}

if_job_missing_create_it () {
  local job_name="$1"
  #curl ${JENKINS_URL}/job/${JOB_NAME}/api/json?tree=name --user ${USER}:${PASSWORD} 
  response=$(curl -s -o /dev/null -w "%{http_code}" ${JENKINS_URL}/job/${job_name}/api/json?tree=name --user ${USER}:${PASSWORD})
  if job_exist ${job_name} ; then
    echo "can not create ${job_name} as it already exist"
  else
    echo "creating job ${job_name}"
    curl -X POST -H "Content-Type:application/xml" -d @jjob-config.xml ${JENKINS_URL}/createItem?name=${job_name} --user ${USER}:${PASSWORD}
  fi
}

if_job_exist_delete_it () {
  local job_name="$1"
  if job_exist ${job_name} ; then
    echo "deleting ${job_name}"
    curl -X POST ${JENKINS_URL}/job/${job_name}/doDelete --user ${USER}:${PASSWORD}
  else
    echo "no job to delete"
  fi 
}

run_job () {
  local job_name="$1"
  echo "running job"
  curl -X POST ${JENKINS_URL}/job/${job_name}/build --user ${USER}:${PASSWORD}
}

download_job () {
  local job_name="$1"
  echo "downloading job"
  curl ${JENKINS_URL}/job/${JOB_NAME}/config.xml --user ${USER}:${PASSWORD} > jjob-config.xml
}

if_job_missing_create_it ${JOB_NAME}

run_job ${JOB_NAME}

download_job ${JOB_NAME}

#if_job_exist_delete_it ${JOB_NAME}

# READ JOB:
#curl ${JENKINS_URL}/job/${JOB_NAME}/config.xml --user ${USER}:${PASSWORD} > jjob-config.xml
 
#CREATE JOB: Create AA_TEST_JOB2 by using xml for configuration
# need to Manage Jenkins -> Configure Global Security -> CSRF Protection -> disable "Prevent Cross Site Request Forgery exploits"
#curl -X POST -H "Content-Type:application/xml" -d "<project><builders/><publishers/><buildWrappers/></project>" "http://my.jenkins.com/createItem?name=AA_TEST_JOB2"

#curl -X POST -H "Content-Type:application/xml" -d @jjob-config.xml ${JENKINS_URL}/createItem?name=SecondJob --user ${USER}:${PASSWORD}
 