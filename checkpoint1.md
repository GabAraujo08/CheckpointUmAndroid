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

```kotlin
navController.navigate("menu")