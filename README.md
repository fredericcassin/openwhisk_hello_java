# Test Java packages for OpenWhisk
## Install the IBM Cloud CLI

See https://cloud.ibm.com/docs/cli/reference/ibmcloud?topic=cloud-cli-install-ibmcloud-cli&locale=en
See https://cloud.ibm.com/docs/openwhisk?topic=cloud-functions-cloudfunctions_cli&locale=en#cloudfunctions_cli

Download the wsk bin file from https://github.com/apache/incubator-openwhisk-cli/releases/tag/latest

Copy the wsk and wskdeploy executable file in the ~/bin folder to have access to these commands from anywhere.

IMPORTANT: Use following commands from the git bash console on Windows 10:
```bash
ibmcloud login
# During the login phase, choose eu-gb (London) :

ibmcloud plugin install cloud-functions
ibmcloud plugin list

ibmcloud target --cf
# ibmcloud target -r eu-gb -o "your org" -s "your space"
ibmcloud target -r eu-gb -o "frederic.cassin@yahoo.fr" -s dev

ibmcloud fn property get --auth
ibmcloud fn property get --apihost

wskdeploy sync --projectname Hello -m manifest_hello_world_java_actions.yaml
wskdeploy export --projectname Hello -m exported_manifest_hello_world_java_actions.yaml
wskdeploy undeploy --projectname Hello


# Test using wsk CLI
wsk action invoke --result hello_world_package/hello1 --param name Mickey
wsk action invoke --result hello_world_package/hello2 --param name Mickey
# Test using ibmcloud CLI
ibmcloud fn action invoke --result hello_world_package/hello1 --param name Mickey
ibmcloud fn action invoke --result hello_world_package/hello2 --param name Mickey
```

## 

