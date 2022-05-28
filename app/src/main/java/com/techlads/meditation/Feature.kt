package com.techlads.meditation

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color


/**
 * Created by Yasir on 5/16/2022.
 */

data class Feature(
    val title: String,
    @DrawableRes var iconId: Int,
    val lightColor: Color,
    val mediumColor: Color,
    val darkColor: Color,

)
