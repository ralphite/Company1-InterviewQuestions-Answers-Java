/**
Convert a string to integer.
*/

/*
null check
trim
scan till first char which is not among [+-0-9]
discard this char and all the rest
save sign
long n
n*=10
n+=next digit
if(n > 1L<<31) stop
apply sign
if n <=INT_MIN return INT_MIN
if n >= INT_MAX return INTMAX
return (int)n
*/

public class Solution {
    public static int a2i(String s) {
        s = s.trim();
        boolean isNegative = false;
        if(s.charAt(0) == '+') {
            s = s.substring(1);
        }
        else if(s.charAt(0) == '-') {
            isNegative = true;
            s = s.substring(1);
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c - '0' < 0 || c - '9' > 0) {
                s = s.substring(0, i);
                break;
            }
        }
        long n = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = Integer.parseInt(Character.toString(c));
            n *= 10;
            n += d;
            if(n > 1L << 31) break;
        }
        if(isNegative) n = -n;
        if(n <= 1 << 31) return 1 << 31;
        else if (n >= 0x7FFFFFFF) return 0x7FFFFFFF;
        return (int)n;
    }
}
