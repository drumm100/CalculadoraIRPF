# :moneybag: CalculadoraIRPF
:beginner: Calculadora de Imposto de Renda

---
:man: **Andrius Lima**

:boy: **Marcelo Drumm**

:school: Pontifícia Universidade Católica do Rio Grande do Sul (PUCRS)

---

Regras para o cálculo
================
1.  Todo contribuinte pode ou não cadastrar dependentes;
    
2.  Todo contribuinte pode informar despesas com saúde e educação próprias ou de seus dependentes;
    
3.  Todo contribuinte DEVE informar todos os seus rendimentos sejam eles obtidos a partir de salário ou de outro tipo de atividade.
    
4.  Sobre cada rendimento assalariado deve-se informar o total recebido no ano, quanto foi recolhido de imposto na fonte e quanto foi pago de INSS. O valor tributável corresponde ao recebido menos o INSS.
    
5.  Os rendimentos não assalariados são informados como um conjunto de receitas e despesas mensais. Deve-se declarar cada valor recebido em cada mês e cada valor gasto em cada mês com aquela atividade (ex: todos os valores recebidos em uma loja e todas as despesas da loja). A soma das diferenças entre o recebido e o gasto em cada mês é que irá definir o total tributável daquela fonte de renda. Se em algum mês o valor for negativo, então não é computado.
    
6.  Para efeitos de cálculo do imposto a pagar deve-se calcular a “base de cálculo”. A base de cálculo é obtida somando-se os totais tributáveis de todos os rendimentos e subtraindo-se os valores dos bônus e os impostos já recolhidos na fonte (dos rendimentos assalariados). Os bônus são calculados como segue:
    

	-  Em relação às despesas do próprio contribuinte podem-se abater 50% do valor de cada despesa com saúde ou educação até um limite de $10000,00.
    
	-  Em relação às despesas dos dependentes podem-se abater 100% das despesas com educação (até um limite de $5000,00 por dependente) e 50% das despesas com saúde (até um limite de $3000,00 por dependente).
    

7.  Os contribuintes não são obrigados a declarar as despesas. Aqueles que declaram fazem a “declaração completa” e os que não declaram as despesas fazem a declaração simplificada. Os que fazem a declaração simplificada tem um bônus fixo de $8000,00 mais $4000,00 por dependente.
    
8.  Uma vez obtida a base de cálculo o cálculo do imposto a pagar ocorre conforme as seguintes faixas:

	-  Base de cálculo até $ 15000,00 no ano é considerada isenta.
    
	-  A faixa entre $ 15001,00 até 35000,00 deve pagar 15% de imposto.
    
	-  Os valores que excederem 35000,00 são tributados em 30%.


O que deve ser feito
================

- [ ] Anotar as interfaces com JML especificando corretamente a forma de cálculo do imposto e demais métodos das interfaces. **2 pontos**
    
- [ ] Definir um conjunto de drivers de teste capazes de testar adequadamente a implementação destas interfaces. **2 pontos**
    
- [ ] Implementar as interfaces especificadas de maneira a dispor de uma API capaz de fazer o cálculo do imposto. **2 pontos**
    
- [ ] Testar a API desenvolvida usando os drivers de teste previamente elaborados.
    
- [ ] Relatar os principais problemas encontrados e reparar a API e/ou o conjunto de casos de teste até atingir um nível de qualidade satisfatório. **1 ponto**
    
- [ ] Usando uma arquitetura em 3 camadas e padrões de projeto, implementar uma aplicação que demonstra o uso da API. Além do cálculo propriamente dito a aplicação deve ser capaz de persistir os dados dos contribuintes. **3 pontos**
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTgwMDczMTY5NiwxMDY4MjYxMDkwLC01NT
YwNTQ0MDhdfQ==
-->
