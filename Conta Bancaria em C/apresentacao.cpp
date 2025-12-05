#include <stdio.h>
#include <string.h>

// Definições de constantes
#define MAX_CONTAS 20
#define MAX_TRANSACOES 10
#define MAX_TITULAR 50

//Gabriel Wellington e Gabriel Aoki - Gerenciamento de Conta bancária

// Estrutura para representar uma conta bancária
typedef struct {
    int numeroConta;                // Número da conta
    char titular[MAX_TITULAR];       // Nome do titular da conta
    float saldo;                     // Saldo atual da conta
    float transacoes[MAX_TRANSACOES]; // Histórico de transações (depósito/saque)
    int numTransacoes;               // Número de transações realizadas
} ContaBancaria;

// Protótipos das funções
void cadastrarConta(ContaBancaria contas[], int *numContas);
void registrarTransacao(ContaBancaria *conta, float valor);
void exibirExtrato(ContaBancaria conta);
float calcularSaldoTotal(ContaBancaria contas[], int numContas);
void exibirMenu();

int main() {
    ContaBancaria contas[MAX_CONTAS]; // Array para armazenar as contas bancárias
    int numContas = 0;                 // Número de contas cadastradas
    int opcao;                          // Variável para armazenar a opção escolhida pelo usuário

    // Loop infinito para exibir o menu até o usuário escolher sair
    while (1) {
        exibirMenu();  // Exibe o menu de opções
        printf("Escolha uma opcao: ");
        scanf("%d", &opcao);

        switch (opcao) {
            case 1:
                // Cadastrar uma nova conta
                cadastrarConta(contas, &numContas);
                break;

            case 2: {
                // Registrar uma transação (depósito ou saque)
                int numeroConta;
                float valor;

                printf("Informe o numero da conta: ");
                scanf("%d", &numeroConta);
                printf("Informe o valor da transacao (positivo para deposito, negativo para saque): ");
                scanf("%f", &valor);

                // Procurar a conta e registrar a transação
                int i;
                for (i = 0; i < numContas; i++) {
                    if (contas[i].numeroConta == numeroConta) {
                        registrarTransacao(&contas[i], valor);
                        break;
                    }
                }

                if (i == numContas) {
                    printf("Conta nao encontrada.\n");
                }
                break;
            }

            case 3: {
                // Exibir o extrato de uma conta
                int numeroConta;
                printf("Informe o numero da conta para exibir o extrato: ");
                scanf("%d", &numeroConta);

                // Procurar a conta e exibir o extrato
                int i;
                for (i = 0; i < numContas; i++) {
                    if (contas[i].numeroConta == numeroConta) {
                        exibirExtrato(contas[i]);
                        break;
                    }
                }

                if (i == numContas) {
                    printf("Conta nao encontrada.\n");
                }
                break;
            }

            case 4:
                // Calcular e exibir o saldo total do banco
                printf("Saldo total do banco: %.2f\n", calcularSaldoTotal(contas, numContas));
                break;

            case 5:
                // Sair do programa
                printf("Saindo...\n");
                return 0;

            default:
                // Caso a opção seja inválida
                printf("Opçao invalida.\n");
        }
    }

    return 0;
}

// Função para cadastrar uma nova conta bancária
void cadastrarConta(ContaBancaria contas[], int *numContas) {
    // Verifica se o número máximo de contas já foi alcançado
    if (*numContas >= MAX_CONTAS) {
        printf("Numero maximo de contas cadastradas atingido.\n");
        return;
    }

    // Cria uma nova conta
    ContaBancaria novaConta;
    novaConta.numTransacoes = 0;  // Inicializa o número de transações
    novaConta.saldo = 0.0f;       // Inicializa o saldo da conta

    // Solicita os dados da nova conta
    printf("Informe o numero da conta: ");
    scanf("%d", &novaConta.numeroConta);
    getchar();  // Limpa o buffer de entrada após ler o número da conta

    printf("Informe o nome do titular: ");
    fgets(novaConta.titular, MAX_TITULAR, stdin);
    novaConta.titular[strcspn(novaConta.titular, "\n")] = '\0';  // Remove o '\n' do final da string

    // Adiciona a nova conta ao array de contas e atualiza o número de contas
    contas[*numContas] = novaConta;
    (*numContas)++;
    printf("Conta cadastrada com sucesso!\n");
}

// Função para registrar uma transação (depósito ou saque)
void registrarTransacao(ContaBancaria *conta, float valor) {
    // Verifica se o limite de transações foi atingido
    if (conta->numTransacoes >= MAX_TRANSACOES) {
        printf("Limite de transacoes atingido para esta conta.\n");
        return;
    }

    // Registra a transação e atualiza o saldo da conta
    conta->transacoes[conta->numTransacoes] = valor;
    conta->numTransacoes++;
    conta->saldo += valor;  // Atualiza o saldo com o valor da transação

    printf("Transacao registrada com sucesso. Novo saldo: %.2f\n", conta->saldo);
}

// Função para exibir o extrato de uma conta
]void exibirExtrato(ContaBancaria conta) {
    // Exibe o extrato da conta, incluindo transações realizadas
    printf("\nExtrato da Conta: %d\n", conta.numeroConta);
    printf("Titular: %s\n", conta.titular);
    printf("Saldo atual: %.2f\n", conta.saldo);

    printf("\nTransacoes:\n");
    for (int i = 0; i < conta.numTransacoes; i++) {
        printf("Transacao %d: %.2f\n", i + 1, conta.transacoes[i]);
    }
    printf("\n");
}

// Função para calcular o saldo total de todas as contas
float calcularSaldoTotal(ContaBancaria contas[], int numContas) {
    float saldoTotal = 0.0f;

    // Soma o saldo de todas as contas
    for (int i = 0; i < numContas; i++) {
        saldoTotal += contas[i].saldo;
    }

    return saldoTotal;
}

// Função para exibir o menu de opções
void exibirMenu() {
    printf("\n===== MENU =====\n");
    printf("1. Cadastrar nova conta\n");
    printf("2. Registrar transacao (deposito/saque)\n");
    printf("3. Exibir extrato de uma conta\n");
    printf("4. Calcular saldo total do banco\n");
    printf("5. Sair\n");
}
