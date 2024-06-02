package com.github.gustavobarbosab.androidcourse.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingBig
import com.github.gustavobarbosab.androidcourse.ui.common.size.paddingSmall
import com.github.gustavobarbosab.androidcourse.ui.common.theme.primaryLight

@Composable
fun AppToolbar(
    title: String,
    onBackButtonClicked: () -> Unit,
    icon: ImageVector = Icons.AutoMirrored.Outlined.ArrowBack,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier
            .background(primaryLight)
            .padding(paddingSmall)
    ) {
        Icon(
            icon,
            modifier = Modifier.clickable { onBackButtonClicked() },
            contentDescription = "Back button",
            tint = Color.White
        )
        Text(
            title,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = paddingBig),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}