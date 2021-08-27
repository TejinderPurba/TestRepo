FROM node:14.17.0-alpine as build-step
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
RUN npm install
RUN npm run build


FROM nginx:1.17.1-alpine

EXPOSE 80
