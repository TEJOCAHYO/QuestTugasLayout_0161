package com.example.questtugaslayout.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questtugaslayout.R

data class Mahasiswa(
    val nama: String,
    val phone: String? = null,
    val alamat: String,
    val colorResId: Int,
    val isCursive: Boolean = false
)

@Composable
fun ActivitasPertama(modifier: Modifier = Modifier) {
    val listMahasiswa = listOf(
        Mahasiswa(
            nama = stringResource(R.string.nama_1),
            alamat = stringResource(R.string.alamat_1),
            colorResId = R.color.card_0_bg,
            isCursive = true
        ),
        Mahasiswa(
            nama = stringResource(R.string.nama_2),
            phone = stringResource(R.string.phone_2),
            alamat = stringResource(R.string.alamat_2),
            colorResId = R.color.card_1_bg
        ),
        Mahasiswa(
            nama = stringResource(R.string.nama_3),
            phone = stringResource(R.string.phone_3),
            alamat = stringResource(R.string.alamat_3),
            colorResId = R.color.card_2_bg
        ),
        Mahasiswa(
            nama = stringResource(R.string.nama_4),
            phone = stringResource(R.string.phone_4),
            alamat = stringResource(R.string.alamat_4),
            colorResId = R.color.card_3_bg
        )
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 40.dp, start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.prodi),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(R.string.univ),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(20.dp))

        listMahasiswa.forEach { mhs ->
            CardMahasiswa(mhs)
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Copyright, 2026",
            fontSize = 12.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}

@Composable
fun CardMahasiswa(mhs: Mahasiswa) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(mhs.colorResId)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(R.drawable.umy),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = mhs.nama,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (mhs.isCursive) FontFamily.Cursive else FontFamily.Default,
                    color = Color.White
                )
                if (mhs.phone != null) {
                    Text(
                        text = mhs.phone,
                        fontSize = 12.sp,
                        color = Color(0xFF00FFFF)
                    )
                }
                Text(
                    text = mhs.alamat,
                    fontSize = 13.sp,
                    color = Color.Yellow
                )
            }

            Image(
                painter = painterResource(R.drawable.umy),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ActivitasPertamaPreview() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ActivitasPertama()
        }
    }
}