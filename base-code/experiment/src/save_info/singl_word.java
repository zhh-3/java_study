package save_info;

public class singl_word {
    public static void main(String[] args) {
        String s = "CHSNARMOIHSCMOOSRCSOTNTEIRYEFTDIHFICHTNFHFEFLWFYEBSSNFATROFDVMCFISFNDFCITVSPRMOMISRMASCMNMOTCFNDIRFDSCMMPSRFITMNBSIWSSNBRTCESCMNMOTSEIHSCMUNIRYWTLLWMRKWTIHFLLPFRITSEIMEIRSNGIHSNBRTCEOSOBSREFNITPFNDSOTCFCITMNEFNDPRFGOFITCSCMNMOTCFNDIRFDSCMMPSRFITMNOFTNIFTNIHSESCURTIYFNDEOMMIHNSEEMAIHSGLMBFLEUPPLYFNDTNDUEIRTFLCHFTNEFNDEUPPMRIIHSOULITLFISRFLIRFDTNGEYEISOBYWMRKTNGIMGSIHSRBRTCECMUNIRTSEWTLLIFCKLSIHSCURRSNICRTETEFNDSNEURSSCMNMOTCGRMWIHHSFDDSDSXPSRIEEFTDIHSATVSCMUNIRTSEHFVSSNISRSDFNSWEIFGSMACMOPRSHSNETVSCMMPSRFITMNIHFIWMULDNMIJUEIAMCUEMNIRFDSBUIMNFWTDSRRFNGSMATEEUSEIMRFTESPSMPLSELTVTNGEIFNDFRDEFNDFCHTSVSFNSCMNMOTCRSBMUND";
        char k[][] = fre(s);
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(k[i][j]+" ");
            }
            System.out.println();
        }
        String words = "";
        char word[] = s.toLowerCase().toCharArray();
        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            int j = c-'a';
            words+=k[j][1];
        }
        System.out.println(words);
    }

    public static char[][] fre(String s) {
        int s1[] = new int[26];
        int T[] = new int[26];
        char f[][] = new char[26][2];
//        char words[] = {'e','a','r','i','o','t','n','s','l','c','u','d','p',
//                'm','h','g','b','f','y','w','k','v','x','z','j','q'};
        char words[] = {'e','t','a','o','n','i','s','l','w','d','h','c','u',
                'm','r','f','g','y','p','b','v','k','j','x','q','z'};
        for (int i = 0; i < 26; i++) {
            T[i] = 0;
            s1[i] = -1;
        }

        char c[] = s.toCharArray();
        //统计词频
        for (int i = 0; i < c.length; i++) {
            int t = c[i]-'A';
            T[t]++;
        }

        for (int i = 0; i < T.length; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int i = 0; i < T.length; i++) {
            System.out.print(T[i]+"\t");
        }
        System.out.println();
        //排序
        for (int i = 0; i < 26; i++) {
            int max = 0;
            int t = -1;
            for (int j = 0; j < 26; j++) {
                boolean flag = true;
                for (int k = 0; k < i; k++) {
                    if (j == s1[k]){
                        flag = false;
                        break;
                    }
                }
                if (flag && T[j] > max){
                    max = T[j];
                    t = j;
                }
            }
            s1[i] = t;
        }
        for (int i = 0; i < 26; i++) {
            f[i][0] = (char)('a' + i);
        }
        for (int i = 0; i < 26; i++) {
            if (s1[i] != -1){
                f[s1[i]][1] = words[i];
            }
        }
        return f;
    }
}
