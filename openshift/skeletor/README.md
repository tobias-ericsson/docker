
### Deploy

prerequisite: docker

```
./gradlew clean build
docker build -t skeletor .
docker run -p 8080:8080 skeletor
```

### Deploy to Openshift locally

prerequisite: docker, oc

```
oc cluster up
oc login -u system:admin
oc adm policy add-scc-to-user anyuid -z default
oc apply -f openshift/skeletor.yml
```

### Deploy to Openshift ONLINE

oc login https://api.starter-us-west-2.openshift.com




