# Checkpoint 1 - Navegação entre Telas com Jetpack Compose

## 1. Descrição do projeto

Este projeto consiste em um aplicativo Android desenvolvido em **Kotlin** com **Jetpack Compose**, com o objetivo de demonstrar a navegação entre telas utilizando o **Navigation Compose**.

A aplicação possui quatro telas principais:

- **Login**
- **Menu**
- **Perfil**
- **Pedidos**

A proposta do projeto é mostrar, na prática, como realizar a navegação entre telas e como enviar e receber parâmetros por meio das rotas definidas no `NavHost`.

---

## 2. Objetivo da atividade

O objetivo desta atividade é aplicar os conceitos de navegação entre telas no Android com Jetpack Compose, implementando:

- navegação entre diferentes telas do aplicativo;
- passagem de **parâmetros obrigatórios**;
- passagem de **parâmetros opcionais**;
- uso de **mais de um parâmetro** em uma rota;
- documentação do código com explicações claras;
- organização da evolução do projeto por meio de commits no repositório.

---

## 3. Estrutura geral da aplicação

A aplicação foi organizada com uma `MainActivity` responsável por configurar a navegação, e com arquivos separados para cada tela:

- `LoginScreen.kt`
- `MenuScreen.kt`
- `PerfilScreen.kt`
- `PedidosScreen.kt`

---

## 4. Explicação da MainActivity

A `MainActivity` é o ponto central da aplicação. É nela que a navegação entre telas é configurada.

### Principais responsabilidades da MainActivity

- iniciar a interface do aplicativo;
- criar o `NavController`;
- definir o `NavHost`;
- registrar as rotas de cada tela;
- configurar os argumentos esperados em cada rota.

### Funcionamento

Dentro do `setContent`, foi utilizado um `Scaffold`, que serve como estrutura base da tela. Em seguida, foi criado o `navController` com `rememberNavController()`, que é o controlador responsável por trocar de tela durante a execução do app.

O `NavHost` foi configurado com a tela inicial `"login"` e com todas as rotas da aplicação.

---

## 5. Explicação das telas

### 5.1 LoginScreen

A `LoginScreen` é a primeira tela exibida ao usuário.

Ela possui:

- um título indicando que se trata da tela de login;
- um botão **ENTRAR**, que leva o usuário para a tela de menu.

#### Navegação realizada
Ao clicar no botão, a aplicação executa:
`navController.navigate("menu")`

### 5.2 MenuScreen

A `MenuScreen` funciona como uma tela intermediária, permitindo que o usuário escolha para qual tela deseja ir em seguida.

Ela possui:

- um título indicando que se trata da tela de menu;
- um botão Perfil;
- um botão Pedidos;
- um botão Sair.

A estrutura da tela utiliza um Box como container principal e, dentro dele, um Column centralizado para organizar os botões verticalmente. Também foi utilizado Spacer para criar espaçamento entre os botões.

Navegação realizada para Perfil
Ao clicar no botão Perfil, a aplicação executa:
`navController.navigate("perfil/Fulano de Tal/27")`

Nesse caso, a navegação envia dois parâmetros obrigatórios para a próxima tela:

- nome = "Fulano de Tal"
- idade = 27

### 5.3 PerfilScreen

A `PerfilScreen` é a tela responsável por exibir informações recebidas por parâmetros obrigatórios.

Ela recebe dois parâmetros:

- nome: String
- idade: Int

Esses valores são enviados pela rota definida na MainActivity:
`route = "perfil/{nome}/{idade}"`

Na configuração da navegação, os dois argumentos foram declarados explicitamente, sendo nome do tipo String e idade do tipo Int. Depois disso, eles são recuperados a partir de it.arguments.

Além disso, a tela possui um botão Voltar, que executa:
`navController.navigate("menu")`

### 5.4 PedidosScreen

A `PedidosScreen` é a tela utilizada para demonstrar o uso de parâmetro opcional.

Ela recebe o parâmetro:

- cliente: String?

Na `MainActivity`, a rota foi definida assim:
`route = "pedidos?cliente={cliente}"

E o argumento foi configurado com valor padrão:
`
navArgument("cliente") {
    defaultValue = "Cliente Genérico"
}
`
Isso significa que, se nenhum valor for informado durante a navegação, a aplicação utilizará automaticamente "Cliente Genérico" como valor padrão.

Na interface, a tela exibe o valor recebido com o seguinte texto:
`text = "PEDIDOS - $cliente"`

Dessa forma, quando a navegação ocorre com:
`navController.navigate("pedidos?cliente=Cliente XPTO")`
a tela apresenta o nome enviado. Caso o parâmetro não seja informado, a tela continua funcionando com o valor padrão definido na rota.

A tela também possui um botão Voltar, que executa:
`navController.navigate("menu")`


```kotlin
