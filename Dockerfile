FROM maven:3-alpine

RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh