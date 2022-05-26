terraform {
  required_providers {
    rabbitmq = {
      source  = "cyrilgdn/rabbitmq"
      version = "~> 1.5.0"
    }
  }
}

resource "rabbitmq_exchange" "this" {
  name  = var.name
  vhost = "/"

  settings {
    type        = var.type
    durable     = false
    auto_delete = false
  }
}