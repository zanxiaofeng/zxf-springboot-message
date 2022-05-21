terraform {
  required_providers {
    rabbitmq = {
      source = "cyrilgdn/rabbitmq"
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
  name = "queue"
}