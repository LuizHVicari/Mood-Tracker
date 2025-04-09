package com.luizvicari.moodtracker.ui.commom

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luizvicari.moodtracker.R
import com.luizvicari.moodtracker.ui.theme.MoodTrackerTheme

@Composable
fun AppTitle(modifier: Modifier = Modifier) {
    Row (horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Text(text = stringResource(R.string.app_title_word_1), color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.titleLarge)
        Text(text = stringResource(R.string.app_title_word_2), color = MaterialTheme.colorScheme.secondary, style = MaterialTheme.typography.titleLarge)
    }
}

@Preview
@Composable
private fun AppTitlePreview() {
    MoodTrackerTheme {
        AppTitle()
    }
}