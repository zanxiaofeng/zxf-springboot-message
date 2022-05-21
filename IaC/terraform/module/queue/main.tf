terraform {
  required_providers {
    rabbitmq = {
      source = "cyrilgdn/rabbitmq"
      version = "~> 1.5.0"
    }
  }
}

resource "rabbitmq_queue" "this" {
  name = var.name
  vhost = "/"

  settings {
    durable = false
    auto_delete = false
  }
}