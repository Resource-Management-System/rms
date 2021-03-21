#!/bin/bash
set -x
awslocal s3api create-bucket --bucket account --region eu-west-2
set +x