docker run -p 8901:8901 \
-v /Users/andying/github/maloong-zhang/api-gateway/doc/api-gateway/nginx/nginx:/data/nginx \
-v /var/run/docker.sock:/var/run/docker.sock \
--name api-gateway-center \
-d api-gateway-center:1.0.0 CP4-LISTEN:8901,fork,reuseaddr UNIX-CONNECT:/var/run/docker.sock TCP4-LISTEN:8901,fork,reuseaddr UNIX-CONNECT:/var/run/docker.sock
