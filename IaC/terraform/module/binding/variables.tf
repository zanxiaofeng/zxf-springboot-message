variable "exchange" {
  description = "The name of the source exchange"
  type        = string
}

variable "destination" {
  description = "The name of destination queue"
  type        = string
}

variable "routingKey" {
  description = "routingKey"
  type        = string
}