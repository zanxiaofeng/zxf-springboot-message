terraform {
  required_providers {
    rabbitmq = {
      source  = "cyrilgdn/rabbitmq"
      version = "~> 1.5.0"
    }
  }
  backend "local" {
  }
}

provider "rabbitmq" {
  endpoint = "http://127.0.0.1:15672"
  username = "admin"
  password = "123456"
}

module "service-a-queue" {
  source = "./module/queue"
  name   = "service-a-queue"
}

module "service-b-queue" {
  source = "./module/queue"
  name   = "service-b-queue"
}

module "topic-user" {
  source = "./module/exchange"
  name   = "topic-user"
  type   = "topic"
}

module "topic-user_service-a-queue_binding" {
  source      = "./module/binding"
  exchange    = "${module.topic-user.name}"
  destination = "${module.service-a-queue.name}"
  routingKey  = "user.*"
}

module "topic-user_service-b-queue_binding" {
  source      = "./module/binding"
  exchange    = "${module.topic-user.name}"
  destination = "${module.service-b-queue.name}"
  routingKey  = "user.*"
}