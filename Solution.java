import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int width = in.nextInt();
        int height = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String palavra = in.nextLine();
        char[] letras = palavra.toCharArray();

        int[] posicoes = calcularPosicaoAlfabeto(letras);

        for (int i = 0; i < height; i++) {
            String linha = in.nextLine();

            for (int j = 0; j < posicoes.length; j++) {
                int[] inicioFim = calcularInicioFimPosicaoDiagrama(posicoes[j], width);
                System.out.print(linha.substring(inicioFim[0], inicioFim[1]));
            }
            System.out.println();
        }
        in.close();
    }

    public static int[] calcularPosicaoAlfabeto(char[] caracteres) {
        int[] posicoesNoAlfabeto = new int[caracteres.length];
        int inicioPosicaoNoDiagrama = 0;

        for (int i = 0; i < caracteres.length; i++) {
            int charConvertido = (int) caracteres[i];

            if (charConvertido >= 65 && charConvertido <= 90) {
                inicioPosicaoNoDiagrama = charConvertido - 65;
            } else if (charConvertido >= 97 && charConvertido <= 122) {
                inicioPosicaoNoDiagrama = charConvertido - 97;
            } else {
                inicioPosicaoNoDiagrama = 26;
            }
            posicoesNoAlfabeto[i] = inicioPosicaoNoDiagrama;
        }
        return posicoesNoAlfabeto;
    }

    public static int[] calcularInicioFimPosicaoDiagrama(int posicaoAlfabeto, int width) {
        int[] saida = new int[2];
        if (posicaoAlfabeto == 0) {
            saida[0] = 0;
            saida[1] = width;
        } else {
            saida[0] = posicaoAlfabeto * width;
            saida[1] = width + posicaoAlfabeto * width;
        }
        return saida;
    }

}
