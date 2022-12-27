package br.pro.celsofurtado.gamesjc20.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.pro.celsofurtado.gamesjc20.R
import br.pro.celsofurtado.gamesjc20.ui.theme.GamesJC20Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamesJC20Theme {
                Column {
                    LoginHeader()
                    FormLogin()
                }
            }
        }
    }
}

@Composable
fun LoginHeader() {
    var checkEsqueceu by remember {
        mutableStateOf(false)
    }

    var nome by remember {
        mutableStateOf("")
    }

    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .background(Color.Transparent)
            .padding(bottom = 8.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    modifier = Modifier
                        .padding(top = 40.dp)
                        .size(70.dp),
                    painter = painterResource(id = R.drawable.joystick64),
                    contentDescription = "App icon",
                    contentScale = ContentScale.Crop
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .padding(end = 32.dp, bottom = 32.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Login",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun FormLogin() {

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Efetue o login para ter acesso a todos os recursos do aplicativo.",
                fontSize = 14.sp,
                color = Color(168, 168, 168)
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)
                    .background(Color.Transparent),
                placeholder = {
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "Seu E-mail",
                        color = Color(168, 168, 168)
                    )
                },
                value = email, onValueChange = { email = it },
                shape = RoundedCornerShape(percent = 50),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_email_24),
                        contentDescription = "E-mail icon",
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(start = 24.dp)
                    )
                }
            )
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                placeholder = {
                    Text(
                        modifier = Modifier.padding(start = 4.dp),
                        text = "Sua senha",
                        color = Color(168, 168, 168)
                    )
                },
                value = password, onValueChange = { password = it },
                shape = RoundedCornerShape(percent = 50),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_key_24),
                        contentDescription = "Password icon",
                        tint = MaterialTheme.colors.primary,
                        modifier = Modifier
                            .padding(start = 24.dp)
                    )
                },
                visualTransformation = PasswordVisualTransformation()
            )
            ClickableText(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 16.dp),
                text = AnnotatedString("Esqueceu a senha?"),
                onClick = {},
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(168, 168, 168)
                )
            )
        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(percent = 50),
            onClick = { /*TODO*/ }
        ) {
            Text(text = "LOGIN")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Não tem uma conta?",
                color = Color(168, 168, 168),
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(end = 8.dp)
            )
            ClickableText(
                text = AnnotatedString("Registrar"),
                onClick = {},
                style = TextStyle(
                    color = MaterialTheme.colors.primary,
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginHeaderPreview() {
    GamesJC20Theme {
        LoginHeader()
    }
}

@Preview(showBackground = true, heightDp = 500)
@Composable
fun FormLoginPreview() {
    GamesJC20Theme {
        FormLogin()
    }
}