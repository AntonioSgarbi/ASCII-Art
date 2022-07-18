const width = parseInt(readline());
const height = parseInt(readline());
const palavra = readline();

posicoes = calcularPosicaoAlfabeto(palavra);

for (let i = 0; i < height; i++) {
    const line = readline();
    let out = '';
    for (let j = 0; j < posicoes.length; j++) {
        let inicioFim = calcularInicioFimPosicaoDiagrama(posicoes[j], width);
        out = out.concat(line.substring(inicioFim[0], inicioFim[1]));
    }
    console.log(out);
}

function calcularPosicaoAlfabeto(palavra) {
    let posicoesNoAlfabeto = [];
    palavra
        .toLowerCase()
        .split('')
        .forEach(letra => {
            if (letra.charCodeAt(0) >= 97 && letra.charCodeAt(0) <= 122)
                posicoesNoAlfabeto.push(letra.charCodeAt(0) - 97);
            else
                posicoesNoAlfabeto.push(26);
        });
    return posicoesNoAlfabeto;
}

function calcularInicioFimPosicaoDiagrama(posicaoAlfabeto, width) {
    let saida = [];
    if (posicaoAlfabeto == 0) {
        saida[0] = 0;
        saida[1] = width;
    } else {
        saida[0] = posicaoAlfabeto * width;
        saida[1] = width + posicaoAlfabeto * width;
    }
    return saida;
}
