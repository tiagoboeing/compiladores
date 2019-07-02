# Exemplos de códigos

## Sintaxe

### Declaração de variáveis

Variáveis devem ser declaradas utilizando `tipo`: `identificador`.


| Tipo   | Dotnet  |
| ------ | ------- |
| int    | int64   |
| float  | float64 |
| bool   | bool    |
| char   | string  |
| string | string  |

> Ex.: `int: var1.`

#### Exemplo de declaração

```
main begin
    int: a.
    float: b.
	bool: c.

	a = false.
	b = true.

	write(a == b).
end
```

### Fim de linha

Ao final de cada linha é necessário adicionar um ponto final (`.`)

### Corpo do programa

O corpo do programa deve iniciar obrigatoriamente com `main begin`. A finalização é realizada com a instrução `end`.

> `main begin` + corpo do programa + `end`

```
main begin
	-- PROGRAMA AQUI (comentário de linha)
end
```

## Utilizando comentários

`-- exemplo de comentário de linha`

`#| exemplo de comentário de bloco |#` 

## Loops

### whileTrueDo

```
main begin
    int: valor.
    read(valor).
    (valor < 0) whileTrueDo     
        read(valor).    
    end.
    (valor == 0) whileFalseDo   
        write(valor, \n).
        valor -= 1.
    end.
end
```

## if

```
main begin
    float: valor.
    read(valor).

    (valor > 0.0) ifTrueDo 
        write("maior").
    ifFalseDo
        write("menor ou igual"). 
    end.
end
```

```
main begin
    int: lado, area.
    read(lado).
    area = 0.
    
    (lado > 0) ifTrueDo 
        area = lado * lado. 
    end.
    
    write(area).
end
```