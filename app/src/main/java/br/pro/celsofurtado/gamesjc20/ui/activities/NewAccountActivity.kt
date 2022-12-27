package br.pro.celsofurtado.gamesjc20.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.pro.celsofurtado.gamesjc20.ui.theme.GamesJC20Theme

class NewAccountActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamesJC20Theme {
                Surface(
                    color = Color.LightGray,
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    NewAccountHeader()
                }

            }
        }
    }
}

@Composable
fun NewAccountHeader() {
    Column(
        modifier = Modifier.wrapContentHeight()
    ) {
        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier
                .clip(
                    shape = RoundedCornerShape(
                        bottomStart = 32.dp,
                        bottomEnd = 32.dp
                    )
                )
                .fillMaxWidth()
                .height(200.dp)
        ) {
            // TODO -> Conteúdo do card superior
        }
        Card(
            backgroundColor = MaterialTheme.colors.onPrimary,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
                .fillMaxSize()
                .offset(y = (-44).dp)
                .clip(shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    textAlign = TextAlign.Center,
                    text = "DADOS DO JOGADOR",
                    color = Color.Gray,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth()
                )
//                TextLabel(
//                    label = "Nome do jogador",
//                    modifier = Modifier
//                        .padding(
//                            top = 32.dp,
//                            bottom = 8.dp
//                        )
//                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    shape = RoundedCornerShape(percent = 40),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    label = {
                        Text(text = "Nome do jogador")
                    }
                )
//                TextLabel(
//                    label = "E-mail do jogador",
//                    modifier = Modifier
//                        .padding(
//                            top = 16.dp,
//                            bottom = 8.dp
//                        )
//                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(percent = 40),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Email,
                            contentDescription = "",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    label = {
                        Text(text = "E-mail do jogador")
                    }
                )
//                TextLabel(
//                    label = "Senha do jogador",
//                    modifier = Modifier
//                        .padding(
//                            top = 16.dp,
//                            bottom = 8.dp
//                        )
//                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(percent = 40),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = "",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = "",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    label = {
                        Text(text = "Senha do jogador")
                    }
                )
//                TextLabel(
//                    label = "Data de nascimento",
//                    modifier = Modifier
//                        .padding(
//                            top = 16.dp,
//                            bottom = 8.dp
//                        )
//                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    shape = RoundedCornerShape(percent = 40),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "",
                            tint = MaterialTheme.colors.primary
                        )
                    },
                    label = {
                        Text(text = "Nascimento (dd/mm/aaaa)")
                    }
                )
                TextLabel(
                    label = "Sexo",
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 4.dp
                        )
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Switch(checked = false, onCheckedChange = {})
                    Text(text = "Feminino")
                    Spacer(modifier = Modifier.width(16.dp))
                    Switch(checked = true, onCheckedChange = {})
                    Text(text = "Masculino")
                }
                TextLabel(
                    label = "Nível do jogador",
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 8.dp
                        )
                )
                var exibir by remember {
                    mutableStateOf(true)
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    DropdownMenu(
                        modifier = Modifier.fillMaxWidth().height(40.dp),
                        expanded = exibir,
                        onDismissRequest = { exibir = false }
                    ) {
                        DropdownMenuItem(
                            onClick = { exibir = false },
                        ) {
                            Text(text = "Iniciante")
                        }
                        DropdownMenuItem(onClick = { exibir = false }) {
                            Text(text = "Intermediário")
                        }
                        DropdownMenuItem(onClick = { exibir = false }) {
                            Text(text = "Avançado")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TextLabel(label: String, modifier: Modifier) {
    Text(
        modifier = modifier,
        text = label,
        fontSize = 12.sp,
        color = MaterialTheme.colors.primary
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewAccountActivityPreview() {
    NewAccountHeader()
}