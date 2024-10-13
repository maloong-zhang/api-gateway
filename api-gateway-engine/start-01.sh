docker run -p 8902:8902 -p 7397:7397 \
    -e PARAMS="
    --sever.port=8902
    --api-gateway.address=http://192.168.31.251:8901
    --api-gateway.groupId=10001
    --api-gateway.gatewayId=api-gateway-g4
    --api-gateway.gatewayName=电商配送网关
    --api-gateway.gatewayAddress=192.168.31.251:7397" \
    --name api-gateway-engine-01 -d api-gateway-engine:1.0.0
