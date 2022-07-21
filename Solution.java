import java.util.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int width = in.nextInt();
        int height = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }

        String word = in.nextLine().toUpperCase();
        char[] letters = word.toCharArray();
        

        int[] positions = alphabetPositions(letters);

        for (int i = 0; i < height; i++) {
            String line = in.nextLine();

            for (int j = 0; j < positions.length; j++) {
                LetterPosition letterPosition = diagramPosition(positions[j], width);
                System.out.print(line.substring(letterPosition.init, letterPosition.end));
            }
            System.out.println();
        }
        in.close();
    }

    public static int[] alphabetPositions(char[] characters) {
        int[] alphabetPositions = new int[characters.length];
        
        int startDiagramPosition = 0;

        for (int i = 0; i < characters.length; i++) {
            int convertedCharacter = (int) characters[i];

            if (convertedCharacter >= 65 && convertedCharacter <= 90) {
                startDiagramPosition = convertedCharacter - 65;
            } else {
                startDiagramPosition = 26;
            }
            alphabetPositions[i] =  startDiagramPosition;
        }
        return alphabetPositions;
    }

    public static LetterPosition diagramPosition(int alphabetPosition, int width) {
        LetterPosition out = new LetterPosition();
        
        if (alphabetPosition == 0) {
            out.init = 0;
            out.end = width;
        } else {
            out.init = alphabetPosition * width;
            out.end = width + alphabetPosition * width;
        }
        return out;
    }

}

class LetterPosition {
    int init;
    int end;
}
