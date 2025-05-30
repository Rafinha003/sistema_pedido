# 🛒 Sistema de Pedidos Online (Java)

## 📌 Tema escolhido

Este projeto simula um **sistema de pedidos online**, permitindo a criação e o gerenciamento de pedidos com diferentes tipos de produtos, como eletrônicos e alimentos.

---

## 🧱 Arquitetura Geral

```
"trabalho-samuel/"
│
├── "Main.java"                          → Simulação prática do sistema (ponto de entrada)
│
├── "facade/"                            → Interface de uso simplificada para o usuário
│   └── "SistemaDePedidosFacade.java"   → Centraliza as operações de alto nível
│
├── "factory/"                           → Lógica de criação dos produtos
│   ├── "ProdutoFactory.java"           → Fábrica abstrata (Factory Method)
│   ├── "ProdutoEletronicoFactory.java" → Fábrica concreta de eletrônicos
│   └── "ProdutoAlimenticioFactory.java"→ Fábrica concreta de alimentos
│
├── "model/"                             → Modelos de domínio (entidades principais)
│   ├── "Produto.java"                  → Classe abstrata base
│   ├── "ProdutoEletronico.java"       → Subclasse para eletrônicos
│   ├── "ProdutoAlimenticio.java"      → Subclasse para alimentos
│   └── "Pedido.java"                  → Agregador de produtos (um pedido)
│
├── "singleton/"                         → Simulação de banco de dados
│   └── "BancoDeDados.java"            → Singleton que gerencia os dados em memória
```

## 🧩 Padrões de Projeto Utilizados

✅ 1. Factory Method
Definição: O Factory Method é um padrão criacional que encapsula a criação de objetos em subclasses, permitindo que o código cliente não precise conhecer as classes concretas que está instanciando.

Aplicação no projeto:

A classe ProdutoFactory define o método abstrato criarProduto(...).

Subclasses concretas (ProdutoEletronicoFactory, ProdutoAlimenticioFactory) implementam esse método para retornar instâncias específicas de produtos.

O cliente do sistema usa a factory adequada, mas não conhece a implementação concreta.

Por que usar?

Evita código duplicado para criação de diferentes produtos.

Facilita adicionar novos tipos de produtos (ex: ProdutoLivroFactory) sem alterar o código existente.

Segue o Princípio Aberto/Fechado (OCP): aberto para extensão, fechado para modificação.

✅ 2. Singleton
Definição: O Singleton garante que exista apenas uma instância global de uma classe e fornece um ponto de acesso controlado a ela.

Aplicação no projeto:

A classe BancoDeDados usa o padrão Singleton para armazenar listas de pedidos e produtos.

É acessada via BancoDeDados.getInstancia().

Por que usar?

Simula um banco de dados compartilhado globalmente.

Garante consistência dos dados durante toda a execução do sistema.

Substitui a necessidade de injeção de dependência ou passagem de instâncias entre classes para persistência temporária.

✅ 3. Facade
Definição: O padrão Facade fornece uma interface simplificada para um conjunto complexo de classes, escondendo os detalhes internos da lógica.

Aplicação no projeto:

A classe SistemaDePedidosFacade contém métodos de alto nível:

criarProduto(...)

criarPedido()

adicionarProdutoAoPedido()

calcularTotalPedido()

finalizarPedido()

Esses métodos chamam internamente as fábricas, manipulam o banco de dados e o pedido, mas o usuário do sistema não precisa conhecer nada disso.

Por que usar?

Isola o cliente da complexidade do sistema.

Permite que outras camadas (como uma futura interface gráfica ou API REST) utilizem o sistema de forma simples e segura.

Segue o princípio de encapsulamento e separação de responsabilidades.

## 🧩 Diagrama uml
plataforma onde foi feito: Lucidchart

<img src="imagem-uml/UML-diagrama.png" alt="Diagrama UML do sistema de pedidos" width="600"/>
