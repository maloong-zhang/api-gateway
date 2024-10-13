docker run \
--name Nginx \
-d \
-v /Users/andying/github/maloong-zhang/api-gateway/api-gateway-center/doc/data/html:/usr/share/nginx/html \
-v /Users/andying/github/maloong-zhang/api-gateway/api-gateway-center/doc/data/nginx/nginx.conf:/etc/nginx/nginx.conf \
-p 8090:80 \
nginx
