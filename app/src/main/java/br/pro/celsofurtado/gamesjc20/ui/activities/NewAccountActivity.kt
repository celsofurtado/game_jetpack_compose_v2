package br.pro.celsofurtado.gamesjc20.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.pro.celsofurtado.gamesjc20.R
import br.pro.celsofurtado.gamesjc20.ui.theme.GamesJC20Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Card(
                    modifier = Modifier
                        .clip(shape = CircleShape),
                    backgroundColor = Color.Gray
                ) {
                    Image(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(64.dp),
                        painter = painterResource(id = R.drawable.user),
                        contentDescription = "",
                        contentScale = ContentScale.Crop
                    )
                }
                Image(
                    modifier = Modifier
                        .offset(x = 30.dp, y = (-100).dp)
                        .clip(shape = CircleShape)
                        .background(Color.White),
                    painter = painterResource(id = R.drawable.ic_edit_24),
                    contentDescription = "")
            }
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
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "DADOS DO JOGADOR",
                        color = Color.Gray,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth()
                    )
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
                                imageVector = Icons.Filled.Visibility,
                                contentDescription = "",
                                tint = MaterialTheme.colors.primary
                            )
                        },
                        label = {
                            Text(text = "Senha do jogador")
                        }
                    )
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
                    var isMale by remember {
                        mutableStateOf(false)
                    }
                    var isFemale by remember {
                        mutableStateOf(false)
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Switch(checked = isFemale, onCheckedChange = {
                            isFemale = true
                            isMale = false
                        })
                        Text(text = "Feminino")
                        Spacer(modifier = Modifier.width(16.dp))
                        Switch(checked = isMale, onCheckedChange = {
                            isMale = true
                            isFemale = false
                        })
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
                    val levels = listOf("Básico", "Intermediário", "Avançado")
                    var expanded by remember {
                        mutableStateOf(false)
                    }
                    var selectedLevel by remember {
                        mutableStateOf("Selecione uma opção")
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(shape = RoundedCornerShape(percent = 50)),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        TextButton(
                            onClick = { expanded = true },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Row(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = "$selectedLevel",
                                    color = Color.Gray
                                )
                                Icon(imageVector = Icons.Filled.ArrowDropDown, contentDescription = "")
                            }
                        }
                        DropdownMenu(expanded = expanded, onDismissRequest = { /*TODO*/ }) {
                            levels.forEach { level ->
                                DropdownMenuItem(onClick = {
                                    expanded = false
                                    selectedLevel = level
                                }) {
                                    Text(text = level)
                                }
                            }
                        }
                    }
                }
                // ---------------------------
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    shape = RoundedCornerShape(percent = 40),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "SALVAR")
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
        fontSize = MaterialTheme.typography.subtitle1.fontSize,
        color = MaterialTheme.colors.primary
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NewAccountActivityPreview() {
    NewAccountHeader()
}