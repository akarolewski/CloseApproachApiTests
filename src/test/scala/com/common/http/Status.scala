package com.common.http

//Expected statuses
object Status {
  final val OK: Int = 200
  final val CREATED: Int = 201
  final val ACCEPTED: Int = 202
  final val NO_CONTENT: Int = 204
  final val FOUND: Int = 302
  final val BAD_REQUEST: Int = 400
  final val FORBIDDEN: Int = 403
  final val NOT_FOUND: Int = 404
  final val CONFLICT: Int = 409
  final val TOO_MANY_REQUESTS: Int = 429
}
