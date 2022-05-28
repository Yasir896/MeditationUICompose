package com.techlads.meditation


/**
 * Created by Yasir on 5/16/2022.
 */

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Path
import com.techlads.meditation.ui.theme.*
import kotlin.math.abs

fun Path.standardQuadFromTo(from: Offset, to: Offset) {
    quadraticBezierTo(
        from.x,
        from.y,
        abs(from.x + to.x) / 2f,
        abs(from.y + to.y) / 2f
    )
}

class Util {
    companion object {
        val feature = listOf(
            Feature(
                title = "Sleep meditation",
                R.drawable.ic_headphone,
                BlueViolet1,
                BlueViolet2,
                BlueViolet3
            ),
            Feature(
                title = "Tips for sleeping",
                R.drawable.ic_videocam,
                LightGreen1,
                LightGreen2,
                LightGreen3
            ),
            Feature(
                title = "Night island",
                R.drawable.ic_headphone,
                OrangeYellow1,
                OrangeYellow2,
                OrangeYellow3
            ),
            Feature(
                title = "Calming sounds",
                R.drawable.ic_headphone,
                Beige1,
                Beige2,
                Beige3
            )
        )
    }
}