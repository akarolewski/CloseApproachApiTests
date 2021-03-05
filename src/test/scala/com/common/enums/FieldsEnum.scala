package com.common.enums

//An Enum for fields from Close Approach Api response
object FieldsEnum extends Enumeration {
  type FieldsEnumType = Value
  final val DES: FieldsEnum.Value = Value("des")
  final val ORBIT_ID: FieldsEnum.Value = Value("orbit_id")
  final val JD: FieldsEnum.Value = Value("jd")
  final val CD: FieldsEnum.Value = Value("cd")
  final val DIST: FieldsEnum.Value = Value("dist")
  final val DIST_MIN: FieldsEnum.Value = Value("dist_min")
  final val DIST_MAX: FieldsEnum.Value = Value("dist_max")
  final val V_REL: FieldsEnum.Value = Value("v_rel")
  final val V_INF: FieldsEnum.Value = Value("v_inf")
  final val T_SIGMA_F: FieldsEnum.Value = Value("t_sigma_f")
  final val H: FieldsEnum.Value = Value("h")

  def isOrderType(s: String): Boolean = values.exists(_.toString == s)
}
