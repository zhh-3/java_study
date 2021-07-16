package save_info;

public class similar {
    static String s0 = "164c7758597dc891bec64138ac8d7492";
    public static void main(String[] args) {
        double similar[] = new double[10];
        String[] ss = new String[11];
        ss[1] = "98f8aecae397bb4af730a4a7829c5b31";
        ss[2] = "b194e1734c1da7cc0923e7636466195c";
        ss[3] = "02700753ca1b28d3a7b3686e7dd90dd8";
        ss[4] = "ff37072408b0a518e2a8be9e812a77ef";
        ss[5] = "eb6c39e7884c7a75e5b3968f9d2688bd";
        ss[6] = "bcf4e1cc39bb3e0cb7b752f3ecae2f8c";
        ss[7] = "62376fd9c46a3d50f3015f44d059aa4e";
        ss[8] = "c8d87ef6490482fa2be63809bbc0e9a7";
        ss[9] = "664f303db3370048813e83a21c7169a0";
        ss[10] = "4c59000a9315b3f974e7e4b42488652f";

        for (int i = 0; i < 10; i++) {
            similar[i] = compare(ss[i+1]);
            System.out.println(similar[i]+"%");
        }
    }

    public static double compare(String s1) {
        int n = 0;
        char[] chars0 = s0.toCharArray();
        char[] chars1 = s1.toCharArray();
        for (int i = 0; i < s0.length(); i++) {
            if (chars0[i] == chars1[i]){
                n++;
            }
        }
        double t = (100.0 * n) / s0.length();
        return t;
    }
}
