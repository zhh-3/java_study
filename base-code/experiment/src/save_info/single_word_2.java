package save_info;

public class single_word_2 {
    public static void main(String[] args) {
        String s = "CHSNARMOIHSCMOOSRCSOTNTEIRYEFTDIHFICHTNFHFEFLWFYEBSSNFATROFDVMCFISFNDFCITVSPRMOMISRMASCMNMOTCFNDIRFDSCMMPSRFITMNBSIWSSNBRTCESCMNMOTSEIHSCMUNIRYWTLLWMRKWTIHFLLPFRITSEIMEIRSNGIHSNBRTCEOSOBSREFNITPFNDSOTCFCITMNEFNDPRFGOFITCSCMNMOTCFNDIRFDSCMMPSRFITMNOFTNIFTNIHSESCURTIYFNDEOMMIHNSEEMAIHSGLMBFLEUPPLYFNDTNDUEIRTFLCHFTNEFNDEUPPMRIIHSOULITLFISRFLIRFDTNGEYEISOBYWMRKTNGIMGSIHSRBRTCECMUNIRTSEWTLLIFCKLSIHSCURRSNICRTETEFNDSNEURSSCMNMOTCGRMWIHHSFDDSDSXPSRIEEFTDIHSATVSCMUNIRTSEHFVSSNISRSDFNSWEIFGSMACMOPRSHSNETVSCMMPSRFITMNIHFIWMULDNMIJUEIAMCUEMNIRFDSBUIMNFWTDSRRFNGSMATEEUSEIMRFTESPSMPLSELTVTNGEIFNDFRDEFNDFCHTSVSFNSCMNMOTCRSBMUND";
        char k[][] = new char[26][2];

        k[0][0] = 'a';
        k[0][1] = 'f';

        k[1][0] = 'b';
        k[1][1] = 'b';

        k[2][0] = 'c';
        k[2][1] = 'c';

        k[3][0] = 'd';
        k[3][1] = 'd';

        k[4][0] = 'e';
        k[4][1] = 's';

        k[5][0] = 'f';
        k[5][1] = 'a';

        k[6][0] = 'g';
        k[6][1] = 'g';

        k[7][0] = 'h';
        k[7][1] = 'h';

        k[8][0] = 'i';
        k[8][1] = 't';

        k[9][0] = 'j';
        k[9][1] = 'j';

        k[10][0] = 'k';
        k[10][1] = 'k';

        k[11][0] = 'l';
        k[11][1] = 'l';

        k[12][0] = 'm';
        k[12][1] = 'o';

        k[13][0] = 'n';
        k[13][1] = 'n';

        k[14][0] = 'o';
        k[14][1] = 'm';

        k[15][0] = 'p';
        k[15][1] = 'p';

        k[16][0] = 'q';
        k[16][1] = 'q';

        k[17][0] = 'r';
        k[17][1] = 'r';

        k[18][0] = 's';
        k[18][1] = 'e';

        k[19][0] = 't';
        k[19][1] = 'i';

        k[20][0] = 'u';
        k[20][1] = 'u';

        k[21][0] = 'v';
        k[21][1] = 'v';

        k[22][0] = 'w';
        k[22][1] = 'w';

        k[23][0] = 'x';
        k[23][1] = 'x';

        k[24][0] = 'y';
        k[24][1] = 'y';

        k[25][0] = 'z';
        k[25][1] = 'z';
        String words = "";
        char word[] = s.toLowerCase().toCharArray();
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            int j = c-'a';
            words+=k[j][1];
        }
        System.out.println(words);
    }
}
