variable "name" {
  description = "The name of the queue to create"
  type        = string
}

variable "type" {
  description = "The type of the exchange to create, the value will be one of direct, topic, fanout"
  type        = string
}