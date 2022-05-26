terraform {
  required_providers {
    rabbitmq = {
      source  = "cyrilgdn/rabbitmq"
      version = "~> 1.5.0"
    }
  }
}

resource "rabbitmq_binding" "this" {
  source           = var.exchange
  vhost            = "/"
  destination      = var.destination
  destination_type = "queue"
  routing_key      = var.routingKey
}