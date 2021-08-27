FROM node:14.17.0-alpine as build-step
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
RUN npm install
RUN npm run build


FROM nginx:1.17.1-alpine
# support running as arbitrary user which belogs to the root group
RUN chmod g+rwx /var/cache/nginx /var/run /var/log/nginx
# users are not allowed to listen on priviliged ports
COPY nginx/default.conf /etc/nginx/conf.d/
RUN sed -i.bak 's/listen\(.*\)80;/listen 8081;/' /etc/nginx/conf.d/default.conf
# comment user directive as master process is run as user in OpenShift anyhow
RUN sed -i.bak 's/^user/#user/' /etc/nginx/nginx.conf
COPY --from=build-step /usr/local/app/dist/routed-app /usr/share/nginx/html

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
