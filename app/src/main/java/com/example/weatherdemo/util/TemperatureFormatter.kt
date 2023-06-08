package com.example.weatherdemo.util

import android.icu.text.MeasureFormat
import android.icu.text.MeasureFormat.FormatWidth
import android.icu.util.Measure
import android.icu.util.MeasureUnit
import android.icu.util.ULocale


var fmtCA: MeasureFormat = MeasureFormat.getInstance(ULocale.CANADA, FormatWidth.SHORT)

fun formatTemperature(value: Double): String {
    val measure = Measure(value, MeasureUnit.CELSIUS)
    //val measure = Measure(value, MeasureUnit.FAHRENHEIT)
    return fmtCA.format(measure)
}
