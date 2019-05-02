# Test Java packages principles for OpenWhisk
## Install the IBM Cloud CLI

See https://cloud.ibm.com/docs/cli/reference/ibmcloud?topic=cloud-cli-install-ibmcloud-cli&locale=en
See https://cloud.ibm.com/docs/openwhisk?topic=cloud-functions-cloudfunctions_cli&locale=en#cloudfunctions_cli

Download the wsk bin file from https://github.com/apache/incubator-openwhisk-cli/releases/tag/latest

Copy the wsk and wskdeploy executables file in the ~/bin folder to have access to these commands from anywhere.

Tested on windows 10 using the git bash console, but it must work like a charm on Linux.
```bash
ibmcloud login
# During the login phase, choose eu-gb (London) :

ibmcloud plugin install cloud-functions
ibmcloud plugin list

ibmcloud target --cf
ibmcloud target -r eu-gb -o "your org" -s "your space"
# example: ibmcloud target -r eu-gb -o "frederic.cassin@yahoo.fr" -s dev

ibmcloud fn property get --auth
ibmcloud fn property get --apihost

```

~/.wskprops normally contains your auth and apihost you have enter during the login phase.
so now each wsk or wskdeploy execution should use it.

## Test of handling a single package with 2 actions

Prerequisites: Java JDK >= 8 installed, Maven >= 3
```bash
git clone https://github.com/fredericcassin/openwhisk_hello_java.git
cd openwhisk_hello_java
mvn clean package

# Deploy the package
wskdeploy sync --projectname Hello -m manifest_hello_world_java_actions.yaml

# Test using wsk CLI
wsk action invoke --result hello_world_package/hello1 --param name Mickey
wsk action invoke --result hello_world_package/hello2 --param name Mickey
# Test using ibmcloud CLI
ibmcloud fn action invoke --result hello_world_package/hello1 --param name Mickey
ibmcloud fn action invoke --result hello_world_package/hello2 --param name Mickey

# Export or undeploy
wskdeploy export --projectname Hello -m exported_manifest_hello_world_java_actions.yaml
wskdeploy undeploy --projectname Hello
```

## 

