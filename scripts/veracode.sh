rm -rf /warsdev/projectB/pri-prem-ecs-service.war	
cp $WORKSPACE/target/*.war /warsdev/projectB/
sed -i 's/.*pripremecsservice.*/pripremecsservice = yes/' /tmp/DevDeployment_B.properties

#VeraCode Scan
rm -rf /var/lib/cjt/workspace/CA-VeraCode_StaticeScan/VeraCode_Scan/Pri-prem-ecs-services/*
cp $WORKSPACE/target/pri-prem-ecs-service.war /var/lib/cjt/workspace/CA-VeraCode_StaticeScan/VeraCode_Scan/Pri-prem-ecs-services