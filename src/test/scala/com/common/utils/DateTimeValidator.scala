package com.common.utils

import java.text.{ParseException, SimpleDateFormat}
import java.util.Date

//DateTimeValidator to check whether a given string is a date in a specified format
object DateTimeValidator {

  final val DATE_TIME_FORMAT = "yyyy-MMM-dd HH:mm"
  final val DATE_FORMAT = "yyyy-MM-dd"

  //Here I couldn't just put assert inside since SimpleDateFormat's method 'parse()' returns true if
  //given string is of given pattern, but if not, then the exception is thrown instead of false
  def isValidDate(date: String): Boolean = {
    try {
      new SimpleDateFormat(DATE_TIME_FORMAT).parse(date)
      true
    } catch {
      case _: ParseException => false
    }
  }

  def parseDate(date: String, format: String): Date = {
    try {
      new SimpleDateFormat(format).parse(date)
    } catch {
      case _: ParseException =>
        throw new ParseException(s"Program encountered an error while parsing provided date: $date.", 0)
    }
  }

  def isDateInRange(date: String, date_min: String, date_max: String): Boolean = {
    val checkedDate = parseDate(date, DATE_TIME_FORMAT)
    val date_from = parseDate(date_min, DATE_FORMAT)
    val date_to = parseDate(date_max, DATE_FORMAT)
    if (checkedDate.after(date_from) && checkedDate.before(date_to)) true else false
  }
}
