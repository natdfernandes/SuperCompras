package com.example.supercompras

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.supercompras.ui.theme.SuperComprasTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Checkbox
import com.example.supercompras.ui.theme.Typography
import androidx.compose.ui.text.style.TextAlign
import com.example.supercompras.ui.theme.Marinho

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperComprasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        ImagemTopo(modifier = Modifier.padding(innerPadding))
                        Titulo(
                            texto = "Lista de compras",
                            modifier = Modifier.padding(innerPadding)
                        )
                        ItemDaLista(modifier = Modifier.padding(innerPadding))
                        Titulo(texto = "Comprado", modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun Titulo(texto: String, modifier: Modifier = Modifier) {
    Text(text = texto, style = typography.headlineLarge, modifier = modifier)
}

@Composable
fun ItemDaLista(modifier: Modifier = Modifier) {
    Row {
        Checkbox(
            checked = false,
            onCheckedChange = {},
            modifier = modifier.padding(end = 8.dp)
        )
        Text(
            text = "Suco",
            modifier = modifier,
            style = Typography.bodyMedium,
            textAlign = TextAlign.Center
        )
        Icone(Icons.Default.Delete, modifier = modifier.size(16.dp))
        Icone(Icons.Default.Edit, modifier = modifier.size(16.dp))
    }
}

@Composable
fun ImagemTopo(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.image_topo),
        contentDescription = null,
        modifier = modifier.size(160.dp)
    )

}

@Composable
fun Icone(icone: ImageVector, modifier: Modifier = Modifier) {
    Icon(icone, contentDescription = "Editar", modifier = modifier, tint = Marinho)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello Natalia!",
        modifier = modifier
    )
}

@Preview
@Composable
private fun ItemDaListaPreview() {
    SuperComprasTheme {
        ItemDaLista()
    }
}

@Preview
@Composable
private fun IconeEditPreview() {
    SuperComprasTheme() {
        Icone(icone = Icons.Default.Delete)
    }

}

@Preview
@Composable
private fun ImagemTopoPreview() {
    SuperComprasTheme {
        ImagemTopo()
    }

}

@Preview
@Composable
private fun TituloPreview() {
    SuperComprasTheme() {
        Titulo(texto = "Lista de compras")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperComprasTheme {
        Greeting("Android")
    }
}