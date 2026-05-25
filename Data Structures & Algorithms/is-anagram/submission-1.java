class Solution {
        public boolean isAnagram(String s, String t) {
            char[] ss = s.toCharArray();
            char[] tt = t.toCharArray();
            if (s.length() != t.length()) {
                return false;
            }

            int[] freq = new int[26];

            for (int i = 0; i < s.length(); i++) {
                freq[ss[i] - 'a']++;
                freq[tt[i] - 'a']--;
            }

            for (int n : freq) {
                if (n != 0) {
                    return false;
                }
            }
            return true;
        }
    }