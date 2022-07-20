#!/bin/bash

set -x

.  ./set-env.sh

kubectl config set-context $CLUSTER_NAME
kubectl config use-context $CLUSTER_NAME

kubectl delete -n $K8S_NAMESPACE deployment hello-world
kubectl delete -n $K8S_NAMESPACE service hello-world
kubectl delete -n $K8S_NAMESPACE configmap hello-world