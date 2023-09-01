package hot100;

public class Solution394 {
    public String decodeString(String s) {
        StringBuilder ans = new StringBuilder();




    }

    public String handle(String s, int begin){
        StringBuilder ans = new StringBuilder();
        int num = 0,index = begin;

        while (index <= s.length()){
            char cur = s.charAt(index);
            if(cur >= 'a' && cur <= 'z'){
                ans.append(cur);
                index++;
            }else{
                break;
            }
        }
        String cycle = "";
        while (index <= s.length()){
            char cur = s.charAt(index);
            if(cur >= '0' && cur <= '9'){
                num = num*10 + (cur-'0');
                index++;
            }
            if(cur == '['){
                index++;
                cycle = handle(s, index);
            }
        }


    }
}
