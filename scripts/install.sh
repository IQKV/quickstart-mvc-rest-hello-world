#!/bin/bash

# set -e
set -x

. ./set-env.sh


#minikube addons enable ingress

cd ../k8s || exit

kubectl config use-context $CLUSTER_NAME

kubectl apply -n $K8S_NAMESPACE -f configmap.yaml
kubectl apply -n $K8S_NAMESPACE -f deployment.yaml
kubectl apply -n $K8S_NAMESPACE -f ingress.yaml

# set Minikupe IP for hello-world.info in /etc/hosts
minikube profile $CLUSTER_NAME
CLUSTER_IP=$(minikube ip)
echo $CLUSTER_IP
sudo sed -i.bak 's/.*hello-world.info/'"$CLUSTER_IP"' hello-world.info/' /etc/hosts && sudo rm /etc/hosts.bak
echo "$(minikube ip) hello-world.info" | sudo tee -a /etc/hosts

cd ../scripts || exit
